package hello.controllers;

import hello.HibernateUtil;
import hello.models.ClubAgeSport;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by LevchukK.E. on 10.05.17.
 */
@RestController
public class ClubAgeSportController {
        @RequestMapping("/cas")
        public ClubAgeSport clubAgeSport(@RequestParam(defaultValue = "1", value = "city") Long city,
                                         @RequestParam("age") Long age,
                                         @RequestParam("sport") Long sport, Object nameClub) {
            Session session = null;
            ArrayList<Object> query = null;
            try {
                session = HibernateUtil.getSessionFactory().getCurrentSession();
                session.beginTransaction();
                query = (ArrayList<Object>) session.createQuery("select sp.nameSport, cl.nameClub, ad.valueAddress from ClubEntity cl " +
                        "join cl.addressByIdClub ad " +
                        "join ad.cityByCity cit " +
                        "join cl.clubAgesByIdClub ca " +
                        "join  ca.ageByIdAge ag " +
                        "join cl.clubSportsByIdClub cs " +
                        "join cs.sportTypeByIdSport sp " +
                        "where cit.id=:city and ag.idAge=:age and sp.idSport=:sport")
                        .setParameter("city", city)
                        .setParameter("age", age)
                        .setParameter("sport", sport)
                        .list();

            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }

            return new ClubAgeSport(query);
        }
    }

