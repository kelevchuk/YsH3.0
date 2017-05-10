package hello.controllers;

import hello.HibernateUtil;
import hello.models.Section;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by LevchukK.E. on 08.05.17.
 */
@RestController
public class SectionController {
    @RequestMapping("/section")
    public Section section(@RequestParam(defaultValue = "1", value = "city") Long city,
                           @RequestParam("section") Long section, Object sections, Object numberSection) {
        Session session = null;
        ArrayList<Object> sect = null;
        ArrayList<Object> num = null;

        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            sect = (ArrayList<Object>)session.createQuery(" " +
                    "select club.nameClub, addr.valueAddress, stype.nameSport, age.valueAge, sec.schedule, train.nameTrainer, trnum.number " +
                    " from SectionEntity sec " +
                    "join sec.clubSportBySectionFk cs " +
                    "join cs.clubByIdClub club " +
                    "join club.addressByIdClub addr " +
                    "join addr.cityByCity city " +
                    "join cs.sportTypeByIdSport stype " +
                    "join sec.ageByIdAgeFk age " +
                    "join sec.trainerByIdTrainerFk train " +
                    "join train.numberByIdNumberFk trnum " +
                    " where city.id=:city and sec.id=:section ")
                    .setParameter("city",city)
                    .setParameter("section",section)
                    .list();
            num = (ArrayList<Object>)session.createQuery("select num.number from SectionEntity sec " +
                    "join sec.clubSportBySectionFk cs " +
                    "join cs.clubByIdClub club " +
                    "join club.clubNumbersByIdClub cn " +
                    "join cn.numberByIdNumber num " +
                    "join club.addressByIdClub addr " +
                    "join addr.cityByCity city " +
                    " where city.id=:city and sec.id=:section ")
                    .setParameter("city",city)
                    .setParameter("section",section)
                    .list();
        } finally {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

            return new Section(sect, num);
}
    }

