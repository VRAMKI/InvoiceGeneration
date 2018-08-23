package com.struts.invoicegen.action;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.struts.invoicegen.dao.AddressDao;
import com.struts.invoicegen.dao.CompanyDao;
import com.struts.invoicegen.dto.AddressDto;
import com.struts.invoicegen.model.AddressModel;

public class AddressAction extends ActionSupport implements ModelDriven<AddressDto>{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AddressDto adddto = new AddressDto();
	AddressModel addmodel = new AddressModel();
	List<AddressDao> addrList;
	private int cmpyId;
	InputStream inputStream = null;
	
	
	
	public List<AddressDao> getAddrList() {
		return addrList;
	}

	public void setAddrList(List<AddressDao> addrList) {
		this.addrList = addrList;
	}

	public int getCmpyId() {
		return cmpyId;
	}

	public void setCmpyId(int cmpyId) {
		this.cmpyId = cmpyId;
	}

	@Override
	public AddressDto getModel() {
		// TODO Auto-generated method stub
		return adddto;
	}
	
	public String addressFields()
	{
		System.out.println("in action class");
		addmodel.saveAddressFields(adddto);
		return SUCCESS;
	}
	
	public String fetchAddress()
	{
		System.out.println("fetchAddress");
		
		String serByAdd = "";
		System.out.println("in address action class");
		addrList = addmodel.fetchAddressList(this.cmpyId);
		serByAdd += "<option value='-1' >Select </option>";
		for(AddressDao addrsList:addrList){
			serByAdd += "<option value='" + addrsList.getAid() + "' >"
				     + addrsList.getAddress_shrtname() + " </option>";
		}
		inputStream = new StringBufferInputStream(serByAdd);
		return SUCCESS;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
}
