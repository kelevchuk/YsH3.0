package hello.controllers;

import hello.HibernateUtil;
import hello.models.AllClubs;
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
                             @RequestParam("age") Long id, String nameClub) {
        Session session = null;
        List listName = new ArrayList();
        List listAddr = new ArrayList();
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query queryName = session.createQuery("select cl.nameClub from ClubEntity cl " +
                    "join cl.addressByIdClub ad " +
                    "join ad.cityByCity cit " +
                    "join cl.clubAgesByIdClub ca " +
                    "join  ca.ageByIdAge ag " +
                    "where cit.id=:city and ag.idAge=:age")
                    .setParameter("city", city)
                    .setParameter("age", id);

            Query queryAddress = session.createQuery("select ad.valueAddress from ClubEntity cl " +
                    "join cl.addressByIdClub ad " +
                    "join ad.cityByCity cit " +
                    "join cl.clubAgesByIdClub ca " +
                    "join ca.ageByIdAge ag " +
                    "where cit.id=:city and ag.idAge=:age")
                    .setParameter("city", city)
                    .setParameter("age", id);


            for (Object a : queryName.list()) {
                listName.add(": " + a + ";   ");

            }
            for (Object a : queryAddress.list()) {
                listAddr.add(": " + a + ";   ");

            }

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        StringBuffer builderName = new StringBuffer();
        for (int k = 0; k < listName.size(); k++) {
            builderName.append(k + 1 + " " + listName.get(k) + " ");
        }
        StringBuffer builderAddr = new StringBuffer();
        for (int k = 0; k < listAddr.size(); k++) {
            builderAddr.append(listAddr.get(k) + " ");
        }
        String s = builderName.append("Адрес: ").append(builderAddr).substring(0);
        return new ClubAge(s);
    }
}