package com.struts.invoicegen.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.struts.invoicegen.dao.AddressDao;
import com.struts.invoicegen.dao.BankDetailsDao;
import com.struts.invoicegen.dao.CompanyDao;
import com.struts.invoicegen.dao.ServicesDao;
import com.struts.invoicegen.dao.TaxDetailsDao;
import com.struts.invoicegen.dao.TaxInvoiceDao;
import com.struts.invoicegen.model.TaxInvoiceModel;
import com.struts.invoicegen.util.HibernateUtil;

public class InvoicePdfGeneration {

	//public void generateInvoice(int i_id)
	public void generateInvoice(int taxid)
	{
		final ServletContext servletContext = ServletActionContext.getServletContext();
	    
	    
		TaxInvoiceDao taxInvoiceDao = new TaxInvoiceModel().retriveInvoiceDetails(taxid);
		AddressDao servByAddrObj = taxInvoiceDao.getSerByAddDao();
		AddressDao servToAddrObj = taxInvoiceDao.getSerToAddDao();
		CompanyDao servByCmpyObj = taxInvoiceDao.getSerBycmpDao();
		CompanyDao servToCmpyObj = taxInvoiceDao.getSerTocmpDao();
		BankDetailsDao bankObj = taxInvoiceDao.getBankDao();
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		
		String filename = taxInvoiceDao.getInvoice_num();
		String newfilename = filename.replace('/','_');
		System.out.println("filename"+filename);
		System.out.println("newfilename"+newfilename);
		String fileloc = servletContext.getRealPath("/invoices/GeneratedInvoices/"+newfilename+".pdf");
		
		
		Session sess = HibernateUtil.getSessionFactory().openSession();
		sess.beginTransaction();
		System.out.println("in pdf classsssssssssssssssssssssssssssssssss");
		try {
			OutputStream file = new FileOutputStream(new File(fileloc));
			Document document = new Document(PageSize.A4, 00, 00, 100, 30);
			PdfWriter.getInstance(document, file);
			
			
			
			document.open();
		        
		        PdfPCell cell1;
		        PdfPTable table1 = new PdfPTable(1);
		        cell1 = new PdfPCell(new Paragraph("TAX INVOICE",FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD, new BaseColor(0,112,192))));
		        cell1.setBackgroundColor(new BaseColor(251,212,180));
		        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				 table1.addCell(cell1);
		        document.add(table1);
		        
		        
		        PdfPTable table = new PdfPTable(6); // 4 columns.
		        
		        
		        PdfPCell cell;
				
		         cell = new PdfPCell(new Paragraph("Invoice no",FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(0,0,0))));
				 table.addCell(cell);
		         cell = new PdfPCell(new Paragraph(taxInvoiceDao.getInvoice_num(),FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(0,0,0))));
		         cell.setColspan(2);
				 table.addCell(cell);
		         cell = new PdfPCell(new Paragraph("Invoice Date",FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(0,0,0))));
				 table.addCell(cell);
		         cell = new PdfPCell(new Paragraph(taxInvoiceDao.getInvoice_date(),FontFactory.getFont(FontFactory.TIMES, 9, new BaseColor(0,0,0))));
		         cell.setColspan(2);
		         table.addCell(cell);
		        
		         
		         
		         /*3rd line */
		         
		         PdfPTable table2 = new PdfPTable(6);
		         
		     //    table2.setWidths(new float[] { 2,1,1,2,1,1 });
		         
		         cell = new PdfPCell(new Paragraph("Services By",FontFactory.getFont(FontFactory.TIMES, 10, Font.BOLD, new BaseColor(0, 0, 0))));
		         cell.setBackgroundColor(new BaseColor(251,212,180));
		         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				 cell.setVerticalAlignment(Element.ALIGN_CENTER);
				 cell.setColspan(3);
		         table2.addCell(cell);
		         cell = new PdfPCell(new Paragraph("Service To",FontFactory.getFont(FontFactory.TIMES, 10, Font.BOLD, new BaseColor(0, 0, 0))));
		         cell.setBackgroundColor(new BaseColor(251,212,180));
			     cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				 cell.setVerticalAlignment(Element.ALIGN_CENTER);
				 cell.setColspan(3);
		         table2.addCell(cell);
		         
   
		         /*4 TH LINE*/
		         
		         document.add( Chunk.NEWLINE );
		         cell = new PdfPCell(new Paragraph(" Name",FontFactory.getFont(FontFactory.TIMES, 10, Font.BOLD, new BaseColor(0, 0, 0))));
		         cell.setPaddingTop(1);
		         //cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 //cell.setVerticalAlignment(Element.ALIGN_LEFT);
				 
		         table2.addCell(cell);
				 cell = new PdfPCell(new Paragraph(servByCmpyObj.getCompany_name(),FontFactory.getFont(FontFactory.TIMES, 10, new BaseColor(0,0,0))));
				 cell.setColspan(2);
				 table2.addCell(cell);
				 cell = new PdfPCell(new Paragraph("  Name",FontFactory.getFont(FontFactory.TIMES, 10, Font.BOLD, new BaseColor(0, 0, 0))));
				 table2.addCell(cell);
				 cell = new PdfPCell(new Paragraph(servToCmpyObj.getCompany_name(),FontFactory.getFont(FontFactory.TIMES, 10,new BaseColor(0,0,0))));
				 cell.setColspan(2);
				 table2.addCell(cell);
		         
		         /*5th line*/
				 
				 
				 document.add( Chunk.NEWLINE );
		         cell = new PdfPCell(new Paragraph(" Address",FontFactory.getFont(FontFactory.TIMES, 10, Font.BOLD, new BaseColor(0, 0, 0))));
		         cell.setRowspan(2);
		         table2.addCell(cell);
		         
				 cell = new PdfPCell(new Paragraph(servByAddrObj.getAddress(),FontFactory.getFont(FontFactory.TIMES, 10,new BaseColor(0,0,0))));
				 cell.setColspan(2);
				 table2.addCell(cell);
				 
				 
				 cell = new PdfPCell(new Paragraph("  Address",FontFactory.getFont(FontFactory.TIMES, 10, Font.BOLD, new BaseColor(0, 0, 0))));
				 cell.setRowspan(2);
				 table2.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph(servToAddrObj.getAddress(),FontFactory.getFont(FontFactory.TIMES, 10,new BaseColor(0,0,0))));
				 cell.setColspan(2);
				 table2.addCell(cell);
				 
				 document.add( Chunk.NEWLINE );
				 
				 cell = new PdfPCell(new Paragraph(servByAddrObj.getLocality(),FontFactory.getFont(FontFactory.TIMES, 10,new BaseColor(0,0,0))));
				 cell.setColspan(2);
				 table2.addCell(cell);
				 
				 
				 cell = new PdfPCell(new Paragraph(servToAddrObj.getLocality(),FontFactory.getFont(FontFactory.TIMES, 10,new BaseColor(0,0,0))));
				 cell.setColspan(2);
				 table2.addCell(cell);
		         
				 
				 
				 /*6th line */
				 
				 document.add( Chunk.NEWLINE );
		         cell = new PdfPCell(new Paragraph(" GSTIN/UIN",FontFactory.getFont(FontFactory.TIMES, 10, Font.BOLD, new BaseColor(0,0,0))));
		         table2.addCell(cell);
		         
				 cell = new PdfPCell(new Paragraph(servByCmpyObj.getCompany_gstin(),FontFactory.getFont(FontFactory.TIMES, 10,new BaseColor(0,0,0))));
				 cell.setColspan(2);
				 table2.addCell(cell);
				 
				 
				 cell = new PdfPCell(new Paragraph(" GSTIN/UIN",FontFactory.getFont(FontFactory.TIMES, 10, Font.BOLD, new BaseColor(0, 0, 0))));
				 table2.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph(servToCmpyObj.getCompany_gstin(),FontFactory.getFont(FontFactory.TIMES, 10,new BaseColor(0,0,0))));
				 cell.setColspan(2);
				 table2.addCell(cell);
				 
				 /* 7TH VALUE */
				 
				 
				 document.add( Chunk.NEWLINE );
		         cell = new PdfPCell(new Paragraph(" State",FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(0, 0, 0))));
		         table2.addCell(cell);
		         
				 cell = new PdfPCell(new Paragraph(servByAddrObj.getAddress_state(),FontFactory.getFont(FontFactory.TIMES, 10,new BaseColor(0,0,0))));
				 cell.setColspan(2);
				 table2.addCell(cell);
				 
				 
				 cell = new PdfPCell(new Paragraph(" State",FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(0, 0, 0))));
				 table2.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph(servToAddrObj.getAddress_state(),FontFactory.getFont(FontFactory.TIMES, 10,new BaseColor(0,0,0))));
				 cell.setColspan(2);
				 table2.addCell(cell);
				 
				 /*8TH LINE */
				 

				 document.add( Chunk.NEWLINE );
		         cell = new PdfPCell(new Paragraph(" State Code",FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(0, 0, 0))));
		         table2.addCell(cell);
		         
				 cell = new PdfPCell(new Paragraph(servByAddrObj.getAddress_statecode(),FontFactory.getFont(FontFactory.TIMES, 10,new BaseColor(0,0,0))));
				 cell.setColspan(2);
				 table2.addCell(cell);
				 
				 
				 cell = new PdfPCell(new Paragraph(" State Code",FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(0, 0, 0))));
				 table2.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph(servToAddrObj.getAddress_state(),FontFactory.getFont(FontFactory.TIMES, 10,new BaseColor(0,0,0))));
				 cell.setColspan(2);
				 table2.addCell(cell);
				 
				 
				 /*8 line*/


				 document.add( Chunk.NEWLINE );
		         cell = new PdfPCell(new Paragraph(" Place of Supply",FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(0, 0, 0))));
		         table2.addCell(cell);
		         
				 cell = new PdfPCell(new Paragraph(taxInvoiceDao.getInvoice_plcofsupply(),FontFactory.getFont(FontFactory.TIMES, 10,new BaseColor(0,0,0))));
				 cell.setColspan(2);
				 table2.addCell(cell);
				 
				 
				 cell = new PdfPCell(new Paragraph(" Order Ref.No.",FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(0, 0, 0))));
				 table2.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph(taxInvoiceDao.getInvoice_orderrefnum(),FontFactory.getFont(FontFactory.TIMES, 10,new BaseColor(0,0,0))));
				 cell.setColspan(2);
				 table2.addCell(cell);
				 
				 
				 
				 /*Adding a new line */
				/* PdfPTable table3 = new PdfPTable(1);
				 cell = new PdfPCell(new Paragraph("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"));
		         table3.addCell(cell);
		         document.add(table3);*/
				 document.add( Chunk.NEWLINE );
				 cell = new PdfPCell(new Paragraph());
				 cell.setColspan(6);
				 cell.setPadding(6);
				 table2.addCell(cell);
				 
				 PdfPTable table3 = new PdfPTable(6);
				 table3.setWidths(new float[] { 1,2,3,1,2,3 });
		         
				 document.add( Chunk.NEWLINE );
		         cell = new PdfPCell(new Paragraph(" Sr.No",FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(0, 0, 0))));
		         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		         cell.setBackgroundColor(new BaseColor(251,212,180));
		         table3.addCell(cell);
		         
				 cell = new PdfPCell(new Paragraph( "SAC",FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(0, 0, 0))));
				 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				 cell.setBackgroundColor(new BaseColor(251,212,180));
				 table3.addCell(cell);
				 
				 
				 cell = new PdfPCell(new Paragraph(" Description Of Service",FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(0, 0, 0))));
				 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				 cell.setColspan(3);
				 cell.setBackgroundColor(new BaseColor(251,212,180));
				 table3.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph(" Value Of Services",FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(0, 0, 0))));
				 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				 cell.setBackgroundColor(new BaseColor(251,212,180));
				 table3.addCell(cell);
				 
				 /*9TH LINE DESCRIPTION*/
				 Query query = sess.createQuery("from ServicesDao s where s.taxInvoiceDao = :tid").setInteger("tid",taxInvoiceDao.getTid());
				 List<ServicesDao> serDao = query.list();
				 int i = 1;
				 for(ServicesDao serDaoList:serDao){
					 
					 String count = Integer.toString(i);
					 document.add( Chunk.NEWLINE );
			         cell = new PdfPCell(new Paragraph(count,FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(0, 0, 0))));
			         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			         table3.addCell(cell);
			         
					 cell = new PdfPCell(new Paragraph(serDaoList.getSacnumber(),FontFactory.getFont(FontFactory.TIMES, 9, new BaseColor(0, 0, 0))));
					 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					 table3.addCell(cell);
					 
					 
					 cell = new PdfPCell(new Paragraph(serDaoList.getDescription(),FontFactory.getFont(FontFactory.TIMES, 9,new BaseColor(0, 0, 0))));
					 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					 cell.setColspan(3);
					 table3.addCell(cell);
					 
					 
					 cell = new PdfPCell(new Paragraph(serDaoList.getValueofservice(),FontFactory.getFont(FontFactory.TIMES, 10,new BaseColor(0,0,0))));
					 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					 table3.addCell(cell);
					 
					 
					 i++;
					 
					 
				 }
				 
				 
				 
				 /*10TH LINE*/
				 
				 
				 Query taxQuery = sess.createQuery("from TaxDetailsDao tax where tax.taxInvoiceDao = :tid").setInteger("tid",taxInvoiceDao.getTid());
				 List<TaxDetailsDao> taxDeatilsDao = taxQuery.list();
				 
				 
				// TaxDetailsDao taxDeatilsDao =  (TaxDetailsDao) sess.get(TaxDetailsDao.class, taxInvoiceDao.getTid());
				 
				 document.add( Chunk.NEWLINE );
		         cell = new PdfPCell(new Paragraph(" ",FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(153, 0, 102))));
		         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		         table3.addCell(cell);
		         
				 cell = new PdfPCell(new Paragraph( "\u00a0 Total Amount Before Tax :",FontFactory.getFont(FontFactory.TIMES, 10, Font.BOLD,new BaseColor(0,0,0))));
				 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 cell.setColspan(4);
				 table3.addCell(cell);
			
				 String totbeforetax = decimalFormat.format(taxDeatilsDao.get(0).getValue_befor_tax());
				 
				 //System.out.println("taxxxx"+tax11);
				// String totbeforetax = Double.toString(taxDeatilsDao.get(0).getValue_befor_tax());
				
				 
				 cell = new PdfPCell(new Paragraph(totbeforetax,FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(0, 0, 0))));
				 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				 table3.addCell(cell);
				 
				 
				 /*11TH LINE */
				 
				 PdfPTable table4 = new PdfPTable(6);
				 table4.setWidths(new float[] { 1,5,1,1,1,3 });
				 
				 document.add( Chunk.NEWLINE );
		         cell = new PdfPCell(new Paragraph(" ",FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(0, 0, 0))));
		         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		         table4.addCell(cell);
		         
				 cell = new PdfPCell(new Paragraph( " 	Add : CGST :",FontFactory.getFont(FontFactory.TIMES, 10,Font.BOLD,new BaseColor(0,0,0))));
				 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 cell.setPaddingLeft(3);
				 //cell.setColspan(2);
				 table4.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph( " "));
				 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 table4.addCell(cell);
				 
				 String cgstper = "0.0",sgstper="0.0",igstper="0.0";
				 
				 
				 if(taxDeatilsDao.get(0).getIgstper() != 0.0){
					  cgstper = "0.0";
					  sgstper = "0.0";
					  igstper = decimalFormat.format(taxDeatilsDao.get(0).getIgstper());
					  cgstper = cgstper+"%";
					  sgstper = sgstper+"%";
					  igstper = igstper+"%";
				 }
				 else {
					 	cgstper = decimalFormat.format(taxDeatilsDao.get(0).getCgstper());
					 	sgstper = decimalFormat.format(taxDeatilsDao.get(0).getSgstper());
					 	cgstper = cgstper+"%";
					 	sgstper = sgstper+"%";
					 	igstper = igstper+"%";
				 }
				
				
				 
				 cell = new PdfPCell(new Paragraph(cgstper,FontFactory.getFont(FontFactory.TIMES, 9,new BaseColor(0,0,0))));
				 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 table4.addCell(cell);
				 
				 String cgstamt = decimalFormat.format(taxDeatilsDao.get(0).getCgstamount());
				 cell = new PdfPCell(new Paragraph(cgstamt,FontFactory.getFont(FontFactory.TIMES, 9,new BaseColor(0,0,0))));
				 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 table4.addCell(cell);
				 
				 
				 cell = new PdfPCell(new Paragraph(" ",FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(0, 0, 0))));
				 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				 table4.addCell(cell);
				
				 
					 document.add( Chunk.NEWLINE );
		         cell = new PdfPCell(new Paragraph(" ",FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(153, 0, 102))));
		         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		         table4.addCell(cell);
		         
				 cell = new PdfPCell(new Paragraph( " 	Add : SGST :",FontFactory.getFont(FontFactory.TIMES, 10,Font.BOLD,new BaseColor(0,0,0))));
				 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 cell.setPaddingLeft(3);
				 //cell.setColspan(2);
				 table4.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph( " "));
				 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 table4.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph(sgstper,FontFactory.getFont(FontFactory.TIMES, 9,new BaseColor(0,0,0))));
				 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 table4.addCell(cell);
				 
				 
				 String sgstamt = decimalFormat.format(taxDeatilsDao.get(0).getSgstamount());
				 cell = new PdfPCell(new Paragraph( sgstamt,FontFactory.getFont(FontFactory.TIMES, 9,new BaseColor(0,0,0))));
				 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 table4.addCell(cell);
				 
				 
				 cell = new PdfPCell(new Paragraph(" ",FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(0, 0, 0))));
				 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				 table4.addCell(cell);
				
				 
				 document.add( Chunk.NEWLINE );
		         cell = new PdfPCell(new Paragraph(" ",FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(153, 0, 102))));
		         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		         table4.addCell(cell);
		         
				 cell = new PdfPCell(new Paragraph( " 	Add : IGST\u00a0\u00a0:",FontFactory.getFont(FontFactory.TIMES, 10,Font.BOLD,new BaseColor(0,0,0))));
				 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 cell.setPaddingLeft(3);
				 //cell.setColspan(2);
				 table4.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph( " "));
				 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 table4.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph(igstper,FontFactory.getFont(FontFactory.TIMES, 9,new BaseColor(0,0,0))));
				 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 table4.addCell(cell);
				 
				 String igstamt = decimalFormat.format(taxDeatilsDao.get(0).getIgstamount());
				 cell = new PdfPCell(new Paragraph(igstamt,FontFactory.getFont(FontFactory.TIMES, 9,new BaseColor(0,0,0))));
				 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 table4.addCell(cell);
				 
				
				 cell = new PdfPCell(new Paragraph(" ",FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(0, 0, 0))));
				 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				 table4.addCell(cell);
				
				 
				 document.add( Chunk.NEWLINE );
		         cell = new PdfPCell(new Paragraph(" ",FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(153, 0, 102))));
		         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		         table4.addCell(cell);
		         
				 cell = new PdfPCell(new Paragraph( "  Total Amount:GST :",FontFactory.getFont(FontFactory.TIMES, 10,Font.BOLD,new BaseColor(0,0,0))));
				 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 cell.setPaddingLeft(3);
				 //cell.setColspan(2);
				 table4.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph( " "));
				 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 table4.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph( " "));
				 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 table4.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph( " "));
				 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 table4.addCell(cell);
				 
				 String gstamt = decimalFormat.format(taxDeatilsDao.get(0).getGstAmount());
				 cell = new PdfPCell(new Paragraph(gstamt,FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(0, 0, 0))));
				 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				 table4.addCell(cell);
				
				 
				 
				 document.add( Chunk.NEWLINE );
		         cell = new PdfPCell(new Paragraph(" ",FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(153, 0, 102))));
		         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		         table4.addCell(cell);
		         
				 cell = new PdfPCell(new Paragraph( " 	Total Amount After Tax :",FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(0, 0, 0))));
				 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 cell.setPaddingLeft(3);
				 //cell.setColspan(2);
				 table4.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph( " "));
				 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 table4.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph( " "));
				 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 table4.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph( " "));
				 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 table4.addCell(cell);
				 
				 String totamtaftertax = decimalFormat.format(taxDeatilsDao.get(0).getValue_after_tax());
				 cell = new PdfPCell(new Paragraph(totamtaftertax,FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(0, 0, 0))));
				 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				 table4.addCell(cell);
				 
				 
				 document.add( Chunk.NEWLINE );
		         cell = new PdfPCell(new Paragraph(" ",FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD, new BaseColor(153, 0, 102))));
		         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		         table4.addCell(cell);
		         
				 cell = new PdfPCell(new Paragraph( " 	Total Invoice Amount In Words",FontFactory.getFont(FontFactory.TIMES, 10,Font.BOLD,new BaseColor(0,0,0))));
				 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 cell.setPaddingLeft(3);
				 //cell.setColspan(2);
				 table4.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph( " NINETY NINE LAKHS NINETY NINE THOUSAND NINE HUNDRAD AND NINETY NINE",FontFactory.getFont(FontFactory.TIMES, 10,new BaseColor(0,0,0))));
				 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 cell.setColspan(4);
				 table4.addCell(cell);
				 
				 PdfPTable table5 = new PdfPTable(6);//1,5,1,1,1,3
				 //table5.setWidths(new float[] { 4,2,4});
				 table5.setWidths(new float[] { 1,3,3,1,1,3});
				

				 cell = new PdfPCell(new Paragraph(" Bank Details:",FontFactory.getFont(FontFactory.TIMES, 10, Font.BOLD, new BaseColor(0,0,0))));
				 cell.setBackgroundColor(new BaseColor(251,212,180));
				 cell.setColspan(3);
				 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				 table5.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph("For VitalSoft Artifacts Pvt Ltd., \n\n\n\n\n\n Authorised Signatory",FontFactory.getFont(FontFactory.TIMES, 10,Font.BOLD,new BaseColor(0,0,0))));
				 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				 cell.setVerticalAlignment(Element.ALIGN_TOP);
				 cell.setColspan(3);
				 cell.setRowspan(5);
				 table5.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph(" *Bank A/C Number",FontFactory.getFont(FontFactory.TIMES, 10, Font.BOLD, new BaseColor(0,0,0))));
				 cell.setColspan(2);
				 table5.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph(bankObj.getBank_acnum(),FontFactory.getFont(FontFactory.TIMES, 10,  new BaseColor(0,0,0))));
				 table5.addCell(cell);
				 
				 
				 cell = new PdfPCell(new Paragraph(" *Bank Name",FontFactory.getFont(FontFactory.TIMES, 10,Font.BOLD,new BaseColor(0,0,0))));
				 cell.setColspan(2);
				 table5.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph(bankObj.getBank_name(),FontFactory.getFont(FontFactory.TIMES, 10,new BaseColor(0,0,0))));
				 table5.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph(" *Branch Name",FontFactory.getFont(FontFactory.TIMES, 10,Font.BOLD,new BaseColor(0,0,0))));
				 cell.setColspan(2);
				 table5.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph(bankObj.getBranch_name(),FontFactory.getFont(FontFactory.TIMES, 10,new BaseColor(0,0,0))));
				 table5.addCell(cell);
				 
				 
				 cell = new PdfPCell(new Paragraph(" *Bank IFSC Code",FontFactory.getFont(FontFactory.TIMES, 10,Font.BOLD,new BaseColor(0,0,0))));
				 cell.setColspan(2);
				 table5.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph(bankObj.getBank_ifsccode(),FontFactory.getFont(FontFactory.TIMES, 10,new BaseColor(0,0,0))));
				 table5.addCell(cell);
				 
				 
				 cell = new PdfPCell(new Paragraph(" -Request to pay with in 30DAYS FROM THE DATE OF INVOICE",FontFactory.getFont(FontFactory.TIMES, 10,Font.BOLD,new BaseColor(0,0,0))));
				 cell.setColspan(6);
				 table5.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph(" Whether Tax Payable Under Reverse Charge",FontFactory.getFont(FontFactory.TIMES, 10,Font.BOLD,new BaseColor(0,0,0))));
				 cell.setColspan(5);
				 table5.addCell(cell);
				 
				 cell = new PdfPCell(new Paragraph(" No",FontFactory.getFont(FontFactory.TIMES, 10,new BaseColor(0,0,0))));
				 table5.addCell(cell);
				 
				 
		         /*cell = new PdfPCell(new Paragraph("Address"));
				 table.addCell(cell);
				 cell = new PdfPCell(new Paragraph("Contract Employee"));
		         table.addCell(cell);
		        */
				 
		       /* for(Employee e:list) {	
		        	
		        	String i= Integer.toString(e.getId());
					//table.addCell(cell);
		        	 cell = new PdfPCell(new Paragraph(i));
					 table.addCell(cell);
		        	 cell = new PdfPCell(new Paragraph(e.getName()));
					 table.addCell(cell);
		        	 cell = new PdfPCell(new Paragraph(e.getDesignation()));
					 table.addCell(cell);
		        	 cell = new PdfPCell(new Paragraph(Integer.toString(e.getContact())));
					 table.addCell(cell);
		        	 cell = new PdfPCell(new Paragraph(e.getAddress()));
					 table.addCell(cell);
		        	 cell = new PdfPCell(new Paragraph(e.getContract()));
					 table.addCell(cell);
		        	 }
		        */
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		       /* PdfPCell cell1 = new PdfPCell(new Paragraph("SNo"));
		        PdfPCell cell2 = new PdfPCell(new Paragraph("Name"));
		        PdfPCell cell3 = new PdfPCell(new Paragraph("Designation"));
		        PdfPCell cell4 = new PdfPCell(new Paragraph("Contact"));
		        PdfPCell cell5 = new PdfPCell(new Paragraph("Address"));
		        PdfPCell cell6 = new PdfPCell(new Paragraph("Contract Employee"));
		        table.addCell(cell1);
		        table.addCell(cell2);
		        table.addCell(cell3);
		        table.addCell(cell4);
		        table.addCell(cell5);
		        table.addCell(cell6);
		        
		        for(Employee e:list) {	
		        	
		        	String i= Integer.toString(e.getId());
		        	 cell1 = new PdfPCell(new Paragraph(i));
		        	 cell2 = new PdfPCell(new Paragraph(e.getName()));
		        	 cell3 = new PdfPCell(new Paragraph(e.getDesignation()));
		        	 cell4 = new PdfPCell(new Paragraph(Integer.toString(e.getContact())));
		        	 cell5 = new PdfPCell(new Paragraph(e.getAddress()));
		        	 cell6 = new PdfPCell(new Paragraph(e.getContract()));
		        	 table.addCell(cell1);
				        table.addCell(cell2);
				        table.addCell(cell3);
				        table.addCell(cell4);
				        table.addCell(cell5);
				        table.addCell(cell6);
		        }*/     		        
		   document.add(table);
		   
		   document.add(table2);
		   document.add(table3);
		   document.add(table4);
		   document.add(table5);
			document.close();
			file.close();
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}
