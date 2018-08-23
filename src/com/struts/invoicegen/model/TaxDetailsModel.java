package com.struts.invoicegen.model;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.struts.invoicegen.dao.GstPercentageDao;
import com.struts.invoicegen.dao.TaxDetailsDao;
import com.struts.invoicegen.dao.TaxInvoiceDao;
import com.struts.invoicegen.dto.TaxInvoiceServicesDto;
import com.struts.invoicegen.services.InvoicePdfGeneration;
import com.struts.invoicegen.util.HibernateUtil;

public class TaxDetailsModel {

	TaxDetailsDao taxDetailsDao = new TaxDetailsDao();
	private double cgstAmount = 0,igstAmount = 0 , sgstAmount = 0; 
	private double cgstPer = 0, igstper = 0,sgstper = 0 ;
	public String saveTaxDetails(double totalValOfServ, int currenttaxId, TaxInvoiceServicesDto taxDto) {
		
		taxDto.setTaxInvoiceId(currenttaxId);
		Session sess = HibernateUtil.getSessionFactory().openSession();
		sess.beginTransaction();
		Query getGstQuery = (Query) sess.createQuery("from GstPercentageDao where gstActiveFlag = 1");
		List<GstPercentageDao> getgstDaoActive = getGstQuery.list();
		
		for(GstPercentageDao gstActive:getgstDaoActive){
			 if(taxDto.getIgstRadio().equals("Yes")){
				 igstper = gstActive.getIgstper();
				 igstAmount = ((totalValOfServ*igstper)/100);
				}
				else
				{
					cgstPer = gstActive.getCgstper();
					sgstper = gstActive.getSgstper();
					cgstAmount = ((totalValOfServ*cgstPer)/100);
					sgstAmount = ((totalValOfServ*sgstper)/100);
				}
		}
		
		
		double gstAmount = igstAmount+cgstAmount+sgstAmount;
		double valAfterTax =  totalValOfServ + igstAmount+cgstAmount+sgstAmount;
		taxDetailsDao.setCgstamount(cgstAmount);
		taxDetailsDao.setSgstamount(sgstAmount);
		taxDetailsDao.setIgstamount(igstAmount);
		taxDetailsDao.setGstAmount(gstAmount);
		taxDetailsDao.setCgstper(cgstPer);
		taxDetailsDao.setIgstper(igstper);
		taxDetailsDao.setSgstper(sgstper);
		taxDetailsDao.setValue_befor_tax(totalValOfServ);
		taxDetailsDao.setValue_after_tax(valAfterTax);
		taxDetailsDao.setTaxdetails_created_date(new Date());
		taxDetailsDao.setTaxInvoiceDao((TaxInvoiceDao) sess.get(TaxInvoiceDao.class,taxDto.getTaxInvoiceId()));
		sess.save(taxDetailsDao);
		sess.getTransaction().commit();
		InvoicePdfGeneration invGen = new InvoicePdfGeneration();
		invGen.generateInvoice(currenttaxId);
		return "success";
	}
}
