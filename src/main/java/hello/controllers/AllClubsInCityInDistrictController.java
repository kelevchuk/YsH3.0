package hello.controllers;

import hello.HibernateUtil;
import hello.models.AllClubsCity;
import hello.models.AllClubsCityDistr;
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
public class AllClubsInCityInDistrictController {
    @RequestMapping("/allclubscd")
    public AllClubsCityDistr allClubsCityDistr(@RequestParam(defaultValue ="1", value = "city") Long city,
                                               @RequestParam("district") Long district, Object nameClub){
        Session session =null;
        ArrayList<Object> query = null;
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            query = (ArrayList<Object>) session.createQuery("select cl.nameClub from ClubEntity cl " +
                    "join cl.addressByIdClub a " +
                    "join a.cityByCity cit " +
                    "join a.districtByDistrict dis where cit.id=:city and dis.id=:district")
                    .setParameter("city",city)
                    .setParameter("district",district).list();

        }
        finally {
            if (session !=null && session.isOpen()) {
                session.close();
            }
        }

        return new AllClubsCityDistr(query);
    }

}
