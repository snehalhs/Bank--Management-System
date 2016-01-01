<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transactions</title>

</head>



<% String message="";
if(request.getAttribute("message")!=null)
{
	message=request.getAttribute("message").toString();
	
}%>
<body background="bg11.bmp">



<h1><b>TRANSACTION PAGE</b></h1>
<a href="bankHomePage.jsp"><span style="float:left">	HOME</span></a>
<a href="logout.jsp"> <span style="float:right">LOGOUT</span></a>
<center>
<span style="color: red"><%=message %></span>
<form  name=f method="post" action="./AccountExistanceController">

Account Number : <input type="text" name="accountnumber"/>
<br><br>
<input type="submit" value="submit" onclick="return f1()" >


	
</form>
<div id="i1">
</div>
</center>
</body>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<div
      style="height:10%;bottom:0%;position:relative;"><%@include file="Bfooter.html" %>
</div>
</html>
            