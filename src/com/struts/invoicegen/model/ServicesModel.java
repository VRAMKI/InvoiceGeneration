package com.struts.invoicegen.model;

import java.util.Date;

import org.hibernate.Session;

import com.struts.invoicegen.dao.ServicesDao;
import com.struts.invoicegen.dao.TaxInvoiceDao;
import com.struts.invoicegen.dto.TaxInvoiceServicesDto;
import com.struts.invoicegen.util.HibernateUtil;

public class ServicesModel {

	ServicesDao servDao;
	TaxDetailsModel taxDetailsDao = new TaxDetailsModel();
	
	public String saveServices(TaxInvoiceServicesDto taxDto, int currenttaxId) {

		Session sess = HibernateUtil.getSessionFactory().openSession();

		taxDto.setTaxInvoiceId(currenttaxId);

		String[] servDesc = taxDto.getServDescription();
		String[] valOfSev = taxDto.getValOfServ();
		String[] servSac = taxDto.getSacNumber();
		int lengthofServTable = servDesc.length;
		
		double totalValOfServ = 0;
		
		for (int i = 0; i < lengthofServTable; i++) {
			servDao = new ServicesDao();
			sess.beginTransaction();
			String serDes = servDesc[i];
			String valOfser = valOfSev[i];
			String servSacNum = servSac[i];

			totalValOfServ += (Double.parseDouble(valOfSev[i]));
			System.out.println("totalValOfServ"+totalValOfServ);
			
			servDao.setDescription(serDes);
			servDao.setSacnumber(servSacNum);
			servDao.setValueofservice(valOfser);
			servDao.setService_created_date(new Date());
			servDao.setTaxInvoiceDao((TaxInvoiceDao) sess.get(TaxInvoiceDao.class, taxDto.getTaxInvoiceId()));
			sess.persist(servDao);
			System.out.println("after save ");
			sess.getTransaction().commit();

		}
		
		taxDetailsDao.saveTaxDetails(totalValOfServ,currenttaxId,taxDto);

		return "success";

	}
}
