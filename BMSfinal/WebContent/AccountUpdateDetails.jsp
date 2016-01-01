<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*" import="com.bankrupt.vo.UpdateVo"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display page</title>
<script src="Validation.js"></script>
</head>
<body background="bg11.bmp">
<a href="bankHomePage.jsp"><span style="float:left">	HOME</span></a>
<a href="logout.jsp"> <span style="float:right">LOGOUT</span></a>
 <center>
 <br><br><h1><font color='green'>Welcome To User </font><font color='blue'>${result.CUSTOMER_ID}</font></h1>
 <span id="message" style="color:red"></span>
<form name=check style="text-align: center" onsubmit="return validateForm1();" method="post" action="./UpdateController">
 

<table border="1" style="text-align: left;">
<tr><td>Customer id</td><td><input type="text" name="CUSTOMER_ID" value="${result.CUSTOMER_ID }" style="background-color:buttonshadow; " READONLY/></td></tr>
<tr><td>Name</td><td><input type="text" name="NAME" value="${result.NAME }" style="background-color:buttonshadow; " READONLY/></td></tr>
<tr><td>Account no</td><td><input type="text"  name="ACCOUNT_NUMBER" value="${result.ACCOUNT_NUMBER }" style="background-color:buttonshadow; " READONLY/></td></tr>
<tr><td>Country</td><td><input type="text" name="COUNTRY" value="${result.COUNTRY }" style="background-color:buttonshadow; " READONLY/></td></tr>
<tr><td>State</td><td><input type="text" name="STATE" value="${result.STATE }" style="background-color:buttonshadow; " READONLY/></td></tr>
<tr><td>Gender</td><td><input type="text" name="GENDER" value="${result.GENDER}" style="background-color:buttonshadow; " READONLY/></td></tr>
<tr><td>DOB</td><td><input type="text" name="DOB" value="${result.DOB }" style="background-color:buttonshadow; " READONLY/></td></tr>
<tr><td>Registration date</td><td><input type="text" name="REG_DATE" value="${result.REG_DATE}" style="background-color:buttonshadow; " READONLY/></td></tr>
<tr><td>Branch Name</td><td><input type="text" name="BRANCH_NAME" value="${result. BRANCH_NAME}" style="background-color:buttonshadow; " READONLY/></td></tr>
<tr><td>Identification proof type</td><td><input type="text" name="id_proof_type"  value="${result.ID_PROOF_TYPE }" style="background-color:buttonshadow; " READONLY/></td></tr>
<tr><td>Identification doc no</td><td><input type="text" name="id_doc_num"  value="${result.ID_DOC_NO}" style="background-color:buttonshadow; " READONLY/></td></tr>
<tr><td>Reference: account holder Name</td><td><input type="text" name="REF_HOLDER_NAME"  value="${result.REF_HOLDER_NAME}" style="background-color:buttonshadow; " READONLY/></td></tr>
<tr><td>Reference: account holder acc. No</td><td><input type="text" name=" REF_ACC_NO"  value="${result.REF_ACC_NO }" style="background-color:buttonshadow; " READONLY/></td></tr>
<tr><td>Reference: account holder address</td><td><input type="text" name=" REF_ADDRESS "  value="${result.REF_ADDRESS  }" style="background-color:buttonshadow; " READONLY/></td></tr>
<tr><td>Address</td><td><input type="text" name="ADDRESS" value="${result.ADDRESS }"/></td></tr>
<tr><td>Contact No</td><td><input type="text" name="CONTACT_NUMBER" value="${result.CONTACT_NUMBER }"/></td></tr>
<tr><td>Email id</td><td><input type="text" name="EMAIL" value="${result.EMAIL }"/></td></tr>
<tr><td>Marital Status</td><td><input type="text" name="MARITAL" value="${result.MARITAL_STATUS }"/></td></tr>
<td></td>
					<td><input type="radio" name="MARITAL_STATUS" value="Married" id="married"/>Married
						<input type="radio" name="MARITAL_STATUS" value="UnMarried" id="unmarried"/>UnMarried
					</td>
</tr>
<tr>
<td>AccountType</td>
					<td><select name="ACC_TYPE">
							<option value="${result.ACC_TYPE}">${result.ACC_TYPE}</option>
							<option value="savings">savings</option>
							<option value="salary">salary</option>
					</select>
					</td>
					</tr>
<tr><td>Citizenship</td><td><input type="text" name="CITIZENSHIP" value="${result.CITIZENSHIP }" /></td></tr>
<tr><td>Citizen Status</td><td><input type="text" name="CITIZEN_STATUS" value="${result.CITIZEN_STATUS}"/></td></tr>
<tr><td>Guardian type</td><td><input type="text" name="GUARDIAN" value="${result.GUARDIAN_TYPE }" /></td></tr>
<tr><td></td>
<td><input type="radio" name="GUARDIAN_TYPE" id="fath" value="Father" />Father
	<input type="radio" name="GUARDIAN_TYPE" id="husb" value="Husband" />Husband
					</td>
<tr><td>Guardian name</td><td><input type="text" name="GUARDIAN_NAME" value="${result.GUARDIAN_NAME}"/></td></tr>
<tr><td><input type="submit" id="submit" Value="Update"/></td><td><input type="reset" id="reset" value="Reset"/></td></tr>


</table>
</form>
</center>
</body>
<br><br>
<div
      style="height:10%;bottom:0%;position:relative;"><%@include file="Bfooter.html" %>
</div>
</html>