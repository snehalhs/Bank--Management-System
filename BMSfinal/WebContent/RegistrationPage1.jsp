<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.bankrupt.dao.Countries,com.bankrupt.dao.City,com.bankrupt.dao.BranchName,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"  src="scripts/Reg.js">
$(function() { $( "#datepicker" ).datepicker(); });
</script>

<title>RegistrationForm</title>
</head>
<% String message="";
if(request.getAttribute("message")!=null)
{
	message=request.getAttribute("message").toString();
}

%>

<body background="bg11.bmp">
	<center>
		<h1 style="text-align: center;">
			<font color='green'>Registration Form</font>
		</h1>
		<span style="color: red"><%=message %></span>
	</center>
	<form style="text-align: center" name="f1" method="post" action="./RegistrationController">
		<center>
			<table style="text-align: left;" border=1>
			<tr>
					<td>Country</td>
					<td><select name="country" id="country"
						onChange="location.href='RegistrationPage1.jsp?option='+this.value">
							<%
Countries countryBean1 = new Countries(); 
for (String s: countryBean1.getCountries()) 
{ 
if(request.getParameter("option") != null && request.getParameter("option").equals(s)) 
out.println("<option value="+s+" selected=\"selected\">"+s+"</option>"); 
else
out.println("<option value="+s+">"+s+"</option>"); 
} 
%>

					</select>
				<tr>
					<td>State</td>
					<td><select name="state">
							<%

City cityBean = new City(request.getParameter("option")); 
for(String s : cityBean.getCities()) {
out.println("<option value="+s+">"+s+"</option>"); 
}
%>
					</select>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" />
					</td>
					<td><div style="color:red" id="nameerror"></div></td>
				</tr>

				<tr>
					<td>User Name</td>
					<td><input type="text" name="username" />
					</td>
					<td><div style="color:red"  id="usernameerror"></div></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="pwd" />
					</td>
					<td><div style="color:red" id="pswderror"></div></td>
				</tr>

				<tr>
					<td>Retype Password</td>
					<td><input type="password" name="rpwd" />
					</td>
					<td><div style="color:red" id="repswderror"></div></td>
				</tr>


				<tr>
					<td>GuardianType</td>
					<td><input type="radio" name="gtype" id="fath" value="Father" />Father
						<input type="radio" name="gtype" id="husb" value="Husband" />Husband
					</td>
					<td><div style="color:red" id="guarderror"></div></td>
				</tr>
				<tr>
					<td>GuardianName</td>
					<td><input type="text" name="gnname" />
					</td>
					<td><div style="color:red" id="guardnameerror"></div></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><textarea rows="3" cols="15" name="add"></textarea>
					</td>
					<td><div style="color:red" id="addresserror"></div></td>
				</tr>


				
				<tr>
					<td>Citizenship</td>
					<td><input type="text" name="ship"
						onmouseover="return cityship()" />
					</td>
					<td><div style="color:red" id="citizenerror"></div></td>
				</tr>


				<tr>
					<td>Email</td>
					<td><input type="text" name="email" />
					</td>
					<td><div style="color:red" id="emailerror"></div></td>
				</tr>

				<tr>
					<td>Gender</td>
					<td><input type="radio" name="gender" value="Male" id="Male" />Male <input
						type="radio" name="gender" value="Female" id="Female"/>Female</td>
					<td><div style="color:red" id="gendererror"></div></td>
				</tr>
				<tr>
					<td>MaritalStatus</td>
					<td><input type="radio" name="maritalstatus" value="Married" id="married"/>Married
						<input type="radio" name="maritalstatus" value="UnMarried" id="unmarried"/>UnMarried
					</td>
					<td><div style="color:red" id="maritalerror"></div></td>
				</tr>
				<tr>
					<td>Contact no</td>
					<td><input type="text" name="contactno" />
					</td>
					<td><div style="color:red" id="contacterror"></div></td>
				</tr>



				<tr>
					<td>Date of Birth</td>
					<td><input type="text" name="dob" id="datepicker">
					</td>
					<td><div style="color:red" id="doberror"></div></td>
				</tr>
<script type="text/javascript">
$(function() { $( "#datepicker" ).datepicker(); });</script>




				<tr>
					<td>Registration Date</td>
					<td><input type="text" name="reg" id="reg"
						onmouseover="return regdate()" />
					</td>
				</tr>



				<tr>
					<td>AccountType</td>
					<td><select name="acctype">
							<option value="select">select</option>
							<option value="savings">savings</option>
							<option value="salary">salary</option>
					</select>
					</td>
					<td><div style="color:red" id="accerror"></div></td>
					
				<tr>
					<td>BranchName</td>
					<td><select name="branchname">
							<%
   BranchName b = new BranchName(); 
for(String s : b.getBranchName()) {
out.println("<option value="+s+">"+s+"</option>"); 
}
%>
					</select>
				<tr>
					<td>CitizenStatus</td>
					<td><input type="text" name="citizenstatus" id="cs"
						onmouseover="return jyothi()" />
					</td>
				</tr>


				<tr>
					<td>InitialDepositAmount</td>
					<td><input type="text" name="InitialDepAmnt" id="amnt"/>
					</td>
					
					<td><div style="color:red" id="amnterror"></div></td>
				</tr>
				<tr>
					<td>Identification Proof Type</td>
					<td><select name="id type">
						
							<option value="PAN">PAN</option>
							<option value="AADAR">AADAR</option>
							<option value="voterid">voterid</option>
					</select>
				<tr>
					<td>Identification Document Number</td>
					<td><input type="text" name="idno" />
					</td>
				<td><div style="color:red" id="iderror"></div></td>
				</tr>
				<tr>
					<td>Reference Account Holder Name</td>
					<td><input type="text" name="refname" />
					</td>
					
					<td><div style="color:red" id="refnerror"></div></td>
				</tr>

				<tr>
					<td>Reference Account Holder account no</td>
					<td><input type="text" name="refaccno" id="refaccno" />
					</td>
					
					<td><div style="color:red" id="refaerror"></div></td>
				</tr>

				<tr>
					<td>Reference Account Holder address</td>
					<td><input type="text" name="refaddrs" />
					</td>
					
					<td><div style="color:red" id="refadderror"></div></td>
				</tr>
				<tr>
					<td><input type="submit" value="Register"
						onclick="return myfunction()"/>
					</td>
					<td><input type="reset" value="Reset" />
					</td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>