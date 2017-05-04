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
 * Created by LevchukK.E. on 21.04.17.
 */
//TODO все клубы по городу
@RestController
public class AllClubsInCityInDistrictWithSportController {
    @RequestMapping("/allclubscds")
    public AllClubs allClubs(@RequestParam(defaultValue ="1", value = "city") Long city,
                             @RequestParam("district") Long district,
                             @RequestParam("sport") Long sport, String nameClub){
        Session session =null;
        List listName = new ArrayList();
        List listAddr = new ArrayList();
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query queryName = session.createQuery("select cl.nameClub from ClubEntity cl " +
                    "join  cl.clubSportsByIdClub cs1  " +
                    "join cs1.sportTypeByIdSport st1  " +
                    "join  cl.addressByIdClub addr  " +
                    "join addr.districtByDistrict dst " +
                    "join addr.cityByCity cit where cit.id=:city and dst.id=:district and st1.idSport=:sport")
                    .setParameter("city",city)
                    .setParameter("district",district)
                    .setParameter("sport",sport);

            Query queryAddress = session.createQuery("select addr.valueAddress from AddressEntity addr join addr.clubByIdAddress cl " +
                    "join  cl.clubSportsByIdClub cs1  " +
                    "join cs1.sportTypeByIdSport st1  " +
                    "join addr.districtByDistrict dst " +
                    "join addr.cityByCity cit where cit.id=:city and dst.id=:district and st1.idSport=:sport")
                    .setParameter("city",city)
                    .setParameter("district",district)
                    .setParameter("sport",sport);


            int i = 1;

            for (Object a : queryName.list()) {
                listName.add(": "+a+";   ");

            }
            for (Object a : queryAddress.list()) {
                listAddr.add(": "+a+";   ");

            }

        }
        finally {
            if (session !=null && session.isOpen()) {
                session.close();
            }
        }
        StringBuffer builder = new StringBuffer();
        for (int k=0;k<listName.size();k++) {
            builder.append(k+1+" "+listName.get(k)+" "+listAddr.get(k));
        }
        String s = builder.substring(0);
        return new AllClubs(s);
    }

}
