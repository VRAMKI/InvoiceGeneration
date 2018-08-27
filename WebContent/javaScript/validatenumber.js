	function validatenum(evt) {
		var asciicode = (evt.which) ? evt.which : evt.keyCode

				var asciicode = (evt.which) ? evt.which : evt.keyCode
						if ((asciicode < 48 || asciicode > 57)  
								&& asciicode != 08 && asciicode != 09 && asciicode !=46 
								&& asciicode !=37 && asciicode != 39 )
						{
						alert("Enter Numbers only");
						return false;
					}
						return true;
					} 	
	

	function validatealphanum(evt) {
		var asciicode = (evt.which) ? evt.which : evt.keyCode

				var asciicode = (evt.which) ? evt.which : evt.keyCode
						if ((asciicode < 48 || asciicode > 57)  && (asciicode < 65 || asciicode > 90) 
								&& 	(asciicode < 97 || asciicode > 123) 
								&& asciicode != 08 && asciicode != 09 && asciicode !=46 
								&& asciicode !=37 && asciicode != 39 )
						{
						alert("Enter Alphabets or Numbers only");
						return false;
					}
						return true;
					} 	

