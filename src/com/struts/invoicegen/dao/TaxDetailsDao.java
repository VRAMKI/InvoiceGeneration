package com.struts.invoicegen.dao;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tax_details")
public class TaxDetailsDao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taxid;
	private double sgstper;
	private double cgstper;
	private double igstper;
	private double cgstamount;
	private double sgstamount;
	private double igstamount;
	private double gstAmount;
	
	
	@ManyToOne
	private GstPercentageDao gstDetails;
	
	/*============================================================*/
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tax_invoiceid",referencedColumnName="tid")
	private TaxInvoiceDao taxInvoiceDao;
	
/*=============================================testing code = = ============================	*/

	
	
	private double value_befor_tax;
	private double value_after_tax;
	private String tax_shrtname;
	private double taxdetails_createdby;
	private Date taxdetails_created_date;
	private String taxdetails_created_ip;
	private int activeFlag;
	
	
	public int getTaxid() {
		return taxid;
	}
	public void setTaxid(int taxid) {
		this.taxid = taxid;
	}
	public double getSgstper() {
		return sgstper;
	}
	public void setSgstper(double sgstper) {
		this.sgstper = sgstper;
	}
	public double getCgstper() {
		return cgstper;
	}
	public void setCgstper(double cgstper) {
		this.cgstper = cgstper;
	}
	public double getIgstper() {
		return igstper;
	}
	public void setIgstper(double igstper) {
		this.igstper = igstper;
	}
	public double getCgstamount() {
		return cgstamount;
	}
	public void setCgstamount(double cgstamount) {
		this.cgstamount = cgstamount;
	}
	public double getSgstamount() {
		return sgstamount;
	}
	public void setSgstamount(double sgstamount) {
		this.sgstamount = sgstamount;
	}
	public double getIgstamount() {
		return igstamount;
	}
	public void setIgstamount(double igstamount) {
		this.igstamount = igstamount;
	}
	public TaxInvoiceDao getTaxInvoiceDao() {
		return taxInvoiceDao;
	}
	public void setTaxInvoiceDao(TaxInvoiceDao taxInvoiceDao) {
		this.taxInvoiceDao = taxInvoiceDao;
	}
	public double getValue_befor_tax() {
		return value_befor_tax;
	}
	public void setValue_befor_tax(double value_befor_tax) {
		this.value_befor_tax = value_befor_tax;
	}
	public double getValue_after_tax() {
		return value_after_tax;
	}
	public void setValue_after_tax(double value_after_tax) {
		this.value_after_tax = value_after_tax;
	}
	public String getTax_shrtname() {
		return tax_shrtname;
	}
	public void setTax_shrtname(String tax_shrtname) {
		this.tax_shrtname = tax_shrtname;
	}
	public double getTaxdetails_createdby() {
		return taxdetails_createdby;
	}
	public void setTaxdetails_createdby(double taxdetails_createdby) {
		this.taxdetails_createdby = taxdetails_createdby;
	}
	public Date getTaxdetails_created_date() {
		return taxdetails_created_date;
	}
	public void setTaxdetails_created_date(Date taxdetails_created_date) {
		this.taxdetails_created_date = taxdetails_created_date;
	}
	public String getTaxdetails_created_ip() {
		return taxdetails_created_ip;
	}
	public void setTaxdetails_created_ip(String taxdetails_created_ip) {
		this.taxdetails_created_ip = taxdetails_created_ip;
	}
	public int getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}
	public double getGstAmount() {
		return gstAmount;
	}
	public void setGstAmount(double gstAmount) {
		this.gstAmount = gstAmount;
	}
	public GstPercentageDao getGstDetails() {
		return gstDetails;
	}
	public void setGstDetails(GstPercentageDao gstDetails) {
		this.gstDetails = gstDetails;
	}
	
	
	
	
}
