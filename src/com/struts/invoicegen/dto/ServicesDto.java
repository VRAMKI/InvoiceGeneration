package com.struts.invoicegen.dto;

/*=======================================Not using any where============================================*/
public class ServicesDto {

	private int sno;
	private String sacNumber;
	private String description;
	private double valOfServ;
	
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSacNumber() {
		return sacNumber;
	}
	public void setSacNumber(String sacNumber) {
		this.sacNumber = sacNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getValOfServ() {
		return valOfServ;
	}
	public void setValOfServ(double valOfServ) {
		this.valOfServ = valOfServ;
	}
	
	
}
