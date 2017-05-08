package hello.controllers;

import hello.HibernateUtil;
import hello.models.AllDistricts;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LevchukK.E. on 21.04.17.
 */
@RestController
public class AllDistrictController {
    @RequestMapping("/alldistrict")
    public AllDistricts allDistricts(@RequestParam(defaultValue ="1", value = "city") Object city){

        Session session =null;
        ArrayList<Object> query = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            query = (ArrayList<Object>) session.createQuery("select nameDistrict from DistrictEntity").list();

        }
        finally {
            if (session !=null && session.isOpen()) {
                session.close();
            }
        }

        return new AllDistricts(query);

        }
    }
