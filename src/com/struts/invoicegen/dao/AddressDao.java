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
import javax.persistence.Table;

@Entity
@Table(name = "mst_address")
public class AddressDao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	private String address;
	private String locality;
	private String address_state;
	private String address_statecode;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_companyid",referencedColumnName="cid")
	private CompanyDao cmpdao;
	
	
	
	@OneToMany(mappedBy="serToAddDao")
	private List<TaxInvoiceDao> serToAddDao = new ArrayList<TaxInvoiceDao>();
	
	@OneToMany(mappedBy="serByAddDao")
	private List<TaxInvoiceDao> serByAddDao = new ArrayList<TaxInvoiceDao>();

	private Date address_created_date;
	private String address_created_ip;
	private String address_shrtname;
	private String address_activeflag;

	
	
	
	

	public CompanyDao getCmpdao() {
		return cmpdao;
	}

	public void setCmpdao(CompanyDao cmpdao) {
		this.cmpdao = cmpdao;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getAddress_state() {
		return address_state;
	}

	public void setAddress_state(String address_state) {
		this.address_state = address_state;
	}

	public String getAddress_statecode() {
		return address_statecode;
	}

	public void setAddress_statecode(String address_statecode) {
		this.address_statecode = address_statecode;
	}

	


	public Date getAddress_created_date() {
		return address_created_date;
	}

	public void setAddress_created_date(Date address_created_date) {
		this.address_created_date = address_created_date;
	}

	public String getAddress_created_ip() {
		return address_created_ip;
	}

	public void setAddress_created_ip(String address_created_ip) {
		this.address_created_ip = address_created_ip;
	}

	public String getAddress_shrtname() {
		return address_shrtname;
	}

	public void setAddress_shrtname(String address_shrtname) {
		this.address_shrtname = address_shrtname;
	}

	public String getAddress_activeflag() {
		return address_activeflag;
	}

	public void setAddress_activeflag(String address_activeflag) {
		this.address_activeflag = address_activeflag;
	}

	

	
	
	
	
	
	
	
	
	
	
}
