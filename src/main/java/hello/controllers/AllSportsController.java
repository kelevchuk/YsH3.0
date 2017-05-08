package hello.controllers;

import hello.HibernateUtil;
import hello.models.AllSports;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LevchukK.E. on 21.04.17.
 */
@RestController
public class AllSportsController {
        @RequestMapping("/allsports")
        public AllSports allSports(Object nameSports){
            Session session =null;
            ArrayList<Object> query = null;
            try {
                session = HibernateUtil.getSessionFactory().getCurrentSession();
                session.beginTransaction();
                query = (ArrayList<Object>) session.createQuery("select st.nameSport from SportTypeEntity st ").list();
            }
            finally {
                if (session !=null && session.isOpen()) {
                    session.close();
                }
            }

            return new AllSports(query);
        }

    }

