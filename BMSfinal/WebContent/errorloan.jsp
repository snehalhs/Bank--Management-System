<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loan error</title>
</head>
<body background="bg11.bmp">

<a href="bankHomePage.jsp"><span style="float:left">	HOME</span></a>
<a href="logout.jsp"> <span style="float:right">LOGOUT</span></a>
<h1><font color='green'>APPLY LOAN</font></h1>
<center>
<%=request.getAttribute("errMessage") %>
<h5><font face="arial" color="red">Fatal Error occured. Please Try After Some Time</font></h5>
</center>
</body>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<div
      style="height:10%;bottom:0%;position:relative;"><%@include file="Bfooter.html" %>
</div>

</html>