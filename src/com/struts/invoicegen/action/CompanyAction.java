package com.struts.invoicegen.action;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.struts.invoicegen.dao.CompanyDao;
import com.struts.invoicegen.dto.CompanyDto;
import com.struts.invoicegen.model.CompanyModel;


public class CompanyAction extends ActionSupport implements ModelDriven<CompanyDto>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CompanyDto cmpdto = new CompanyDto();
	CompanyModel cmpmodel = new CompanyModel();
	List<CompanyDao> cmplist;
	InputStream inputStream = null;
	private int cmpyId;

	public int getCmpyId() {
		return cmpyId;
	}


	public void setCmpyId(int cmpyId) {
		this.cmpyId = cmpyId;
	}


	public InputStream getInputStream() {
		return inputStream;
	}


	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}


	public List<CompanyDao> getCmplist() {
		return cmplist;
	}


	public void setCmplist(List<CompanyDao> cmplist) {
		this.cmplist = cmplist;
	}


	@Override
	public CompanyDto getModel() {
		// TODO Auto-generated method stub
		return cmpdto;
	}
	
	
	public String cmpfields()
	{
		System.out.println("1st");
		cmpmodel.savefirmfields(cmpdto);
		return SUCCESS;
	}

	@SuppressWarnings("deprecation")
	public String fetchcompanyname()
	{
		String result = "";
		System.out.println("in action class");
		cmplist = cmpmodel.retriveFirmList(this.cmpyId);
		result += "<option value='-1' >Select </option>";
		for(CompanyDao cmpyList:cmplist){
			result += "<option value='" + cmpyList.getCid() + "' >"
				     + cmpyList.getCompany_shrtname() + " </option>";
		}
		inputStream = new StringBufferInputStream(result);
		return SUCCESS;
	}
	
	/*@SuppressWarnings("deprecation")
	public String fetchCmpyServTo()
	{
		String serToresult = "";
		System.out.println("in action class");
		cmplist = cmpmodel.retriveFirmList(this.cmpyId);
		serToresult += "<option value='-1' >Select </option>";
		for(CompanyDao cmpyList:cmplist){
			serToresult += "<option value='" + cmpyList.getCid() + "' >"
				     + cmpyList.getCompany_shrtname() + " </option>";
		}
		inputStream = new StringBufferInputStream(serToresult);
		return SUCCESS;
	}*/

	
	
	
	
}
