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
@Table(name = "mst_bank")
public class BankDetailsDao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;
	private String bank_name;
	private String bank_acnum;
	private String branch_name;
	private String bank_ifsccode;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bank_companyid", referencedColumnName = "cid")
	private CompanyDao bcmpdao;

	private Date bank_created_date;
	private String bank_created_ip;
	private String bank_shrtname;
	private int bank_activeflag;

	
	
	
	public Date getBank_created_date() {
		return bank_created_date;
	}

	public void setBank_created_date(Date bank_created_date) {
		this.bank_created_date = bank_created_date;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBank_acnum() {
		return bank_acnum;
	}

	public void setBank_acnum(String bank_acnum) {
		this.bank_acnum = bank_acnum;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getBank_ifsccode() {
		return bank_ifsccode;
	}

	public void setBank_ifsccode(String bank_ifsccode) {
		this.bank_ifsccode = bank_ifsccode;
	}

	

	public CompanyDao getBcmpdao() {
		return bcmpdao;
	}

	public void setBcmpdao(CompanyDao bcmpdao) {
		this.bcmpdao = bcmpdao;
	}

	public String getBank_created_ip() {
		return bank_created_ip;
	}

	public void setBank_created_ip(String bank_created_ip) {
		this.bank_created_ip = bank_created_ip;
	}

	public String getBank_shrtname() {
		return bank_shrtname;
	}

	public void setBank_shrtname(String bank_shrtname) {
		this.bank_shrtname = bank_shrtname;
	}

	public int getBank_activeflag() {
		return bank_activeflag;
	}

	public void setBank_activeflag(int bank_activeflag) {
		this.bank_activeflag = bank_activeflag;
	}

}
