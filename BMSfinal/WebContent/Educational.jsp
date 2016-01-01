<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Educatonal loan</title>
</head>
<% String message="";
if(request.getAttribute("message")!=null)
{
	message=request.getAttribute("message").toString();
}

%>
<body background="bg11.bmp">
<a href="bankHomePage.jsp"><span style="float:left">HOME</span></a>
<a href="logout.jsp"> <span style="float:right">LOGOUT</span></a>
<h1><font color='green'>APPLY LOAN</font></h1>
<h2 style="text-align:center"><font >Educational Loan</font></h2>
<center><h4><b><font face="arial"><span style="color: red"><%= message %></span></font></b></h4></center>
<form style="text-align:center" method="post" action="./EduacationController">
<table border=2>
<tr><td style="text-align:left"> Course Fee   </td>
<td><input type="text" name="course_fee"></td></tr>
<tr><td style="text-align:left"> Course       </td>
<td><input type="text" name="course"></td></tr>
<tr><td style="text-align:left"> Father's Name  </td>
<td><input type="text" name="father_name"></td></tr>
<tr><td style="text-align:left"> Father's Occupation </td>
<td><input type="text" name="father_occupation"></td></tr>
<tr><td style="text-align:left"> Father's Total Experience </td>
<td><input type="text" name="father_totalexp"></td>
<tr><td style="text-align:left"> Father's Experience with Current company </td>
<td><input type="text" name="father_currentexp"></td></tr>
<tr><td style="text-align:left"> Ration Card Number </td>
<td><input type="text" name="rationcard_number"></td>
<tr><td style="text-align:left"> Annual Income  </td>
<td><input type="text" name="annual_income"></td>
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