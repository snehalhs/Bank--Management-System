
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update search</title>
</head>
<% String message="";
if(request.getAttribute("message")!=null)
{
	message=request.getAttribute("message").toString();
	
}%>
<body background="bg11.bmp">
<center>
<h1><font color='green'>Update Account Details</font></h1>
<a href="bankHomePage.jsp"><span style="float:left">	HOME</span></a>
<a href="logout.jsp"> <span style="float:right">LOGOUT</span></a>
<span style="color: red"><%=message %></span>
<form method="post" name="f1" action="./AccountUpdateController">
<table>
	<tr>
		<td> Customer ID</td><td><input type="text" name="CUSTOMER_ID"  /></td>
		
	</tr>
	<tr>
		
		<td><input type="submit" face="arial" value="Search" name="Search"/ onclick="return nyfunction()">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="reset" face="arial" value="Reset" name="Reset"/></td>
	<br>	
</table>
</form>
</center>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<div
      style="height:10%;bottom:0%;position:relative;"><%@include file="Bfooter.html" %>
</div>
</body>
</html>