package com.struts.invoicegen.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.itextpdf.text.Element;
import com.struts.invoicegen.dao.AddressDao;
import com.struts.invoicegen.dao.BankDetailsDao;
import com.struts.invoicegen.dao.CompanyDao;
import com.struts.invoicegen.dao.ServicesDao;
import com.struts.invoicegen.dao.TaxDetailsDao;
import com.struts.invoicegen.dao.TaxInvoiceDao;
import com.struts.invoicegen.dto.TaxInvoiceServicesDto;
import com.struts.invoicegen.util.HibernateUtil;

public class TaxInvoiceModel {

	TaxInvoiceDao taxDao = new TaxInvoiceDao();
	ServicesModel servModel = new ServicesModel();
	TaxInvoiceServicesDto taxDto = new TaxInvoiceServicesDto();
	
	public String saveInvoiceFields(TaxInvoiceServicesDto taxDto)
	{
	List list = null;
	int maxIid = 0;
	int nextIid =0;
	String hql = "select max(tid) from com.struts.invoicegen.dao.TaxInvoiceDao";
	Session sess = HibernateUtil.getSessionFactory().openSession();
	sess.beginTransaction();
	try{
		list = sess.createQuery(hql).list();
		if(list != null){
		maxIid = ((Integer) list.get(0)).intValue();
		nextIid = maxIid + 1;
	}
	}
	catch(NullPointerException ne)
	{
		if(list.size()==1){
		nextIid = maxIid + 1;
		
		}
	}
	String pattern = String.format("%06d", nextIid);
	String invoicenum = "VSA/18-19/" + pattern;
	taxDao.setInvoice_num(invoicenum);
	taxDao.setInvoice_date(taxDto.getInvoiceDate());
	taxDao.setSerBycmpDao((CompanyDao) sess.get(CompanyDao.class, taxDto.getServiceByCmp()));
	taxDao.setSerByAddDao((AddressDao) sess.get(AddressDao.class, taxDto.getServiceByAddCmp()));
	taxDao.setBankDao((BankDetailsDao) sess.get(BankDetailsDao.class, taxDto.getServiceByBank()));
	taxDao.setSerTocmpDao((CompanyDao) sess.get(CompanyDao.class,taxDto.getServiceToCmp()));
	taxDao.setSerToAddDao((AddressDao) sess.get(AddressDao.class, taxDto.getServiceToAddCmp()));
	taxDao.setInvoice_plcofsupply(taxDto.getInvoicePlcofsupply());
	taxDao.setInvoice_orderrefnum(taxDto.getInvoiceOrderrefnum());
	taxDao.setInvoice_created_date(new Date());
	int currenttaxId = (int) sess.save(taxDao);
	sess.getTransaction().commit();
	servModel.saveServices(taxDto,currenttaxId);
	return "success";
	}

	//public static void main(String gg[]){
	public TaxInvoiceDao retriveInvoiceDetails(int taxid) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		sess.beginTransaction();
		TaxInvoiceDao taxInvoice = (TaxInvoiceDao) sess.get(TaxInvoiceDao.class,taxid);
		/*AddressDao servByAddrObj = taxInvoice.getSerByAddDao();
		AddressDao servToAddrObj = taxInvoice.getSerToAddDao();
		CompanyDao servByCmpyObj = taxInvoice.getSerBycmpDao();
		CompanyDao servToCmpyObj = taxInvoice.getSerTocmpDao();
		BankDetailsDao bankObj = taxInvoice.getBankDao();*/
		
		
		//ServicesDao servDao = (ServicesDao) sess.get(ServicesDao.class,taxInvoice.getTid());
		/*
		System.out.println("tid"+taxInvoice.getTid());
		Query query = sess.createQuery("from ServicesDao s where s.taxInvoiceDao = :test").setInteger("test",taxInvoice.getTid()); 
		List<ServicesDao> lisy =query.list();
		
		
		for(ServicesDao td :lisy){
			
			System.out.println("etttetetetettetetettetetetetettete"+td.getDescription());
		}
		*/
		
		
		sess.close();
		return taxInvoice;
	}
//public static void main(String df[]){
	public List<TaxInvoiceServicesDto> fetchInvoiceDetails() {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		sess.beginTransaction();
		Query query = sess.createQuery("from com.struts.invoicegen.dao.TaxInvoiceDao");
		List<TaxInvoiceDao> invlist = query.list();
		
		
		/*
		Query testquery = sess.createSQLQuery("select td.gstAmount,td.value_after_tax,ti.* from tax_invoice ti , tax_details td ");
		testquery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List<Object> lid = testquery.list();
		System.out.println("lid"+lid);
		
		for(Object lk:lid){
			Map roe = (Map)lk;
			System.out.println("76456564564564564"+roe.get("gstAmount"));
			System.out.println("invoice num"+roe.get("invoice_num"));
		}
		*/
		
		
		
		Query invoicequery = sess.createQuery("from TaxInvoiceDao");
		//select td.gstAmount,td.value_after_tax,ti.* from TaxDetailsDao td, TaxInvoiceDao ti where td.taxInvoiceDao =ti.tid
		//Query invoicequery = sess.createQuery("from TaxInvoiceDao ti");
		
		List<TaxInvoiceDao> taxInvoiceList = invoicequery.list();
		List<TaxInvoiceServicesDto> taxInvoicedtoList = new ArrayList<TaxInvoiceServicesDto>();
		
		
		for (TaxInvoiceDao taxInvoiceDao : taxInvoiceList) {
			TaxInvoiceServicesDto taxDto = new TaxInvoiceServicesDto();
			taxDto.setValueAfterTax(taxInvoiceDao.getTaxDetailsObj().getValue_after_tax());
			taxDto.setInvoice_num(taxInvoiceDao.getInvoice_num());
			taxDto.setInvoiceOrderrefnum(taxInvoiceDao.getInvoice_orderrefnum());
			taxDto.setInvoicePlcofsupply(taxInvoiceDao.getInvoice_plcofsupply());
			taxDto.setInvoiceDate(taxInvoiceDao.getInvoice_date());
			
			taxInvoicedtoList.add(taxDto);
			
		}
		
		/*for (TaxInvoiceServicesDto taxInvoiceServicesDto : taxInvoicedtoList) {
			System.out.println(taxInvoiceServicesDto.getValueAfterTax());
		}
		*/
		
		
		/*System.out.println("objList"+objList);
		
		for(Object obj:objList.toArray()){
			System.out.println("fdgdf"+obj);
		}
		
		System.out.println("objList"+objList);*/
		
	return taxInvoicedtoList;
		//return roe;
	}	
}
