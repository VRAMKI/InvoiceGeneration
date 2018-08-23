package com.struts.invoicegen.model;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.struts.invoicegen.dao.AddressDao;
import com.struts.invoicegen.dao.CompanyDao;
import com.struts.invoicegen.dto.AddressDto;
import com.struts.invoicegen.util.HibernateUtil;

public class AddressModel {

	private List<AddressDao> addrList;
	public String saveAddressFields(AddressDto addrDto)
	{
		System.out.println("in address model class ");
	//	System.out.println("address cmp i d"+adddto.getAddcompanyid());
		AddressDao addao = new AddressDao();
		
		//System.out.println("uidfjdskjdsfkjds  "+adddto.getCmpdao());
		addao.setAddress(addrDto.getAddress());
		
		addao.setAddress_shrtname(addrDto.getAddshrtname());
		addao.setLocality(addrDto.getLocality());
		addao.setAddress_state(addrDto.getAddstate());
		addao.setAddress_statecode(addrDto.getAddstatecode());
		addao.setAddress_activeflag(addrDto.getAddactiveflag());
		addao.setAddress_created_date(new Date());
		Session sess = HibernateUtil.getSessionFactory().openSession();
		 System.out.println(" id "+addrDto.getCmpId());
		addao.setCmpdao((CompanyDao) sess.get(CompanyDao.class, addrDto.getCmpId()));
		sess.beginTransaction();
		sess.save(addao);
		sess.getTransaction().commit();
		sess.close();
		return "success";
	}
	
	public List<AddressDao> fetchAddressList(int cmpyId)
	{
		System.out.println("company id "+cmpyId);
		Session sess = HibernateUtil.getSessionFactory().openSession();
		System.out.println("after session open ");
		sess.beginTransaction();
		System.out.println("after begin transaction in fetchAddressList ");
		Query query = sess.createQuery("from AddressDao adao where adao.cmpdao =:cmpId");
		query.setInteger("cmpId", cmpyId);
		System.out.println("dfgdfsgdsgsgs"+query);
	
		addrList = query.list();
		System.out.println("addrList"+addrList);
		System.out.println("address list");
		return addrList;
		
	}
}
