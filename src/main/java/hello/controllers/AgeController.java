package hello.controllers;

import hello.HibernateUtil;
import hello.models.Age;
import org.hibernate.Session;

import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LevchukK.E. on 21.04.17.
 */
@RestController
public class AgeController {
    @RequestMapping("/age")
    public Age age( Object age){
        Session session = null;
        ArrayList<Object> query = null;
        try {

            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            query = (ArrayList<Object>) session.createQuery("select a.valueAge from AgeEntity a ").list();

        }
        finally{
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return new Age(query);
    }
}
