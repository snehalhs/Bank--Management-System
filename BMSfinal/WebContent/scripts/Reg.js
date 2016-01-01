function myfunction(){

	

	var name=f1.name.value;
	var uname=f1.username.value;
	var pwd=f1.pwd.value;
	var rpwd=f1.rpwd.value;
	var guard=f1.gnname.value;
	var address=f1.add.value;
	var mail=f1.email.value;
	var citizen=f1.ship.value;
	var contact=f1.contactno.value;
	var dob1=f1.dob.value;
	var initial=f1.amnt.value;
	var acct=f1.acctype.value;
	var refad=f1.refaddrs.value;
    var refn=f1.refname.value;
	var doc=f1.idno.value;
	
	var refacc=f1.refaccno.value;

	
	var h=f1.dob.value;
	var f=document.getElementById("cs");
	var d=new Date();
	var p=new Date(h);
	var refa=/^[0-9]{16}$/;
	var con=/^[0-9]{10}$/;
	var digit=/^[0-9]*$/;
	var diff=Math.floor((d-p)/(31557600000));
	var namepatt=/^[a-zA-Z ]+$/;
	var numb = /^[0-9]{10}$/;
	var cemail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})$/;

	var flag=true;

	
	if(!namepatt.test(name) || name==""){
		document.getElementById("nameerror").innerHTML="Invalid name";
	
	 flag=false;		
	}else{
		document.getElementById("nameerror").innerHTML="";
	}
	if(!namepatt.test(uname)){
		document.getElementById("usernameerror").innerHTML="Invalid user name";

		flag=false;		
	}else{
		document.getElementById("usernameerror").innerHTML="";
	}
	if(pwd.length<8){
		document.getElementById("pswderror").innerHTML="password length should be min 8 character";

		flag=false;		
	}else{
		document.getElementById("pswderror").innerHTML="";
	}
	/*if(pwd==rpwd){
		document.getElementById("repswderror").innerHTML="passwords do not match";
		flag=false;		
	}else{
		document.getElementById("repswderror").innerHTML="";
	}*/
	if(!document.getElementById("fath").checked &&!document.getElementById("husb").checked){
		document.getElementById("guarderror").innerHTML="select a guardian";
		flag=false;		
	}else{
		document.getElementById("guarderror").innerHTML="";
	}
	if(!namepatt.test(guard)|| guard==""){
		document.getElementById("guardnameerror").innerHTML="Invalid guardname";
		flag=false;		
	}else{
		document.getElementById("guardnameerror").innerHTML="";
	}
	if(address==""){
		document.getElementById("addresserror").innerHTML="Invalid address";
		flag=false;
	}
	else{
		document.getElementById("guardnameerror").innerHTML="";
	}
	
	if(!cemail.test(mail)||mail==""){
		document.getElementById("emailerror").innerHTML="Invalid email address";
	
		flag=false;
		}
	else{
		document.getElementById("emailerror").innerHTML="";
	}
	if(!document.getElementById("Male").checked && !document.getElementById("Female").checked){
		document.getElementById("gendererror").innerHTML="select gender";
		flag=false;		
	}else{
		document.getElementById("gendererror").innerHTML="";
	}
	if(!document.getElementById("married").checked && !document.getElementById("unmarried").checked){
		
		document.getElementById("maritalerror").innerHTML="select marital status";
		flag=false;		
	}else{
		document.getElementById("maritalerror").innerHTML="";
	}
	if(!con.test(contact)|| contact==""){
		document.getElementById("contacterror").innerHTML="contact number should be 10 digits";
		flag=false;		
	}else{
		document.getElementById("contacterror").innerHTML="";
	}
	if(dob1==""){
		document.getElementById("doberror").innerHTML="enter DateOfBirth";
		flag=false;
	}
	else{
		document.getElementById("doberror").innerHTML="";
	}
	if(acct=="select"){
		document.getElementById("accerror").innerHTML="select account type";
		flag=false;
	}
	else{
		document.getElementById("accerror").innerHTML="";
	}
	if(!digit.test(initial)|| initial==""){
		document.getElementById("amnterror").innerHTML="Invalid Amount";
		flag=false;		
	}else{
		document.getElementById("amnterror").innerHTML="";
	}
	if(refad==""){
		document.getElementById("refadderror").innerHTML="enter reference account holder address";
		flag=false;
	}
	else{
		document.getElementById("refadderror").innerHTML="";
	}
	if(!namepatt.test(refn)|| refn==""){
		document.getElementById("refnerror").innerHTML="Invalid ReferenceName";
		flag=false;		
	}else{
		document.getElementById("refnerror").innerHTML="";
	}
	if(!refa.test(refacc)|| refacc==""){
		document.getElementById("refaerror").innerHTML="Invalid Account Number";
		flag=false;		
	}else{
		document.getElementById("refaerror").innerHTML="";
	}
if(doc==""){
		document.getElementById("iderror").innerHTML="enter document number";
		flag=false;
	}
	else{
		document.getElementById("iderror").innerHTML="";
	}

return flag;
		
}
	
	


function cityship(){
	var x=document.getElementById("country").value;
	var y=document.getElementById("ship");
	y.value=x;
	
}

				
function regdate(){
	var g=document.getElementById("reg");
	var d=new Date();
	var f=(d.getMonth()+1)+"/"+(d.getDate())+"/"+(d.getFullYear());
	g.value=f;
	
	
}

function jyothi(){

	var h=f1.dob.value;
	var f=document.getElementById("cs");
	var d=new Date();
	var p=new Date(h);
	
	var diff=Math.floor((d-p)/(31557600000));
	if(diff<18)
		f.value="Minor";
	 if(diff>=18&&diff<=60)
		f.value="Normal";
	if(diff>60&&diff<=96)
		f.value="Senior";

}


