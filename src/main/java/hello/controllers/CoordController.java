package hello.controllers;

import hello.HibernateUtil;
import hello.models.AllSports;
import hello.models.Coord;
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
public class CoordController {
    @RequestMapping("/clubcoord")
    public Coord coord (@RequestParam(defaultValue = "1", value = "city") Long city,
                        @RequestParam("club") Long club, Float x,Float y) {
        Session session = null;
        List cx = new ArrayList<Float>();
        List cy = new ArrayList<Float>();
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query queryX = session.createQuery("select ad.coordX from ClubEntity cl " +
                    "join cl.addressByIdClub ad " +
                    "join ad.cityByCity cit" +
                    " where cit.id=:city and cl.id=:club ")
                    .setParameter("city",city)
                    .setParameter("club",club);
           //cx = (List) queryX;
            for (Object f:queryX.list()){
               cx.add(f);
            }
            Query queryY = session.createQuery("select ad.coordY from ClubEntity cl " +
                    "join cl.addressByIdClub ad " +
                    "join ad.cityByCity cit" +
                    " where cit.id=:city and cl.id=:club ")
                    .setParameter("city",city)
                    .setParameter("club",club);
            //cy = (List) queryY;
            for (Object f:queryY.list()){
                cy.add(f);
            }

        }
        finally {
            if (session !=null && session.isOpen()) {
                session.close();
            }
        }
        Float x1=(Float)cx.get(0);
        Float y1= (Float)cy.get(0);
        return new Coord(x1,y1);
    }

}

