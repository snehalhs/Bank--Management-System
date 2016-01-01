/**
 * 
 */
function validate(){
	
	 var a=document.forms["BankStatement"]["fdate"].value;
	   var b=document.forms["BankStatement"]["tdate"].value; 
	    var c=document.forms["BankStatement"]["Transaction_type"].value; 
	    var d=document.forms["BankStatement"]["Transaction_per_page"].value;
	     if (a==null || a=="")
		{
	    	document.getElementById("message").innerHTML="from date is empty";
	    	//alert("from date is empty");
			return false;
		}
	    if (b==null || b=="")
		{
	    	document.getElementById("message").innerHTML="to date is empty";
	    	//alert("to date is empty");
			return false;
		}
	    if (c==null || c=="" || c=="select")
		{
	    	document.getElementById("message").innerHTML="plz specify transaction type";
	    	//alert("plz specify transaction type");
			return false;
		}
	    if (d==null || d=="" || d=="select")
		{
	    	document.getElementById("message").innerHTML="specify no of transaction per page";
			//alert("specify no of transaction per page");
			return false;
		}
	   
	}