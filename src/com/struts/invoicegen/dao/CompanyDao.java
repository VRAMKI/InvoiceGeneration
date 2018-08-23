package com.struts.invoicegen.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="mst_company")
public class CompanyDao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;
	private String company_name;
	private String company_gstin;
	private Date company_created_date;
	private String company_created_ip;
	private String company_shrtname;
	private int company_activeflag;
	
	@OneToMany(mappedBy="cmpdao")
	private List<AddressDao> addressList=new ArrayList<AddressDao>();
	
	@OneToMany(mappedBy="bcmpdao")
	private List<BankDetailsDao> bankList = new ArrayList<BankDetailsDao>();
	
	
	
	@OneToMany(mappedBy="serBycmpDao")
	private List<TaxInvoiceDao> serBycmpDao= new ArrayList<TaxInvoiceDao>();
	
	@OneToMany(mappedBy="serTocmpDao")
	private List<TaxInvoiceDao> serTocmpDao= new ArrayList<TaxInvoiceDao>();
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_gstin() {
		return company_gstin;
	}
	public void setCompany_gstin(String company_gstin) {
		this.company_gstin = company_gstin;
	}
	public Date getCompany_created_date() {
		return company_created_date;
	}
	public void setCompany_created_date(Date company_created_date) {
		this.company_created_date = company_created_date;
	}
	public String getCompany_created_ip() {
		return company_created_ip;
	}
	public void setCompany_created_ip(String company_created_ip) {
		this.company_created_ip = company_created_ip;
	}
	public String getCompany_shrtname() {
		return company_shrtname;
	}
	public void setCompany_shrtname(String company_shrtname) {
		this.company_shrtname = company_shrtname;
	}
	public int getCompany_activeflag() {
		return company_activeflag;
	}
	public void setCompany_activeflag(int company_activeflag) {
		this.company_activeflag = company_activeflag;
	}
	public List<AddressDao> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<AddressDao> addressList) {
		this.addressList = addressList;
	}
	
	
}
