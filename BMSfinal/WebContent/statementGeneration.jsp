<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en"><head> <meta charset="utf-1"> 
 
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css"> 
<script src="http://code.jquery.com/jquery-1.9.1.js"></script> 
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script> 
<link rel="stylesheet" href="/resources/demos/style.css"> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="statementValidation.js"></script>

<title>Bank Statement Generation</title>


</head>
<% String message="";
if(request.getAttribute("message")!=null)
{
	message=request.getAttribute("message").toString();
}

%>
<body background="bg11.bmp">

<h1><font color='green'>BANK STATEMENT</font></h1>

<a href="bankHomePage.jsp"><span style="float:left">	HOME</span></a>
<a href="logout.jsp"> <span style="float:right">LOGOUT</span></a><h2 style="text-align: center;"><font color='green'>Statement Generation Form</font></h2>
 <center> <h4><span id="message" style="color:red"></span>
 <br>
 <span style="color: red"><%=message %></span></h4>
<br><br><br>
<form name="BankStatement" onsubmit="return validate();" method="post" action="./ViewController">
<table border=1 style="text-align: left;" align="center">
<tr><td>From Date:</td><td><input type="text" name="fdate" id="datepicker2"></td></tr> 
<script> $(function() { $( "#datepicker2" ).datepicker(); });
 
</script>
<tr><td>To Date:</td><td><input type="text" name="tdate" id="datepicker"></td></tr> 
<script> $(function() { $( "#datepicker" ).datepicker(); });
 
</script>
<tr><td>Transaction type:</td><td><select name="Transaction_type"/>
<option selected="selected"  value="select">--Select--</option>
	<option value="All_transaction">ALL Transactions</option>
	<option value="Debit">Only Withdrawal</option>
	<option value="Credit">Only deposit</option>
	</td></tr>
<tr><td>Transaction per Page:</td><td><select name="Transaction_per_page"/>
<option selected="selected"  value="select">--Select--</option>
	<option value="20">20</option>
	<option value="10">10</option>
	<option value="5">5</option>
	</td></tr>

<tr><td><input type="submit" value="View"/></td>
<td><input type="reset" value="Reset"/></td></tr>

</table>
</form>
</center>
</body>
<br><br><br><br><br><br><br><br><br>
<div
      style="height:10%;bottom:0%;position:relative;"><%@include file="Bfooter.html" %>
</div>
</html>