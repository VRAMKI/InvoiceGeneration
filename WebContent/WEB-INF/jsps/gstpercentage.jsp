<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:form action="gstpercentage" method="post">
		<table>
			<tr>
				<td>CGST Percentage</td>
				<td>&emsp;:&emsp;</td>
				<td><s:textfield name="cgstPercentage"></s:textfield></td>
			</tr>
			<tr>
				<td>SGST Percentage</td>
				<td>&emsp;:&emsp;</td>
				<td><s:textfield name="sgstPercentage"></s:textfield></td>
			</tr>
			
		<tr>
				<td>IGST Percentage</td>
				<td>&emsp;:&emsp;</td>
				<td><s:textfield name="igstPercentage"></s:textfield></td>
			</tr>
		
			</table>
			<s:submit value="save gst"></s:submit>
			</s:form>
			
			<s:form action="updateactivegst" method="post">
			<table id = "gstlist" border="1">
			<tr>
			<th>id</th>
			<th>CGST PERCENTAGE</th>
			<th>SGST PERCENTAGE</th>
			<th>IGST PERCENTAGE</th>
			<th>Active GST calculation</th>
			</tr>
			<s:set var="i" value="1"/>
				<s:iterator value="gstfetchfields">
				<s:set var="cgstperr" value="cgstper"/>
				<s:set var="sgstperr" value="sgstper"/>
				<s:set var="igstperr" value="igstper"/>
				<%-- <s:set var="gstFlag" value="gstActiveFlag"/> --%>
					<tr>
						<td><s:property value="%{#i}"/></td>
						<td><s:textfield value="%{#cgstperr}" name="cgstper"/></td>
						<td><s:textfield value="%{#sgstperr}" name="sgstper"/></td>
						<td><s:textfield value="%{#igstperr}" name="igstper"/></td>
						<s:if test="gstActiveFlag == 1"><td><s:radio list="#{gstid:'Yes'}"  name="gstActiveFlag" value="gstid"></s:radio></td></s:if>
						<s:elseif test="gstActiveFlag == 0"><td><s:radio list="#{gstid:'Yes'}"  name="gstActiveFlag" ></s:radio></td> </s:elseif>
					</tr>
					<s:set var="i" value="%{#i+1}"/>
				</s:iterator>
			
			</table>
			<br>
			<s:submit value="update Active GST"></s:submit>
			</s:form>
			
</body>
</html>