package hello.controllers;

import hello.HibernateUtil;
import hello.models.AllClubs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LevchukK.E. on 21.04.17.
 */

@RestController
public class AllClubsController {
    @RequestMapping("/allclubs")
    public AllClubs allClubs(String nameClub){
        Session session =null;
        List list = new ArrayList();
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("select name from FullClubsEntity ");
            int i = 1;
            for (Object a : query.list()) {
                list.add(i+": "+a+";   ");
                i++;
            }
        }
        finally {
            if (session !=null && session.isOpen()) {
                session.close();
            }
        }
        StringBuffer builder = new StringBuffer();
        for (Object o : list) {
            builder.append(o);
        }
        String s = builder.substring(0);
        return new AllClubs(s);
    }

}
