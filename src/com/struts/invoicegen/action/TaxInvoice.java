package com.struts.invoicegen.action;

import java.util.List;



import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.struts.invoicegen.dao.TaxInvoiceDao;
import com.struts.invoicegen.dto.ServicesDto;
import com.struts.invoicegen.dto.TaxInvoiceServicesDto;
import com.struts.invoicegen.model.TaxInvoiceModel;

public class TaxInvoice extends ActionSupport implements ModelDriven<TaxInvoiceServicesDto>,RequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TaxInvoiceServicesDto taxDto = new TaxInvoiceServicesDto();
	TaxInvoiceModel taxModel = new TaxInvoiceModel();
	List<TaxInvoiceServicesDto> invoicelist;
	Map<String, Object> request;
	
	
	private  TaxInvoiceServicesDto taxInvDto;
	private List<TaxInvoiceServicesDto> taxInvDtoList;
	private List<ServicesDto> servDtoList;
	
	

	

	public List<TaxInvoiceServicesDto> getInvoicelist() {
		return invoicelist;
	}

	public void setInvoicelist(List<TaxInvoiceServicesDto> invoicelist) {
		this.invoicelist = invoicelist;
	}

	public TaxInvoiceServicesDto getTaxInvDto() {
		return taxInvDto;
	}

	public void setTaxInvDto(TaxInvoiceServicesDto taxInvDto) {
		this.taxInvDto = taxInvDto;
	}

	public List<TaxInvoiceServicesDto> getTaxInvDtoList() {
		return taxInvDtoList;
	}

	public void setTaxInvDtoList(List<TaxInvoiceServicesDto> taxInvDtoList) {
		this.taxInvDtoList = taxInvDtoList;
	}

	public List<ServicesDto> getServDtoList() {
		return servDtoList;
	}

	public void setServDtoList(List<ServicesDto> servDtoList) {
		this.servDtoList = servDtoList;
	}

	
	@Override
	public TaxInvoiceServicesDto getModel() {
		// TODO Auto-generated method stub
		return taxDto;
	}
	
	public String invoiceFields()
	{
		taxModel.saveInvoiceFields(taxDto);
		return fetchinvoiceFields();
	}

	public String fetchinvoiceFields()
	{
		this.invoicelist = taxModel.fetchInvoiceDetails();
		request.put("invoicelist", invoicelist);
		return SUCCESS;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		request=arg0;
		
	}
}
