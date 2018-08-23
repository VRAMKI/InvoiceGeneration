package com.struts.invoicegen.action;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.struts.invoicegen.dao.BankDetailsDao;
import com.struts.invoicegen.dto.BankDto;
import com.struts.invoicegen.model.BankModel;

public class BankAction extends ActionSupport implements ModelDriven<BankDto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BankDto bankDto = new BankDto();
	BankModel bankModel = new BankModel();
	List<BankDetailsDao> bankList;
	private int cmpyId;
	InputStream inputStream = null;

	public List<BankDetailsDao> getBankList() {
		return bankList;
	}

	public void setBankList(List<BankDetailsDao> bankList) {
		this.bankList = bankList;
	}

	public int getCmpyId() {
		return cmpyId;
	}

	public void setCmpyId(int cmpyId) {
		this.cmpyId = cmpyId;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public BankDto getModel() {
		// TODO Auto-generated method stub
		return bankDto;
	}

	public String bankFields() {
		System.out.println("GOING TO BANK MODEL CLASS");
		bankModel.saveBankDetails(bankDto);
		return SUCCESS;

	}

	public String fetchBank() {
		bankList = bankModel.fetchBankDetails(this.cmpyId);
		String bnkList = "";
		bnkList += "<option value='-1' > Select </option>";
		for (BankDetailsDao bnkDetails : bankList) {
			bnkList += "<option value='" + bnkDetails.getBid() + "' >"
					+ bnkDetails.getBank_shrtname()+ " </option>";
		}
		inputStream = new StringBufferInputStream(bnkList);
		return SUCCESS;

	}

}
