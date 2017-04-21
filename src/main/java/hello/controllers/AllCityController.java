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
    public AllCity allCity(String nameCity){
        Session session =null;
        List list = new ArrayList();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("select nameCity from CityEntity ");
            for (Object a : query.list()) {
                list.add(a+";   ");
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
        return new AllCity(s);
    }

}
