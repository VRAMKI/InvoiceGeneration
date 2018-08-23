package com.struts.invoicegen.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.struts.invoicegen.dao.TaxDetailsDao;

@Entity
@Table(name="gst_Percentage")
public class GstPercentageDao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int gstid;
	private double sgstper;
	private double igstper;
	private double cgstper;
	private int gstActiveFlag;
	private Date gst_createdDate;
	private String gst_CreatedIp;
	private String gstCreatedBy;
	
	/*@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="taxDetailsPer",referencedColumnName="taxid")
	private TaxDetailsDao taxPerDetailsDao;*/
	
	@OneToMany
	@JoinColumn(name="taxDetailsPer")
	private List<TaxDetailsDao> taxPerDetailsDao = new ArrayList<TaxDetailsDao>();

	public int getGstid() {
		return gstid;
	}

	public void setGstid(int gstid) {
		this.gstid = gstid;
	}

	public double getSgstper() {
		return sgstper;
	}

	public void setSgstper(double sgstper) {
		this.sgstper = sgstper;
	}

	public double getIgstper() {
		return igstper;
	}

	public void setIgstper(double igstper) {
		this.igstper = igstper;
	}

	public double getCgstper() {
		return cgstper;
	}

	public void setCgstper(double cgstper) {
		this.cgstper = cgstper;
	}

	

	public Date getGst_createdDate() {
		return gst_createdDate;
	}

	public void setGst_createdDate(Date gst_createdDate) {
		this.gst_createdDate = gst_createdDate;
	}

	public String getGst_CreatedIp() {
		return gst_CreatedIp;
	}

	public void setGst_CreatedIp(String gst_CreatedIp) {
		this.gst_CreatedIp = gst_CreatedIp;
	}

	public String getGstCreatedBy() {
		return gstCreatedBy;
	}

	public void setGstCreatedBy(String gstCreatedBy) {
		this.gstCreatedBy = gstCreatedBy;
	}

	public List<TaxDetailsDao> getTaxPerDetailsDao() {
		return taxPerDetailsDao;
	}

	public void setTaxPerDetailsDao(List<TaxDetailsDao> taxPerDetailsDao) {
		this.taxPerDetailsDao = taxPerDetailsDao;
	}

	public int getGstActiveFlag() {
		return gstActiveFlag;
	}

	public void setGstActiveFlag(int gstActiveFlag) {
		this.gstActiveFlag = gstActiveFlag;
	}

	

}
