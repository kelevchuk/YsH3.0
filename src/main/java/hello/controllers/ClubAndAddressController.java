package hello.controllers;

import hello.HibernateUtil;
import hello.models.ClubAndAddress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ClubAndAddressController {
    @RequestMapping(value = "value", method = RequestMethod.GET)
    @ResponseBody
    public ClubAndAddress clubAndAddress(@RequestParam("sport") String sport ) {

        Session session = null;
        String sport1 = sport;
        List list1 = new ArrayList<String>();
        List list2 = new ArrayList<String>();
        List list3 = new ArrayList<String>();

        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            Query query1 = session.createQuery("select id from SportTypeEntity where sportName like :name")
                    .setParameter("name",sport);
            for (Object a : query1.list()) {
                list1.add(a);
            }
            Long i = (Long)list1.get(0);

            Query query2 = session.createQuery("select name from FullClubsEntity where sportFk=:id")
                    .setParameter("id",i);
            Query query3 = session.createQuery("select address from FullClubsEntity where sportFk=:id")
                    .setParameter("id",i);
            for (Object b : query3.list()){
                list2.add(b);
            }
            int k=1;
            String y =list2.get(k-1).toString();
            for (Object c : query2.list()){
                list3.add("Секция: "+c+";  "+"Адрес: "+y+"               ");
                k++;
            }
        }
        finally{
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            StringBuffer builder1 = new StringBuffer();
            for (Object o : list3) {
                builder1.append(o);
            }



            String a = builder1.substring(0);

            return new ClubAndAddress(a);
        }
    }



