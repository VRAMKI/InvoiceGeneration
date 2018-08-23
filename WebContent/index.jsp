<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>



<script>


$(document).ready(function(){
	
	    $.ajax({
	    url : "getServByCmpyList",
	    success : function(result) {
	    var s1=0,s2="--select--";
	    
	    $("#serviceByAddCmp").get(0).options.length = 0;
        $("#serviceByAddCmp").append("<option value='" + s1 + "'>"+ s2 +"</option>");
        $("#serviceByBank").get(0).options.length = 0;
        $("#serviceByBank").append("<option value='" + s1 + "'>"+ s2 +"</option>");
	    $("#serviceByCmp").append("<option value='" + s1 + "'>"+ s2 +"</option>");
	    $("#serviceByCmp").html(result);
	     
	    }
	   }); 
	 
 


$('#serviceByCmp').on('change', function(){
		var ss = $('#serviceByCmp option:selected').val(); 		
	
	$.ajax({
		type : 'GET',
		/* data : 'selectedCompanyId=' + ss, */
		url : "getServToCmpyList?cmpyId=" + $(this).val(),
		success: function(serToresult)
		{
		
			 var s1=0,s2="--select--";
	         $("#serviceToAddCmp").get(0).options.length = 0;
	         $("#serviceToAddCmp").append("<option value='" + s1 + "'>"+ s2 +"</option>");
	         $("#serviceToCmp").html(serToresult); 
			}			
	})		
	})








$('#serviceByCmp').on('change', function(){
	var ss = $('#serviceByCmp option:selected').val(); 		

$.ajax({
	type : 'GET',
/* 	data : 'selectedCompanyId=' + ss, */
	url : "getServByAddList?cmpyId=" + $(this).val(),
	success: function(serByAdd)
	{
		
		 var s1=0,s2="--select--";
         /* $("#serviceToAddCmp").get(0).options.length = 0;
         $("#serviceToAddCmp").append("<option value='" + s1 + "'>"+ s2 +"</option>"); */
         $("#serviceByAddCmp").html(serByAdd); 
		}			
})		
})







$('#serviceToCmp').on('change', function(){
	var ss = $('#serviceToCmp option:selected').val(); 		

$.ajax({
	type : 'GET',
/* 	data : 'selectedCompanyId=' + ss, */
	url : "getServToAddList?cmpyId=" + $(this).val(),
	success: function(serByAdd)
	{
	
		 var s1=0,s2="--select--";
         /* $("#serviceToAddCmp").get(0).options.length = 0;
         $("#serviceToAddCmp").append("<option value='" + s1 + "'>"+ s2 +"</option>"); */
         $("#serviceToAddCmp").html(serByAdd); 
		}			
})		
})
























$('#serviceByCmp').on('change', function(){
	var ss = $('#serviceByCmp option:selected').val(); 		

$.ajax({
	type : 'GET',
	/* data : 'selectedCompanyId=' + ss, */
	url : "getServByBnkList?cmpyId=" + $(this).val(),
	success: function(bnkList)
	{
		
		 var s1=0,s2="--select--";
         /* $("#serviceToAddCmp").get(0).options.length = 0;
         $("#serviceToAddCmp").append("<option value='" + s1 + "'>"+ s2 +"</option>"); */
         $("#serviceByBank").html(bnkList); 
		}			
})		
})



});



</script>


<!-- =====================================TESTING CODE ====================================== -->



<script type="text/javascript">
	
	var table = document.getElementById('servDetails'),
    tbody = table.getElementsByTagName('tbody')[0],
    clone = tbody.rows[0].cloneNode(true);

	function updateRow(row, i, reset) {	
	    row.cells[0].innerHTML = i;

	    var inp1 = row.cells[1].getElementsByTagName('input')[0];
	    var inp2 = row.cells[2].getElementsByTagName('input')[0];
		var inp3 = row.cells[3].getElementsByTagName('input')[0];
	    inp1.id = 'sacNumber' + i;
	    inp2.id = 'servDescription' + i;
		inp3.id = 'valOfServ' + i;

	    if (reset) {
	        inp1.value = inp2.value = inp3.value ='';
	    }
	    return row;
	}
function deleteRow(el) {
	var table = document.getElementById('servDetails'),
    tbody = table.getElementsByTagName('tbody')[0],
    clone = tbody.rows[0].cloneNode(true);
	
    var i = el.parentNode.parentNode.rowIndex;
    document.getElementById('servDetails').deleteRow(i);
    while (table.rows[i]) {
        updateRow(table.rows[i], i, false);
        i++;
    }
}

function insRow() {
var table = document.getElementById('servDetails'),
tbody = table.getElementsByTagName('tbody')[0],
clone = tbody.rows[0].cloneNode(true);
    var new_row = updateRow(clone.cloneNode(true), ++tbody.rows.length, true);
    tbody.appendChild(new_row);
}


	</script>
	
	
	



<!-- ========================================================================================================= -->





<title>Insert title here</title>
</head>
<body>
	<s:form action="geninvoice" method="post">
	<s:token></s:token>
		<fieldset>
			<legend>Firms</legend>
			
			<table>
			<tr>
					<td>Invoice Date</td>
					<td>&emsp;:&emsp;</td>
					<td><s:textfield name="invoiceDate"></s:textfield></td>
					<td>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</td>
					<td></td>
				</tr>
			
				<tr>
					<td>Select service By</td>
					<td>&emsp;:&emsp;</td>
					<td><select name="serviceByCmp" id="serviceByCmp"></select></td>
					<td>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</td>
					<td><s:a href="addfirms">Add New firms</s:a></td>
				</tr>
				<tr>
					<td>Select service By address</td>
					<td>&emsp;:&emsp;</td>
					<td><select name="serviceByAddCmp" id="serviceByAddCmp"></select></td>
					<td>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</td>
					<td><s:a href="addaddress">Add New address</s:a></td>
				</tr>
				<tr>
					<td>Select Bank</td>
					<td>&emsp;:&emsp;</td>
					<td><select name="serviceByBank" id="serviceByBank"></select></td>
					<td>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</td>
					<td><s:a href="addBank">Add New Bank</s:a></td>
				</tr>
				
				
				
           <!-- 	=======================Services to ====================================		 -->	
				
				<tr>
					<td>Select service To</td>
					<td>&emsp;:&emsp;</td>
					<td><select name="serviceToCmp" id="serviceToCmp"></select></td>
					<td>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</td>
					<td></td>
				</tr>
				<tr>
					<td>Select service To address</td>
					<td>&emsp;:&emsp;</td>
					<td><select name="serviceToAddCmp" id="serviceToAddCmp"></select></td>
					<td>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</td>
					<td></td>
				</tr>
				
				
				<tr>
					<td>Place Of Supply</td>
					<td>&emsp;:&emsp;</td>
					<td><s:textfield name="invoicePlcofsupply"></s:textfield></td>
					<td>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</td>
					<td></td>
				</tr>
				
				
				
				<tr>
					<td>Order Ref Num</td>
					<td>&emsp;:&emsp;</td>
					<td><s:textfield name="invoiceOrderrefnum"></s:textfield></td>
					<td>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</td>
					<td></td>
				</tr>
				
				
				
				
					</table>
					</fieldset>
					<fieldset>
					<legend>Services</legend>
					<table>
				<%-- <tr>
					<td>SAC Number</td>
					<td>&emsp;:&emsp;</td>
					<td><s:textfield name="sacNumber"></s:textfield></td>
					<td>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</td>
					<td></td>
					<td>Description</td>
					<td>&emsp;:&emsp;</td>
					<td><s:textarea  name="servDescription"></s:textarea></td>
					<td>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</td>
					<td></td>
					<td>Value of services</td>
					<td>&emsp;:&emsp;</td>
					<td><s:textfield name="valOfServ"></s:textfield></td>
					<td>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</td>
					<td></td>
					<td><button>Add new</button></td>
				</tr> --%>

			</table>
			
			
			
			
			
			
			
			
			
			
			
			
			
<!-- ===============================CODE TESTING============================================	 -->
			
  
	 <table id="servDetails" border="1">
        <thead>
            <tr>
                <td>S.No</td>
                <td>SAC Number</td>
                <td>Description</td>
                <td>Value Of Service</td>
                <td>Delete?</td>
                <td>Add Rows?</td>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                 <td><s:textfield name="sacNumber" id="sacNumber"></s:textfield></td>
				<td><s:textfield name="servDescription" id="servDescription"></s:textfield></td>
				<td><s:textfield name="valOfServ" id="valOfServ"></s:textfield></td>
                <td><input type="button" id="delServbutton" value="Delete" onclick="deleteRow(this)"/></td>
                <td><input type="button" id="addmoreSerbutton" value="Add More" onclick="insRow()"/></td>
            </tr>
        </tbody>
    </table>		
			
<!-- ===================================================================================================	 -->		
			
			
			<table>
			<tr>
				<td>IGST</td>
				<td>&emsp;:&emsp;</td>
				<td><s:radio list="{'Yes','No'}" name="igstRadio"></s:radio></td>
				<td><s:a href="addNewGstPer">Add New GST Percentage</s:a></td>
				
			</tr>
			</table>
			
			
			
			
			
			
			
			
			
			
			
			
			
		</fieldset>
		<s:submit value="Save Invoice"></s:submit>
		<s:a href="ViewInvoice">View Invoices</s:a>
	</s:form>
</body>
</html>