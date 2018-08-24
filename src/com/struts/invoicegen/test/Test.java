package com.struts.invoicegen.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Test {
	
	public static void main(String df[]){
		Pojo p = new Pojo();
		p.setName("fddffd");
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		ses.save(p);
		ses.getTransaction().commit();
		p.setName("modified name");
		
	}

}
