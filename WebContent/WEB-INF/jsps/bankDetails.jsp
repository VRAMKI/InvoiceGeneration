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
	<s:form action="bankForm" method="post">
		<table>
			<tr>
				<td>Select Company</td>
				<td>&emsp;:&emsp;</td>
				<td><s:select name="cmpId" id="cmpId"
						list="cmplist" listKey="cid" listValue="company_shrtname"
						headerKey="-1" headerValue="select"></s:select></td>
			</tr>
			<tr>
				<td>Bank Name</td>
				<td>&emsp;:&emsp;</td>
				<td><s:textfield name="bname"></s:textfield></td>
			</tr>
			<tr>
				<td>Bank Account Num</td>
				<td>&emsp;:&emsp;</td>
				<td><s:textfield name="bacnum"></s:textfield></td>
			</tr>

			<tr>
				<td>Branch Name</td>
				<td>&emsp;:&emsp;</td>
				<td><s:textfield name="brname"></s:textfield></td>
			</tr>
			<tr>
				<td>Bank IFSC Code</td>
				<td>&emsp;:&emsp;</td>
				<td><s:textfield name="bifsccode"></s:textfield></td>
			</tr>
			<tr>
				<td>Specify short name <br> for this Bank
				</td>
				<td>&emsp;:&emsp;</td>
				<td><s:textfield name="bshrtName"></s:textfield></td>
			</tr>
		</table>
		<br>
		<s:submit value="save Bank Details"></s:submit>
	</s:form>
</body>
</html>