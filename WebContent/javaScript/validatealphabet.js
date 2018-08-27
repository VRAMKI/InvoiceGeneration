		/*===================validating Alphabets only=========================*/
		
		function validAlphabet(evt) {
		
			var asciicode = (evt.which) ? evt.which : evt.keyCode
			if ((asciicode < 65 || asciicode > 90)
					&& (asciicode < 97 || asciicode > 123) && asciicode != 32
					&& asciicode != 08 && asciicode != 09 && asciicode != 46
					&& asciicode != 37 && asciicode != 39) {
				alert("Enter alphabets only");
				return false;
			}
			return true;
		}
		
		/*=======================validating entire form===============================*/
		
		function validateInvoiceForm() {
			var docForm = document.invoiceFormFields;
			var invoceDate = docForm.invoiceDate.value;
			var servBy = docForm.serviceByCmp.value;
			var servByAddres = docForm.serviceByAddCmp.value;
			var servByBank = docForm.serviceByBank.value;
			var servTo = docForm.serviceToCmp.value;
			var serToAddrress = docForm.serviceToAddCmp.value;
			var plcOfSupply = docForm.invoicePlcofsupply.value;
			var orderOfSupply = docForm.invoiceOrderrefnum.value;
			
			
			/*for invoice date*/
			if(invoceDate==""){
				alert("please select date ");
				docForm.invoiceDate.focus();
				return false;
			}
			
			/*for service by company*/
			if(servBy==-1){
				alert("please select Service By company name else add company  ");
				docForm.serviceByCmp.focus();
				return false;
			}
			/*for serv by address*/
			if(servByAddres==-1 || servByAddres==0){
				alert("please select Service By Address name else add Address  ");
				docForm.serviceByAddCmp.focus();
				return false;
			}
			/*for serv by bank*/
			if(servByBank==-1 || servByBank==0){
				alert("please select Service By Bank name else add Bank  ");
				docForm.serviceByBank.focus();
				return false;
			}
			
			/*for serv To company */
			if(servTo==-1 || servTo==0){
				alert("please select Service To Company Name  ");
				docForm.serviceToCmp.focus();
				return false;
			}
			/*for serv To address*/
			if(serToAddrress==-1 || serToAddrress==0){
				alert("please select Service To Address name else add Address  ");
				docForm.serviceToAddCmp.focus();
				return false;
			}
			
			
			
			
			
			
			var trimaPlcOfSupply = plcOfSupply.trim();
			var replaceplcOfSupply= trimaname.replace(/\s+/g, ' ');
			var len = replaceaname.length;
			if (len < 3) {
				alert("Please Fill Name");
				docForm.artistename.focus();
				return false;

			}
			
		}