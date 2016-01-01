<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%HttpSession hs=request.getSession();
String cusId=(String)hs.getAttribute("cusid");
 %>
<body background="bg11.bmp">
<h1>APPLY LOAN</h1>
<a href="bankHomePage.jsp"><span style="float:left">	HOME</span></a>
<a href="logout.jsp"> <span style="float:right">LOGOUT</span></a>
<center>
<h5><b><font face="arial" color="green"> Loan Applied Successfully for personal Type for customer:<%=cusId %></font></b></h5>
</center>
</body>
<br><br><br><br><br><br><br><br><br>
<div
      style="height:10%;bottom:0%;position:relative;"><%@include file="Bfooter.html" %>
</div>
</html>