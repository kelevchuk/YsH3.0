package hello.controllers;

import hello.HibernateUtil;
import hello.models.AllDistricts;
import hello.models.Greeting;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LevchukK.E. on 21.04.17.
 */
@RestController
public class AllDistrictController {
    @RequestMapping("/alldistrict")
    public AllDistricts allDistricts(String district){
        Session session =null;
        List list = new ArrayList();
        try {
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
        return new AllDistricts(s);

        }
    }
