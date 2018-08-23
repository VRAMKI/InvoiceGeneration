package com.struts.invoicegen.util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateUtil {

private static final SessionFactory sessionFactory;

static {
    try {
        // Create the SessionFactory from standard (hibernate.cfg.xml) 
        // config file.
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    	//sessionFactory = new AnnotationConfiguration().setProperty("hibernate.jdbc.factory_class", "org.hibernate.jdbc.NonBatchingBatcherFactory").configure().buildSessionFactory();
        
    } catch (Throwable ex) {
        // Log the exception. 
        System.err.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
    }
}

public static SessionFactory getSessionFactory() {
	//System.out.println("stats : "+sessionFactory.getStatistics().toString());
    return sessionFactory;
}

}