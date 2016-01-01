<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   import="java.util.*,com.bankrupt.vo.ViewTO" pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
 <%@page isELIgnored="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="bg11.bmp">

<h1><b>BANK STATEMENT</b></h1>
<a href="bankHomePage.jsp"><span style="float:left">	HOME</span></a>
<a href="logout.jsp"> <span style="float:right">LOGOUT</span></a><br>

<center>
<%! Object obj=null; 

%>
<% 	
	obj=request.getAttribute("result");
 	application.setAttribute("list",obj);
 	String str=(String)request.getAttribute("accNumber");
 	
%>
A/C No. : <%=str %>


<form method="post" action="./DownloadController">

 <table border=1>
<tr><th>Transaction Date</th><th>Transaction Description</th><th>Debit</th><th>Credit</th>
	<th>Balance</th></tr>
	
<c:forEach items="${requestScope.result}" var="result">


   <tr> <td><c:out value="${result.transactionDate} "/></td>
    <td>Transaction Id:    <c:out value="${result.transactionId} "/></td>
    <c:if test="${result.transactionType=='credit'}">
    <td></td>
    <td><c:out value="${result.transactionAmount} "/></td>
    </c:if>
    <c:if test="${result.transactionType=='debit'}">
    <td><c:out value="${result.transactionAmount} "/></td>
    <td></td>
    </c:if>
    <c:if test="${result.transactionType=='Loan EMI'}">
    <td><c:out value="${result.transactionAmount} "/></td>
    <td></td>
    </c:if>
    
   
	
	<td><c:out value="${result.balance} "/></td></tr>
	
</c:forEach>

 </table> 
	 
<input type="hidden" name="result2" value="<%=obj%>"/> 

<input type="submit" name="download" value="Download"></td></tr>

</form>
</center>
</body>
<br><br><br><br>
<div
      style="height:10%;bottom:0%;position:relative;"><%@include file="Bfooter.html" %>
</div>
</html>