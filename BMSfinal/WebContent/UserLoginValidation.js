/**
 * 
 */
function validateUserLogin()
{
	var a=document.forms["userLogin"]["cusid"].value;
	   var b=document.forms["userLogin"]["pwd"].value; 
	   if (a==null || a=="")
		{
	    	document.getElementById("message").innerHTML="Customer id is empty";
	    	//alert("from date is empty");
			return false;
		}
	    if (b==null || b=="")
		{
	    	document.getElementById("message").innerHTML="Password cannot be blank";
	    	//alert("to date is empty");
			return false;
		}

}
