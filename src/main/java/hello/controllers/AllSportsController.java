package hello.controllers;

import hello.HibernateUtil;
import hello.models.AllClubs;
import hello.models.AllSports;
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
public class AllSportsController {
        @RequestMapping("/allsports")
        public AllSports allSports(String nameSports){
            Session session =null;
            List list = new ArrayList();
            try {
                SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
                session = HibernateUtil.getSessionFactory().getCurrentSession();
                session.beginTransaction();
                Query query = session.createQuery("select sportName from SportTypeEntity ");
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
            return new AllSports(s);
        }

    }

