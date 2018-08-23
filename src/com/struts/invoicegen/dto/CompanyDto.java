package com.struts.invoicegen.dto;

import java.util.Date;


public class CompanyDto {

	private String cname;
	private String cgstin;
	private Date cmpcreateddate;
	private String cmpcreatedip;
	private String cmpshrtname;
	private int cmpactiveflag;
	
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCgstin() {
		return cgstin;
	}
	public void setCgstin(String cgstin) {
		this.cgstin = cgstin;
	}
	public Date getCmpcreateddate() {
		return cmpcreateddate;
	}
	public void setCmpcreateddate(Date cmpcreateddate) {
		this.cmpcreateddate = cmpcreateddate;
	}
	public String getCmpcreatedip() {
		return cmpcreatedip;
	}
	public void setCmpcreatedip(String cmpcreatedip) {
		this.cmpcreatedip = cmpcreatedip;
	}
	public String getCmpshrtname() {
		return cmpshrtname;
	}
	public void setCmpshrtname(String cmpshrtname) {
		this.cmpshrtname = cmpshrtname;
	}
	public int getCmpactiveflag() {
		return cmpactiveflag;
	}
	public void setCmpactiveflag(int cmpactiveflag) {
		this.cmpactiveflag = cmpactiveflag;
	}
	
	
	
	
	
}
