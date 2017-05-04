package hello.controllers;

import java.util.ArrayList;
import java.util.List;


import hello.HibernateUtil;
import hello.models.Greeting;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @RequestMapping("/test")
    public Greeting greeting(String sas) {

        Session session =null;
        List list = new ArrayList<String>();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("select d.nameDistrict from AddressEntity add join add.districtByDistrict d where add.id=1");
            for (Object a : query.list()) {
                list.add(a + ";   ");
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
        return new Greeting(s);

    }
}
