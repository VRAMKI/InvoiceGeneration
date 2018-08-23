package com.struts.invoicegen.action;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.invoicegen.services.InvoicePdfGeneration;

public class InvoicePdfGen extends ActionSupport{
	
	private int tid;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String geninvoicepdf(){
		InvoicePdfGeneration ipdf = new InvoicePdfGeneration();
		ipdf.generateInvoice(getTid());
		return SUCCESS;
	}
	
}

