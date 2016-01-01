/**
 * 
 */
function validateForm1()
{	
	var num1=/^\d{10}$/;
	var num2=/^\d{16}$/;
	var num3=/^\d{3,5}$/;
	var email=/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var a=document.forms["check"]["ADDRESS"].value;
	var b=document.forms["check"]["CONTACT_NUMBER"].value;
	var d=document.forms["check"]["EMAIL"].value;
	var e=document.forms["check"]["MARITAL_STATUS"].value;	
	var f=document.forms["check"]["ACC_TYPE"].value;
	var g=document.forms["check"]["CITIZENSHIP"].value;
	var h=document.forms["check"]["CITIZEN_STATUS"].value;
	var i=document.forms["check"]["GUARDIAN_TYPE"].value;
	var c=document.forms["check"]["GUARDIAN_NAME"].value;
	if (a==null || a=="")
		{document.getElementById("message").innerHTML="enter the address";		
		return false;
	}
	if(b==null || b=="")
		{
		document.getElementById("message").innerHTML="enter the contact number";		
		return false;
		}
	if(!num1.test(b))
	{
		document.getElementById("message").innerHTML="Contact number should be 10 digit number";
		return false;
	}	
	if(c==null || c=="")
		{
		document.getElementById("message").innerHTML="enter guardian name";
		return false;
		}
	if (d==null || d=="")
	{
		document.getElementById("message").innerHTML="enter email id";		
		return false;
	}
	if(!email.test(d))	
	{
		document.getElementById("message").innerHTML="Email id should be in the following format 'abc@xyz.com' ";
		return false;
	}
if(!document.getElementById("married").checked && !document.getElementById("unmarried").checked){
		
	document.getElementById("message").innerHTML="enter marital status";	
		return false;		
	}
	
	if (f==null || f=="")
	{
		document.getElementById("message").innerHTML="enter account type";		
		return false;
	}
	if (g==null || g=="")
	{
		document.getElementById("message").innerHTML="enter citizenship";		
		return false;
	}
	if (h==null || h=="")
	{
		document.getElementById("message").innerHTML="enter citizen status";		
		return false;
	}
	if(!document.getElementById("fath").checked &&!document.getElementById("husb").checked){
		document.getElementById("guarderror").innerHTML="select a guardian";
		return false;		
	}
}