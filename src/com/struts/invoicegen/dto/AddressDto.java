package com.struts.invoicegen.dto;



public class AddressDto {

	private int aid;
	private String address;
	private String locality;
	private String addstate;
	private String addstatecode;
	private String addcreateddate;
	private String addcreatedip;
	private String addshrtname;
	private String addactiveflag;
	
	private int cmpId;
	
	
	public int getCmpId() {
		return cmpId;
	}

	public void setCmpId(int cmpId) {
		this.cmpId = cmpId;
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
	public String getAddstate() {
		return addstate;
	}
	public void setAddstate(String addstate) {
		this.addstate = addstate;
	}
	public String getAddstatecode() {
		return addstatecode;
	}
	public void setAddstatecode(String addstatecode) {
		this.addstatecode = addstatecode;
	}
	public String getAddcreateddate() {
		return addcreateddate;
	}
	public void setAddcreateddate(String addcreateddate) {
		this.addcreateddate = addcreateddate;
	}
	public String getAddcreatedip() {
		return addcreatedip;
	}
	public void setAddcreatedip(String addcreatedip) {
		this.addcreatedip = addcreatedip;
	}
	public String getAddshrtname() {
		return addshrtname;
	}
	public void setAddshrtname(String addshrtname) {
		this.addshrtname = addshrtname;
	}
	public String getAddactiveflag() {
		return addactiveflag;
	}
	public void setAddactiveflag(String addactiveflag) {
		this.addactiveflag = addactiveflag;
	}
	
	
}
