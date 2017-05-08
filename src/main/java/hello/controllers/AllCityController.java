package hello.controllers;

import hello.HibernateUtil;
import hello.models.AllCity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LevchukK.E. on 21.04.17.
 */
@RestController
public class AllCityController {
    @RequestMapping("/allcity")
    public AllCity allCity(Object nameCity){
        Session session =null;
        ArrayList<Object> query = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            query = (ArrayList<Object>)session.createQuery("select nameCity from CityEntity ").list();

        }
        finally {
            if (session !=null && session.isOpen()) {
                session.close();
            }
        }

        return new AllCity(query);
    }

}
