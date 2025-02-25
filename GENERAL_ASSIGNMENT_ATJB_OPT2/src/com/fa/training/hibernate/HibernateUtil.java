package com.fa.training.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.File;

public class HibernateUtil {
    private static final String CONFIG_PATH = 
    		"D:\\JAVA\\FR_JAVA_25_01_AnhNT507_JWEB\\GENERAL_ASSIGNMENT_ATJB_OPT2\\src\\hibernate.cfg.xml"; 

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure(new File(CONFIG_PATH)).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
