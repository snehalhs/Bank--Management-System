package com.bankrupt.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

import com.bankrupt.dao.RegistrationDAO;
import com.bankrupt.exception.RegistrationBusinessException;
import com.bankrupt.exception.RegistrationException;
import com.bankrupt.vo.RegistrationVO;

public class RegistrationBO {
	private static final Logger LOG = Logger.getLogger("RegistrationBO");
	
	 RegistrationDAO dao=new RegistrationDAO();
	boolean j=false;
	int initial=0;

		
	
	public String activationDate(){
		
		LOG.info("Entered into activationDate method of RegistrationBO class");
		
		Date g=new Date();
		GregorianCalendar gre=new GregorianCalendar();
		SimpleDateFormat st=new SimpleDateFormat("MM/dd/yyyy");
		gre.setTime(g);
	    gre.add(Calendar.DAY_OF_MONTH, 5);
	    Date f=gre.getTime();
	   String d= st.format(f);
	  
		LOG.info("Return Statement of activationDate method of RegistrationBO class");
		return d;
		
		
	}
	
	
 public boolean registerDetails(RegistrationVO vo)throws RegistrationException,RegistrationBusinessException
{
	 
	 LOG.info("Entered into registerDetails method of RegistrationBO class");
	 RegistrationDAO dao=new RegistrationDAO();
	 boolean r = false;
	 
	 if(vo.getID_PROOF_TYPE().equals("PAN")){
		
	 r=dao.panVerification(vo.getID_PROOF_TYPE(), vo.getID_DOC_NO());
	 if(r==false)
			throw new RegistrationBusinessException("pan number already exist");
	 }
	 else{
		
		 r=true;
	 }
 if(r){
		int i=(int) vo.getINITIAL_DEPOSIT_AMOUNT();
		
		String s=vo.getACC_TYPE();
		String b=vo.getCOUNTRY();
		if(s.equals("salary")&&i==0){
			
			initial=0;
		}
		else{	
			
			initial=dao.initialAmount(i,b);
			
			}
		if(initial>0)
		{
			r=false;
			String mes="initialdeposit should be greater than"+initial;
			
			throw new RegistrationBusinessException(mes);
			
		}
		else
		{
			
			r=true;
		}
	 }
		 if(r)
		 {
			 
			 r=dao.accountnoGen();
			
		 }
		if(r)
		{
		 r=dao.insertDetails(vo);
		
		 }
		LOG.info("Return Statement of registerDetails method of RegistrationBO class");
		 
		return r;
	 
}
}
