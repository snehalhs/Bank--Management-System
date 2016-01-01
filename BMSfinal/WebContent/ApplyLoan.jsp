<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-1"> 
 
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css"> 
<script src="http://code.jquery.com/jquery-1.9.1.js"></script> 
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script> 
<link rel="stylesheet" href="/resources/demos/style.css"> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" >

<title>Apply loan</title>
</head>
<% String message="";
if(request.getAttribute("message")!=null)
{
	message=request.getAttribute("message").toString();
}

%>
<body background="bg11.bmp">
<h1><font color='green'>APPLY LOAN</font></h1>
<a href="bankHomePage.jsp"><span style="float:left">	HOME</span></a>
<a href="logout.jsp"> <span style="float:right">LOGOUT</span></a>
<h3 style="text-align:center"><font >Loan Application</font></h3>

<center><h4><b><font face="arial"><span style="color: red"><%= message %></span></font></b></h4></center>
<form name="check" style="text-align:center" onsubmit="return validateForm();" method="post"  action="./ApplyLoanController">
<table border=2>
<tr><td style="text-align:left">Loan Type :</td>
<td><select name="loan_type" id="loan_id">
<option value="select">----select----</option>
<option value="Educational">Educational</option>
<option value="Personal_Housing">Personal or Housing</option>
</select></td></tr>
<tr><td style="text-align:left">Loan Amount      </td><td><input type="text" name="loan_amount" id="laon_amount"></td></tr>
<tr><td style="text-align:left">Loan Apply Date  </td><td><input type="text" name="loan_apply_date" id="datepicker2"></td>
<script> $(function() { $( "#datepicker2" ).datepicker(); });
 </script></tr>
<tr><td style="text-align:left">Loan Issue Date  </td><td><input type="text" name="loan_issue_date" id="datepicker"></td>
<script> $(function() { $( "#datepicker" ).datepicker(); });
 </script>
</tr>
<tr><td style="text-align:left">Rate of Interest </td><td><input type="text" name="rate_of_interest"></td></tr>
<tr><td style="text-align:left">Duration of Loan </td><td><input type="text" name="duration_of_loan"></td></tr>

<tr><td><input type="submit" value="Continue"></td>
<td><input type="reset" value="Reset"></td></tr>
</table>
</form>

</body>
<br><br><br><br><br><br><br><br><br><br>
<div
      style="height:10%;bottom:0%;position:relative;"><%@include file="Bfooter.html" %>
</div>
</html>