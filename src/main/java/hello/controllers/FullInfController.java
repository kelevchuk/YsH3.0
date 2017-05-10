package hello.controllers;

import hello.HibernateUtil;
import hello.models.FullInf;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by LevchukK.E. on 04.05.17.
 */
@RestController
public class FullInfController {
    @RequestMapping("/fullinf")
    public FullInf fullInf(@RequestParam(defaultValue = "1", value = "city") Long city,
                           @RequestParam("club") Long id, Object nameClub, Object nameSport, Object coach, Object number) {
        Session session = null;
        ArrayList<Object> club = null;
        ArrayList<Object> sport = null;
        ArrayList<Object> coachq = null;
        ArrayList<Object> num = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            club = (ArrayList) session.createQuery("select cl.nameClub, ad.valueAddress from ClubEntity cl " +
                    "join cl.addressByIdClub ad " +
                    "join ad.cityByCity cit " +
                    "where cit.id=:city and cl.id=:id")
                    .setParameter("city", city)
                    .setParameter("id", id).list();

            sport = (ArrayList)session.createQuery("select st.nameSport from ClubEntity cl " +
                    "join cl.addressByIdClub ad " +
                    "join ad.cityByCity ct " +
                    "join cl.clubSportsByIdClub sp " +
                    "join sp.sportTypeByIdSport st " +
                    "where ct.id=:city and cl.id=:id")
                    .setParameter("city", city)
                    .setParameter("id", id).list();
            coachq = (ArrayList)session.createQuery("select tr.nameTrainer from ClubEntity cl " +
                    "join cl.addressByIdClub ad " +
                    "join ad.cityByCity cit " +
                    "join cl.clubTrainersByIdClub ct " +
                    "join ct.trainerByIdTrainer tr " +
                    "where cit.id=:city and cl.id=:id")
                    .setParameter("city", city)
                    .setParameter("id", id).list();
            num = (ArrayList)session.createQuery("select n.number from ClubEntity cl " +
                    "join cl.addressByIdClub ad " +
                    "join ad.cityByCity cit " +
                    "join cl.clubNumbersByIdClub cn " +
                    "join cn.numberByIdNumber n " +
                    "where cit.id=:city and cl.id=:id")
                    .setParameter("city", city)
                    .setParameter("id", id).list();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

            return new FullInf(club,sport,coachq,num);
        }
    }



