package org.hillel.it.network.infa.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

//    private static SessionFactory sessionFactory = null;//buildSessionFactory();
/*
    private static SessionFactory buildSessionFactory() {
        try {
        	return new Configuration().configure().buildSessionFactory(new StandardServiceRegistryBuilder().build());
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
*/
    public static SessionFactory getSessionFactory() {
//       	return sessionFactory;
        	return new Configuration().configure().buildSessionFactory(new StandardServiceRegistryBuilder().build());
     
    }

}