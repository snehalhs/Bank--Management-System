<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<% String message="";
if(request.getAttribute("message")!=null)
{
	message=request.getAttribute("message").toString();
}
%>
<body background="bg11.bmp">
<h1><b>TRANSACTION PAGE</b></h1>

<a href="bankHomePage.jsp"><span style="float:left">	HOME</span></a>
<a href="logout.jsp"> <span style="float:right">LOGOUT</span></a>
<center>
<form style="text-align: center;" method="post" action="./TransactionController">
<h2>Transaction Details</h2>
<table border=1 style="text-align: left;" align="center">
	
	<tr >
		<td>Account Number</td><td>:</td>
		<td><input type="text" name="accountnumber" id="accn"  value="${result.accNumber}" style="background-color:lightgrey" readonly /></td>
		
	</tr>
	<tr >
		<td>Account Name</td><td>:</td>
		<td><input type="text" name="accountname" value="${result.accName}" style="background-color:lightgrey" readonly/></td>     
	</tr>
	<tr >
		<td>Account Type</td><td>:</td>
		<td><input type="text" name="accounttype" value="${result.accType}" style="background-color:lightgrey" readonly/></td>	 
	</tr>
	<tr>
		<td>Transaction Id</td><td>:</td>
		<td><input type="text" name="transactionid" value="${result.transactionID}" style="background-color:lightgrey" readonly/></td>	 
	</tr>
	<tr>
		<td>Transaction Type</td><td>:</td>
		<td><select name="transactiontype" >
		<option value="select">--Select--</option>
		<option value="credit">Deposit</option>
		<option value="debit">Withdrawal</option>
		<option value="Loan EMI">Loan EMI Debit</option>
		</select></td>
	</tr>
	
	<tr>
		<td>Transaction Date</td><td>:</td>
		<td><input type="text" name="transactiondate" value="${result.txnDate}" style="background-color:lightgrey" readonly /></td>
	</tr>
	<tr>
		<td>Amount</td><td>:</td>
		<td><input type="text" name="amount"  /></td>   
	</tr>
	<tr>
		<td></td><td></td><td>Enter deposit/withdrawal amount</td>
	</tr>
	
	<tr>
	    <td><input type="submit" value="Submit"/></td>
	    <td></td>
        <td><input type="reset" value="Reset"/></td>
    </tr><span style="color:red"><%=message %>
</table>
</form> 
</center> 
</body>
<br><br><br><br>
<div
      style="height:10%;bottom:0%;position:relative;"><%@include file="Bfooter.html" %>
</div>
</html>