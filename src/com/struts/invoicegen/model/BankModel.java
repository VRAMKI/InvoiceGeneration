package com.struts.invoicegen.model;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.struts.invoicegen.dao.BankDetailsDao;
import com.struts.invoicegen.dao.CompanyDao;
import com.struts.invoicegen.dto.BankDto;
import com.struts.invoicegen.util.HibernateUtil;

public class BankModel {
	
	
	BankDetailsDao bankDao = new BankDetailsDao();
	List<BankDetailsDao> fetchBankList;
	Session sess = HibernateUtil.getSessionFactory().openSession();
	
	
	public List<BankDetailsDao> getFetchBankList() {
		return fetchBankList;
	}


	public void setFetchBankList(List<BankDetailsDao> fetchBankList) {
		this.fetchBankList = fetchBankList;
	}


	public String saveBankDetails(BankDto bankDto)
	{
		
		sess.beginTransaction();
		System.out.println("After sesiion open ");
		bankDao.setBank_acnum(bankDto.getBacnum());
		bankDao.setBank_ifsccode(bankDto.getBifsccode());
		bankDao.setBank_name(bankDto.getBname());
		bankDao.setBranch_name(bankDto.getBrname());
		bankDao.setBank_shrtname(bankDto.getBshrtName());
		
		System.out.println("bankDto.getbShrtName()"+bankDto.getBshrtName());
		
		bankDao.setBank_created_date(new Date());
		System.out.println("bank dto "+bankDto.getBacnum());
		bankDao.setBcmpdao((CompanyDao) sess.get(CompanyDao.class,bankDto.getCmpId()));
		System.out.println("before save ");
		sess.save(bankDao);
		System.out.println("bank details saved ");
		sess.getTransaction().commit();
		sess.close();
		return "success";
	}


	@SuppressWarnings("unchecked")
	public List<BankDetailsDao> fetchBankDetails(int cmpyId) {
		
		sess.beginTransaction();
		Query query = sess.createQuery("from BankDetailsDao where bcmpdao = :cmpId").setInteger("cmpId", cmpyId);
		fetchBankList = query.list();
		return fetchBankList;
	}

}
