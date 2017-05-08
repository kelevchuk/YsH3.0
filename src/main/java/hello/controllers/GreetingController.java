package hello.controllers;

import java.util.ArrayList;


import hello.HibernateUtil;
import hello.models.Greeting;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @RequestMapping("/test")
    public Greeting greeting(Object sas,Object nesas) {

        Session session =null;
        ArrayList<Object> sasq = null;
        ArrayList<Object> nesasq = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

//            String hql = "select cl.nameClub, num.number  from ClubEntity cl " +
//                    "join cl.clubNumbersByIdClub cn " +
//                    "join  cn.numberByIdNumber num " +
//                    "where cl.idClub=2 ";
           sasq = (ArrayList<Object>) session.createQuery("select cl.nameClub from ClubEntity cl where cl.idClub=1").list();
           nesasq = (ArrayList<Object>) session.createQuery("select t.nameTrainer from ClubEntity cl " +
                   "join cl.clubTrainersByIdClub ct " +
                   "join ct.trainerByIdTrainer t" +
                   " where cl.idClub=1").list();
        }
            finally {
                if (session !=null && session.isOpen()) {
                    session.close();
                }
            }
        return new Greeting(sasq,nesasq);

    }
}
