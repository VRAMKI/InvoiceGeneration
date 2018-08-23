package com.struts.invoicegen.model;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.struts.invoicegen.dao.GstPercentageDao;
import com.struts.invoicegen.dto.TaxDetailsDto;
import com.struts.invoicegen.dto.TaxInvoiceServicesDto;
import com.struts.invoicegen.util.HibernateUtil;

public class GstPercentageModel {

	GstPercentageDao gstDao = new GstPercentageDao();
	Session sess = HibernateUtil.getSessionFactory().openSession();
	TaxInvoiceServicesDto taxServicesDetailsDto = new TaxInvoiceServicesDto();
	public String saveGstPercentage(TaxDetailsDto taxDetails){
		sess.beginTransaction();
		gstDao.setCgstper(taxDetails.getCgstPercentage());
		gstDao.setSgstper(taxDetails.getSgstPercentage());
		gstDao.setIgstper(taxDetails.getIgstPercentage());
		gstDao.setGst_createdDate(new Date());
		sess.save(gstDao);
		sess.getTransaction().commit();
		return "success";
	}
	public List<GstPercentageDao> fetchgstperfields() {
		sess.beginTransaction();
		System.out.println("in gst fetch fields ");
		Query query = sess.createQuery("from GstPercentageDao");
		List<GstPercentageDao> gstList = query.list();
		System.out.println("gstList"+gstList);
		sess.close();
		return gstList;
	}
	public String updateGstPercentage(TaxDetailsDto taxDetailsDto) {
		sess.beginTransaction();
		Query gstquery = sess.createQuery("update GstPercentageDao set gstActiveFlag = 0");
		int gstActiveFlag = Integer.parseInt(taxDetailsDto.getGstActiveFlag());
		int result = gstquery.executeUpdate();
		
		Query gstFlagUpdtae = sess
				.createQuery(
						"update GstPercentageDao gst set gst.gstActiveFlag = 1 where gst.gstid=:selectedGst")
				.setParameter("selectedGst", gstActiveFlag);
		
		int gstresult = gstFlagUpdtae.executeUpdate();
		
		sess.getTransaction().commit();
		return "success";
	}
}
