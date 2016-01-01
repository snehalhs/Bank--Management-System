<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%! Object obj=null; 
    Double val=null;
    double bal=0;
%>
<%  obj=request.getAttribute("balance");
	if(obj instanceof Double) 
	{
		val=(Double)obj;
		bal=val.doubleValue();
		bal=Math.round(bal*100)/100.00;
	}
%>

<body background="bg11.bmp">
<h1><b>TRANSACTION PAGE</b></h1>

<a href="bankHomePage.jsp"><span style="float:left">	HOME</span></a>
<a href="logout.jsp"> <span style="float:right">LOGOUT</span></a><br>
<center>
<h4><b><font face="arial" color="green">Transaction Successful</h4></font></b>
<h3><b><font face="arial" color="green">Balance : <%=bal%></h3></font></b>
</center>
</body>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<div
      style="height:10%;bottom:0%;position:relative;"><%@include file="Bfooter.html" %>
</div>

</html>