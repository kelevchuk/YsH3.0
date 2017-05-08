package hello.controllers;

import hello.HibernateUtil;
import hello.models.AllClubsCity;
import hello.models.AllClubsCityDistrSport;
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
 * Created by LevchukK.E. on 21.04.17.
 */
//TODO все клубы по городу
@RestController
public class AllClubsInCityInDistrictWithSportController {
    @RequestMapping("/allclubscds")
    public AllClubsCityDistrSport allClubsCityDistrSport(@RequestParam(defaultValue ="1", value = "city") Long city,
                                                         @RequestParam("district") Long district,
                                                         @RequestParam("sport") Long sport, Object nameClub){
        Session session =null;
        ArrayList<Object> query = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
           query =(ArrayList<Object>)session.createQuery("select cl.nameClub, addr.valueAddress from ClubEntity cl " +
                    "join  cl.clubSportsByIdClub cs1  " +
                    "join cs1.sportTypeByIdSport st1  " +
                    "join  cl.addressByIdClub addr  " +
                    "join addr.districtByDistrict dst " +
                    "join addr.cityByCity cit where cit.id=:city and dst.id=:district and st1.idSport=:sport")
                    .setParameter("city",city)
                    .setParameter("district",district)
                    .setParameter("sport",sport).list();

        }
        finally {
            if (session !=null && session.isOpen()) {
                session.close();
            }
        }

        return new AllClubsCityDistrSport(query);
    }

}
