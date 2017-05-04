package hello.controllers;

import hello.HibernateUtil;
import hello.models.AllClubs;
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
public class FullInfController {
    @RequestMapping("/fullinf")
    public AllClubs allClubs(@RequestParam(defaultValue = "1", value = "city") Long city,
                             @RequestParam("id") Long id, String nameClub) {
        Session session = null;
        List listName = new ArrayList();
        List listAddr = new ArrayList();
        List listSport = new ArrayList();
        List listCoach = new ArrayList();
        List listNum = new ArrayList();
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query queryName = session.createQuery("select cl.nameClub from ClubEntity cl " +
                    "join cl.addressByIdClub ad " +
                    "join ad.cityByCity cit " +
                    "where cit.id=:city and cl.id=:id")
                    .setParameter("city", city)
                    .setParameter("id", id);

            Query queryAddress = session.createQuery("select ad.valueAddress from ClubEntity cl " +
                    "join cl.addressByIdClub ad " +
                    "join ad.cityByCity cit " +
                    "where cit.id=:city and cl.id=:id")
                    .setParameter("city", city)
                    .setParameter("id", id);
            Query queryKindSport = session.createQuery("select st.nameSport from ClubEntity cl " +
                    "join cl.addressByIdClub ad " +
                    "join ad.cityByCity ct " +
                    "join cl.clubSportsByIdClub sp " +
                    "join sp.sportTypeByIdSport st " +
                    "where ct.id=:city and cl.id=:id").setParameter("city", city).setParameter("id", id);
            Query queryCoach = session.createQuery("select tr.nameTrainer from ClubEntity cl " +
                    "join cl.addressByIdClub ad " +
                    "join ad.cityByCity cit " +
                    "join cl.clubTrainersByIdClub ct " +
                    "join ct.trainerByIdTrainer tr " +
                    "where cit.id=:city and cl.id=:id").setParameter("city", city).setParameter("id", id);
            Query queryNumber = session.createQuery("select n.number from ClubEntity cl " +
                    "join cl.addressByIdClub ad " +
                    "join ad.cityByCity cit " +
                    "join cl.clubNumbersByIdClub cn " +
                    "join cn.numberByIdClub n " +
                    "where cit.id=:city and cl.id=:id").setParameter("city", city).setParameter("id", id);


            for (Object a : queryName.list()) {
                listName.add(": " + a + ";   ");

            }
            for (Object a : queryAddress.list()) {
                listAddr.add(": " + a + ";   ");

            }
            for (Object a : queryKindSport.list()) {
                listSport.add(": " + a + ";   ");

            }
            for (Object a : queryCoach.list()) {
                listCoach.add(": " + a + ";   ");

            }
            for (Object a : queryNumber.list()) {
                listNum.add(": " + a + ";   ");

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
            StringBuffer builderSport = new StringBuffer();
            for (int k = 0; k < listSport.size(); k++) {
                builderSport.append(listSport.get(k) + " ");
            }
            StringBuffer builderCoach = new StringBuffer();
            for (int k = 0; k < listCoach.size(); k++) {
                builderCoach.append(listCoach.get(k) + " ");
            }
            StringBuffer builderNum = new StringBuffer();
            for (int k = 0; k < listNum.size(); k++) {
                builderNum.append(listNum.get(k) + " ");
            }
            String s = builderName.append("Адрес: ").append(builderAddr)
                                                    .append("Тренеры: ").append(builderCoach)
                                                    .append("Телефон: ").append(builderNum)
                                                    .append("Виды спорта: ").append(builderSport).substring(0);
            return new AllClubs(s);
        }
    }



