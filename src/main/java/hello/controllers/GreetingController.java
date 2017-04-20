package hello.controllers;

import java.util.ArrayList;
import java.util.List;


import hello.HibernateUtil;
import hello.models.Greeting;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @RequestMapping("/greeting")
    public Greeting greeting(String sas) {

        Session session =null;
        List list = new ArrayList();
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("select noteName from NotesEntity");
            for (Object a : query.list()) {
                list.add(a+";   ");
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
        return new Greeting(s);

    }
}
