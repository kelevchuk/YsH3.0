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
public class AllClubsInCityInDistrictController {
    @RequestMapping("/allclubscd")
    public AllClubs allClubs(@RequestParam(defaultValue ="1", value = "city") Long city,
                             @RequestParam("district") Long district, String nameClub){
        Session session =null;
        List list = new ArrayList();
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("select cl.nameClub from ClubEntity cl " +
                    "join cl.addressByIdClub a " +
                    "join a.cityByCity cit " +
                    "join a.districtByDistrict dis where cit.id=:city and dis.id=:district")
                    .setParameter("city",city)
                    .setParameter("district",district);
            int i = 1;
            for (Object a : query.list()) {
                list.add(i+": "+a+";   ");
                i++;
            }
        }
        finally {
            if (session !=null && session.isOpen()) {
                session.close();
            }
        }
        StringBuffer builder = new StringBuffer();
        for (Object o : list) {
            builder.append(o);
        }
        String s = builder.substring(0);
        return new AllClubs(s);
    }

}
