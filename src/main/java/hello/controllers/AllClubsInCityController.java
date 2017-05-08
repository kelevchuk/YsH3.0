package hello.controllers;

import hello.HibernateUtil;
import hello.models.AllClubsCity;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by LevchukK.E. on 21.04.17.
 */
//TODO все клубы по городу
@RestController
public class AllClubsInCityController {
    @RequestMapping("/allclubsc")
    public AllClubsCity allClubsCity(@RequestParam(defaultValue = "1",value = "city") Long city, Object nameClub){
        Session session =null;
        ArrayList<Object> query = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            query = (ArrayList<Object>) session.createQuery("select cl.nameClub from ClubEntity cl " +
                    "join cl.addressByIdClub ad " +
                    "join ad.cityByCity cit where cit.id=:city").setParameter("city",city).list();

        }
        finally {
            if (session !=null && session.isOpen()) {
                session.close();
            }
        }
        return new AllClubsCity(query);
    }

}
