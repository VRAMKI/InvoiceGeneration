<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
    <%@page import="java.sql.*,java.io.*,java.util.*,java.nio.file.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
<table id="invoicelist" border="1">
<tr>
	<th>S.no</th>
	<th>Invoice Num</th>
	<th>Amount</th>
	<th>Invoice Date</th>
	<th>Order Ref No</th>
	<!-- <th>Delete Invoice</th>
	<th>Edit Invoice</th>
	<th>Download Invoice</th> -->
	<th>invoices</th>
</tr>
<%-- <% int i = 1; %>  --%><s:set var="i" value="1" /> 
<s:iterator value="#request.invoicelist">
					<tr>
						<td><%-- <% out.println(i) ;%>  --%><s:property value="%{#i}" /> </td>
						<td><s:property value="invoice_num"/></td>
						<td><s:property value="valueAfterTax"/></td>
						<td><s:property value="invoiceDate"/></td>
						<td><s:property value="invoiceOrderrefnum"/></td>
						<%-- <td><a href="delete.action?tid=<s:property value="tid"/>">Delete</a></td>
						<td><a href="edit.action?tid=<s:property value="tid"/>">Edit</a></td>
						<td><a href="download.action?tid=<s:property value="tid"/>">Download Invoice</a></td> --%>
						
						
						<s:set var="filename" value="%{invoice_num}" />
						<%-- <s:set var="newfilename" value="%{#filename.replace('/','_')}" /> --%>
						
						<s:set var="newfilename" value="%{'invoices/GeneratedInvoices/'+#filename.replace('/','_')+'.pdf'}" />
					
						<%-- <s:property value="newfilename"/> --%>
						<%-- <s:set var="newfile" value="%{'invoices/GeneratedInvoices/'+#newfilename+'.pdf'}"/>
						<s:property value="newfile"/> --%>
						
						<td><s:a href="%{#newfilename}" target="blank">Click To View <br> Invoice</s:a></td>
					</tr>
						
						
				<%-- 	<% String filename = %{invoice_num};
					String newfilename = filename.replace('/','_'); %>
					<% System.out.println("invoice_num");  %>
					<% i++; %>  --%>
					
					<s:set var="i" value="%{#i+1}"  />
				</s:iterator>
				</table>
				
</body>
</html>