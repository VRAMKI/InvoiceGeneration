<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:form action="firmfields" method="post">
		<table>
			<tr>
				<td>Name</td>
				<td>&emsp;:&emsp;</td>
				<td><s:textfield name="cname"></s:textfield></td>
			</tr>
			<tr>
				<td>GSTIN/UIN</td>
				<td>&emsp;:&emsp;</td>
				<td><s:textfield name="cgstin"></s:textfield></td>
			</tr>
			<tr>
				<td>Firm short name</td>
				<td>&emsp;:&emsp;</td>
				<td><s:textfield name="cmpshrtname"></s:textfield></td>
			</tr>
		</table>
		<s:submit value="save"></s:submit>
	</s:form>
</body>
</html>