package com.struts.invoicegen.dao;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="service")
public class ServicesDao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serviceid;
	private String sacnumber;
	private String description;
	private String valueofservice;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="service_taxinvoiceid",referencedColumnName="tid")
	private TaxInvoiceDao taxInvoiceDao;
	

	
	private String service_createdby;
	private Date service_created_date;
	private String service_created_ip;
	
	
	public int getServiceid() {
		return serviceid;
	}
	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}
	
	
	public String getSacnumber() {
		return sacnumber;
	}
	public void setSacnumber(String sacnumber) {
		this.sacnumber = sacnumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getValueofservice() {
		return valueofservice;
	}
	public void setValueofservice(String valueofservice) {
		this.valueofservice = valueofservice;
	}
	public TaxInvoiceDao getTaxInvoiceDao() {
		return taxInvoiceDao;
	}
	public void setTaxInvoiceDao(TaxInvoiceDao taxInvoiceDao) {
		this.taxInvoiceDao = taxInvoiceDao;
	}
	public String getService_createdby() {
		return service_createdby;
	}
	public void setService_createdby(String service_createdby) {
		this.service_createdby = service_createdby;
	}
	
	public Date getService_created_date() {
		return service_created_date;
	}
	public void setService_created_date(Date service_created_date) {
		this.service_created_date = service_created_date;
	}
	public String getService_created_ip() {
		return service_created_ip;
	}
	public void setService_created_ip(String service_created_ip) {
		this.service_created_ip = service_created_ip;
	}
	
	
	
	
}
