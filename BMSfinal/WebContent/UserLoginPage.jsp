<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>USER LOGIN</title>
<script src="UserLoginValidation.js"></script>
</head>
<% String message1="";
if(request.getAttribute("message1")!=null)
{
	message1=request.getAttribute("message1").toString();
}

%>
<body background="bg1.jpg" >
<center>
<br><br><br><br><br><br><br><br><br><br><br><br><br> <h2>Login here</h2>
<br>
<span id="message" style="color:red"></span>
<form name="userLogin" onsubmit="return validateUserLogin();"    action="./BankLoginController" method="post">

<%=message1 %>
<table>
<tr>
	<td style="color: maroon;"><b>
		CUSTOMER ID:</b>
	</td>
	<td>
		<input type="text" name="cusid">
	</td>
	</tr>
	<tr>
	<td style="color: maroon;">
	<b>
		PASSWORD:</b>
	</td>
	<td>
		<input type="password" name="pwd">
	</td>
</tr>
</table>
<input type="submit" name=submit" value="LOGIN"/>
</form>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="RegistrationPage1.jsp"><font style="color: blue"><b>new customer registration</b></font> </a>
<br><br><br><br><br><br> 
</center>
</body>
<div
      style="height:10%;bottom:0%;position:relative;"><%@include file="Bfooter.html" %>
</div>
</html>