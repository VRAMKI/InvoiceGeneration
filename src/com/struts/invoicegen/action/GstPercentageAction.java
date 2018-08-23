package com.struts.invoicegen.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.struts.invoicegen.dto.TaxDetailsDto;
import com.struts.invoicegen.dto.TaxInvoiceServicesDto;
import com.struts.invoicegen.dao.GstPercentageDao;
import com.struts.invoicegen.model.GstPercentageModel;

public class GstPercentageAction extends ActionSupport implements ModelDriven<TaxDetailsDto>{

	
	private static final long serialVersionUID = 1L;
	GstPercentageModel gstModel = new GstPercentageModel();
	TaxDetailsDto taxDetailsDto = new TaxDetailsDto();
	TaxInvoiceServicesDto taxInvoiceServiceDto = new TaxInvoiceServicesDto();
	List<GstPercentageDao> gstfetchfields;
		
	public String gstPercentage() {
		gstModel.saveGstPercentage(taxDetailsDto);
		return SUCCESS;
	}

	@Override
	public TaxDetailsDto getModel() {
		// TODO Auto-generated method stub
		return taxDetailsDto;
	}
	
	
	
	public String fetchGstfields(){
		System.out.println("in gst fetch action ");
		this.gstfetchfields = gstModel.fetchgstperfields();
		for(GstPercentageDao ghg:gstfetchfields){
			System.out.println(ghg.getCgstper());
		}
		return SUCCESS;
	}

	public String updategstPercentage(){
		gstModel.updateGstPercentage(taxDetailsDto);
		return SUCCESS;
	}
	
	public List<GstPercentageDao> getGstfetchfields() {
		return gstfetchfields;
	}

	public void setGstfetchfields(List<GstPercentageDao> gstfetchfields) {
		this.gstfetchfields = gstfetchfields;
	}
	
}
