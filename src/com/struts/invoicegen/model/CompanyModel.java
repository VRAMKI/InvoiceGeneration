package com.struts.invoicegen.model;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.struts.invoicegen.dao.CompanyDao;
import com.struts.invoicegen.dto.CompanyDto;
import com.struts.invoicegen.util.HibernateUtil;

public class CompanyModel {

	private List<CompanyDao> firmList;

	public String savefirmfields(CompanyDto cmpdto) {
		CompanyDao firmdao = new CompanyDao();

		firmdao.setCompany_name(cmpdto.getCname());
		firmdao.setCompany_shrtname(cmpdto.getCmpshrtname());
		firmdao.setCompany_gstin(cmpdto.getCgstin());
		firmdao.setCompany_created_date(new Date());

		Session sess = HibernateUtil.getSessionFactory().openSession();
		sess.beginTransaction();

		sess.save(firmdao);
		System.out.println("after save");
		sess.getTransaction().commit();

		sess.close();
		return "success";
	}

	@SuppressWarnings("unchecked")
	public List<CompanyDao> retriveFirmList(int cmpyId) {

		/*
		 * SessionFactory sf = new
		 * AnnotationConfiguration().configure().buildSessionFactory(); Session
		 * sess = sf.openSession();
		 */

		Session sess = HibernateUtil.getSessionFactory().openSession();
		sess.beginTransaction();
		if (cmpyId != 0) {
			Query query = sess
					.createQuery("from CompanyDao cmpmst where cmpmst.cid != :cmpyId");
			query.setParameter("cmpyId", cmpyId);
			firmList = query.list();
		} else {
			Query query = sess.createQuery("from CompanyDao");
			firmList = query.list();
		}

		return firmList;
	}

}
