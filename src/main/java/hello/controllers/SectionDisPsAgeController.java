package hello.controllers;

import hello.HibernateUtil;
import hello.models.SectionDisSpAge;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by LevchukK.E. on 10.05.17.
 */
@RestController
public class SectionDisPsAgeController {
    @RequestMapping("/secparam")
    public SectionDisSpAge sectionDisSpAge(@RequestParam(defaultValue = "1", value = "city") Long city,
                                           @RequestParam("distr") Long distr,
                                           @RequestParam("sport") Long sport,
                                           @RequestParam("age") Long age,
                                           Object sections) {
        Session session = null;
        ArrayList<Object> sect = null;

        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            sect = (ArrayList<Object>)session.createQuery(" " +
                    "select club.nameClub, addr.valueAddress, stype.nameSport, age.valueAge, sec.schedule, train.nameTrainer, trnum.number " +
                    " from SectionEntity sec " +
                    "join sec.clubSportBySectionFk cs " +
                    "join cs.sportTypeByIdSport ctype " +
                    "join cs.clubByIdClub club " +
                    "join club.addressByIdClub addr " +
                    "join addr.cityByCity city " +
                    "join addr.districtByDistrict distr " +
                    "join cs.sportTypeByIdSport stype " +
                    "join sec.ageByIdAgeFk age " +
                    "join sec.trainerByIdTrainerFk train " +
                    "join train.numberByIdNumberFk trnum " +
                    " where city.id=:city and distr.idDistrict=:distr and stype.idSport=:sport and age.idAge=:age  ")
                    .setParameter("city",city)
                    .setParameter("distr", distr)
                    .setParameter("sport", sport)
                    .setParameter("age", age)
                    .list();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return new SectionDisSpAge(sect);
    }
}
