package hello.controllers;

import hello.HibernateUtil;
import hello.models.ClubAge;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LevchukK.E. on 04.05.17.
 */
@RestController
public class ClubAgeController {
    @RequestMapping("/clubage")
    public ClubAge clubAge(@RequestParam(defaultValue = "1", value = "city") Long city,
                             @RequestParam("age") Long id, Object nameClub) {
        Session session = null;
        ArrayList<Object> query = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            query = (ArrayList<Object>) session.createQuery("select cl.nameClub, ad.valueAddress from ClubEntity cl " +
                    "join cl.addressByIdClub ad " +
                    "join ad.cityByCity cit " +
                    "join cl.clubAgesByIdClub ca " +
                    "join  ca.ageByIdAge ag " +
                    "where cit.id=:city and ag.idAge=:age")
                    .setParameter("city", city)
                    .setParameter("age", id).list();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return new ClubAge(query);
    }
}