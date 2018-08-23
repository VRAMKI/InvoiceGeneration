package com.struts.invoicegen.dto;

import java.util.List;

public class TaxInvoiceServicesDto {

		private String invoice_num;
		private String invoiceDate;
		private String invoice_purposeofcreation;
		private String invoicecreatedby;
		private String invoicePlcofsupply;
		private String invoiceOrderrefnum;
		
		private int serviceByCmp;
		private int serviceToCmp;
		private int serviceByAddCmp;
		private int serviceToAddCmp;
		private int taxInvoiceId;
		
		
		private int serviceByBank;
		private String invoiceServicesbycmpname;
		private String invoiceServicestocmpname;
		private String invoiceServicestoaddressname;
		private String invoiceServicesbyaddressname;
		
		
	
		private String[] sacNumber;
		private String[] servDescription;
		private String[] valOfServ;
		private int serviceTaxinvoiceid;
		private String serviceCreatedby;
		private String serviceCreatedDate;
		private String serviceCreatedIp;
		
		private String igstRadio;
		
		
		private double valueAfterTax;
		
		public String getIgstRadio() {
			return igstRadio;
		}
		public void setIgstRadio(String igstRadio) {
			this.igstRadio = igstRadio;
		}
		private List<ServicesDto> servicesList;
		

		public List<ServicesDto> getServicesList() {
			return servicesList;
		}
		public void setServicesList(List<ServicesDto> servicesList) {
			this.servicesList = servicesList;
		}
		public String getInvoice_num() {
			return invoice_num;
		}
		public void setInvoice_num(String invoice_num) {
			this.invoice_num = invoice_num;
		}
		public String getInvoiceDate() {
			return invoiceDate;
		}
		public void setInvoiceDate(String invoiceDate) {
			this.invoiceDate = invoiceDate;
		}
		public String getInvoice_purposeofcreation() {
			return invoice_purposeofcreation;
		}
		public void setInvoice_purposeofcreation(String invoice_purposeofcreation) {
			this.invoice_purposeofcreation = invoice_purposeofcreation;
		}
		public String getInvoicecreatedby() {
			return invoicecreatedby;
		}
		public void setInvoicecreatedby(String invoicecreatedby) {
			this.invoicecreatedby = invoicecreatedby;
		}
		public String getInvoicePlcofsupply() {
			return invoicePlcofsupply;
		}
		public void setInvoicePlcofsupply(String invoicePlcofsupply) {
			this.invoicePlcofsupply = invoicePlcofsupply;
		}
		public String getInvoiceOrderrefnum() {
			return invoiceOrderrefnum;
		}
		public void setInvoiceOrderrefnum(String invoiceOrderrefnum) {
			this.invoiceOrderrefnum = invoiceOrderrefnum;
		}
		public int getServiceByCmp() {
			return serviceByCmp;
		}
		public void setServiceByCmp(int serviceByCmp) {
			this.serviceByCmp = serviceByCmp;
		}
		public int getServiceToCmp() {
			return serviceToCmp;
		}
		public void setServiceToCmp(int serviceToCmp) {
			this.serviceToCmp = serviceToCmp;
		}
		public int getServiceByAddCmp() {
			return serviceByAddCmp;
		}
		public void setServiceByAddCmp(int serviceByAddCmp) {
			this.serviceByAddCmp = serviceByAddCmp;
		}
		public int getServiceToAddCmp() {
			return serviceToAddCmp;
		}
		public void setServiceToAddCmp(int serviceToAddCmp) {
			this.serviceToAddCmp = serviceToAddCmp;
		}
		public int getServiceByBank() {
			return serviceByBank;
		}
		public void setServiceByBank(int serviceByBank) {
			this.serviceByBank = serviceByBank;
		}
		public String getInvoiceServicesbycmpname() {
			return invoiceServicesbycmpname;
		}
		public void setInvoiceServicesbycmpname(String invoiceServicesbycmpname) {
			this.invoiceServicesbycmpname = invoiceServicesbycmpname;
		}
		public String getInvoiceServicestocmpname() {
			return invoiceServicestocmpname;
		}
		public void setInvoiceServicestocmpname(String invoiceServicestocmpname) {
			this.invoiceServicestocmpname = invoiceServicestocmpname;
		}
		public String getInvoiceServicestoaddressname() {
			return invoiceServicestoaddressname;
		}
		public void setInvoiceServicestoaddressname(String invoiceServicestoaddressname) {
			this.invoiceServicestoaddressname = invoiceServicestoaddressname;
		}
		public String getInvoiceServicesbyaddressname() {
			return invoiceServicesbyaddressname;
		}
		public void setInvoiceServicesbyaddressname(String invoiceServicesbyaddressname) {
			this.invoiceServicesbyaddressname = invoiceServicesbyaddressname;
		}
		
		public String[] getSacNumber() {
			return sacNumber;
		}
		public void setSacNumber(String[] sacNumber) {
			this.sacNumber = sacNumber;
		}
		public String[] getServDescription() {
			return servDescription;
		}
		public void setServDescription(String[] servDescription) {
			this.servDescription = servDescription;
		}
		public String[] getValOfServ() {
			return valOfServ;
		}
		public void setValOfServ(String[] valOfServ) {
			this.valOfServ = valOfServ;
		}
		public int getServiceTaxinvoiceid() {
			return serviceTaxinvoiceid;
		}
		public void setServiceTaxinvoiceid(int serviceTaxinvoiceid) {
			this.serviceTaxinvoiceid = serviceTaxinvoiceid;
		}
		public String getServiceCreatedby() {
			return serviceCreatedby;
		}
		public void setServiceCreatedby(String serviceCreatedby) {
			this.serviceCreatedby = serviceCreatedby;
		}
		public String getServiceCreatedDate() {
			return serviceCreatedDate;
		}
		public void setServiceCreatedDate(String serviceCreatedDate) {
			this.serviceCreatedDate = serviceCreatedDate;
		}
		public String getServiceCreatedIp() {
			return serviceCreatedIp;
		}
		public void setServiceCreatedIp(String serviceCreatedIp) {
			this.serviceCreatedIp = serviceCreatedIp;
		}
		public int getTaxInvoiceId() {
			return taxInvoiceId;
		}
		public void setTaxInvoiceId(int taxInvoiceId) {
			this.taxInvoiceId = taxInvoiceId;
		}
		public double getValueAfterTax() {
			return valueAfterTax;
		}
		public void setValueAfterTax(double valueAfterTax) {
			this.valueAfterTax = valueAfterTax;
		}
		
		
		
		
		   
		   
}
