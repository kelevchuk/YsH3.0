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
    @RequestMapping(value = "/age", method = RequestMethod.GET)
    @ResponseBody
    public Age age(@RequestParam("age") long age){
        Session session = null;
        List list1 = new ArrayList<String>();
        try {

            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            Query query1 = session.createQuery("select name from FullClubsEntity where age=:age")
                    .setParameter("age",age);
            for (Object a : query1.list()) {
                list1.add(a);
            }
        }
        finally{
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        StringBuffer builder1 = new StringBuffer();
        for (Object o : list1) {
            builder1.append(o);
        }



        String a = builder1.substring(0);
        return new Age(a);
    }
}
