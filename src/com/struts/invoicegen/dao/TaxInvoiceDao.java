package com.struts.invoicegen.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tax_invoice")
public class TaxInvoiceDao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tid;
	private String invoice_num;
	private String invoice_date;
	private String invoice_purposeofcreation;
	private String invoice_createdby;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "invoice_servicesbycmpid", referencedColumnName="cid")
	private CompanyDao serBycmpDao;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "invoice_servicestocmpid", referencedColumnName="cid")
	private CompanyDao serTocmpDao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "invoice_servicestoaddressid", referencedColumnName="aid")
	private AddressDao serToAddDao;
	
	@OneToOne(mappedBy="taxInvoiceDao")
	private TaxDetailsDao taxDetailsObj ;
	
	
	
/*	@OneToMany(mappedBy="taxInvoiceDao")
	private List<ServicesDao> servDao = new ArrayList<ServicesDao>();*/
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "invoice_servicesbyaddressid", referencedColumnName="aid")
	private AddressDao serByAddDao;
	
	private String invoice_servicesbycmpname;
	private String invoice_servicestocmpname;
	private String invoice_servicestoaddressname;
	private String invoice_servicesbyaddressname;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "invoice_bankid", referencedColumnName="bid")
	private BankDetailsDao bankDao;
	
	private Date invoice_created_date;
	private String invoice_created_ip;
	private String invoice_plcofsupply;
	private String invoice_orderrefnum;
	
	

	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getInvoice_num() {
		return invoice_num;
	}
	public void setInvoice_num(String invoice_num) {
		this.invoice_num = invoice_num;
	}
	public String getInvoice_date() {
		return invoice_date;
	}
	public void setInvoice_date(String invoice_date) {
		this.invoice_date = invoice_date;
	}
	public String getInvoice_purposeofcreation() {
		return invoice_purposeofcreation;
	}
	public void setInvoice_purposeofcreation(String invoice_purposeofcreation) {
		this.invoice_purposeofcreation = invoice_purposeofcreation;
	}
	public String getInvoice_createdby() {
		return invoice_createdby;
	}
	public void setInvoice_createdby(String invoice_createdby) {
		this.invoice_createdby = invoice_createdby;
	}
	
	public CompanyDao getSerBycmpDao() {
		return serBycmpDao;
	}
	public void setSerBycmpDao(CompanyDao serBycmpDao) {
		this.serBycmpDao = serBycmpDao;
	}
	public CompanyDao getSerTocmpDao() {
		return serTocmpDao;
	}
	public void setSerTocmpDao(CompanyDao serTocmpDao) {
		this.serTocmpDao = serTocmpDao;
	}
	
	public AddressDao getSerByAddDao() {
		return serByAddDao;
	}
	public void setSerByAddDao(AddressDao serByAddDao) {
		this.serByAddDao = serByAddDao;
	}
	public String getInvoice_servicesbycmpname() {
		return invoice_servicesbycmpname;
	}
	public void setInvoice_servicesbycmpname(String invoice_servicesbycmpname) {
		this.invoice_servicesbycmpname = invoice_servicesbycmpname;
	}
	public String getInvoice_servicestocmpname() {
		return invoice_servicestocmpname;
	}
	public void setInvoice_servicestocmpname(String invoice_servicestocmpname) {
		this.invoice_servicestocmpname = invoice_servicestocmpname;
	}
	public String getInvoice_servicestoaddressname() {
		return invoice_servicestoaddressname;
	}
	public void setInvoice_servicestoaddressname(
			String invoice_servicestoaddressname) {
		this.invoice_servicestoaddressname = invoice_servicestoaddressname;
	}
	public String getInvoice_servicesbyaddressname() {
		return invoice_servicesbyaddressname;
	}
	public void setInvoice_servicesbyaddressname(
			String invoice_servicesbyaddressname) {
		this.invoice_servicesbyaddressname = invoice_servicesbyaddressname;
	}
	public BankDetailsDao getBankDao() {
		return bankDao;
	}
	public void setBankDao(BankDetailsDao bankDao) {
		this.bankDao = bankDao;
	}
	
	public Date getInvoice_created_date() {
		return invoice_created_date;
	}
	public void setInvoice_created_date(Date invoice_created_date) {
		this.invoice_created_date = invoice_created_date;
	}
	public String getInvoice_created_ip() {
		return invoice_created_ip;
	}
	public void setInvoice_created_ip(String invoice_created_ip) {
		this.invoice_created_ip = invoice_created_ip;
	}
	public String getInvoice_plcofsupply() {
		return invoice_plcofsupply;
	}
	public void setInvoice_plcofsupply(String invoice_plcofsupply) {
		this.invoice_plcofsupply = invoice_plcofsupply;
	}
	public String getInvoice_orderrefnum() {
		return invoice_orderrefnum;
	}
	public void setInvoice_orderrefnum(String invoice_orderrefnum) {
		this.invoice_orderrefnum = invoice_orderrefnum;
	}
	public AddressDao getSerToAddDao() {
		return serToAddDao;
	}
	public void setSerToAddDao(AddressDao serToAddDao) {
		this.serToAddDao = serToAddDao;
	}
	public TaxDetailsDao getTaxDetailsObj() {
		return taxDetailsObj;
	}
	public void setTaxDetailsObj(TaxDetailsDao taxDetailsObj) {
		this.taxDetailsObj = taxDetailsObj;
	}
	
	
	
	

}
