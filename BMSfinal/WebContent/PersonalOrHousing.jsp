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
<h1><font color='green'>APPLY LOAN</font></h1>

<a href="bankHomePage.jsp"><span style="float:left">	HOME</span></a>
<a href="logout.jsp"> <span style="float:right">LOGOUT</span></a>
<h2 style="text-align:center"><font >Housing or Personal Loan</font></h2>
<center><h4><span style="color: red"><%= message %></span></h4></center>
<form style="text-align:center" method="post" action="./PersonalController">
<table border=2>
<tr><td style="text-align:left">Annual Income</td>
<td><input type="text" name="annual_income"></td>
<tr><td style="text-align:left">Company Name</td>
<td><input type="text" name="company_name"></td>
<tr><td style="text-align:left">Designation</td>
<td><input type="text" name="designation"></td>
<tr><td style="text-align:left">Total Experience</td>
<td><input type="text" name="totalexp"></td>
<tr><td style="text-align:left">Experience with Current Company</td>
<td><input type="text" name="currentexp"></td>
<tr><td ><input type="submit" value="Apply for Loan"></td>
<td><input type="reset" value="Reset"></td></tr>
</table>
</form>

</body>
<br><br><br><br><br>
<div
      style="height:10%;bottom:0%;position:relative;"><%@include file="Bfooter.html" %>
</div>

</html>