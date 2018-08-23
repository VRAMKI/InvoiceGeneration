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
	<s:form action="addressform" method="post">
		<table>
			<tr>
				<td>Select Company</td>
				<td>&emsp;:&emsp;</td>
				<td><s:select name="cmpId" id="cmpId"
						list="cmplist" listKey="cid" listValue="company_name"
						headerKey="-1" headerValue="select"></s:select></td>
			</tr>
			<tr>
				<td>Address</td>
				<td>&emsp;:&emsp;</td>
				<td><s:textarea name="address"></s:textarea></td>
			</tr>
			<tr>
				<td>Locality</td>
				<td>&emsp;:&emsp;</td>
				<td><s:textarea name="locality"></s:textarea></td>
			</tr>

			<tr>
				<td>State</td>
				<td>&emsp;:&emsp;</td>
				<td><s:textfield name="addstate"></s:textfield></td>
			</tr>
			<tr>
				<td>State code</td>
				<td>&emsp;:&emsp;</td>
				<td><s:textfield name="addstatecode"></s:textfield></td>
			</tr>
			<tr>
				<td>Specify short name <br> for this address
				</td>
				<td>&emsp;:&emsp;</td>
				<td><s:textfield name="addshrtname"></s:textfield></td>
			</tr>
		</table>
		<br>
		<s:submit value="save address"></s:submit>
	</s:form>
</body>
</html>