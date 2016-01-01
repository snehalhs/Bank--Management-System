package com.bankrupt.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.bankrupt.exception.ApplyLoanBusinessException;
import com.bankrupt.exception.ApplyLoanException;
import com.bankrupt.log.LoggerInitializer;
import com.bankrupt.vo.UserTo;
import com.bankrupt.dao.UserDAO;


// TODO: Auto-generated Javadoc
/**
 * The Class ApplyLoanBO.
 */
public class ApplyLoanBO {
	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger("ApplyLoanBO");
	
	/**
	 * Register user method is used to check business rules
	 * It calculates the EMI amount
	 *
	 * @param user the user
	 * @return true, if successful
	 * @throws ApplyLoanException the apply loan exception
	 * @throws ApplyLoanBusinessException the apply loan business exception
	 */
	public boolean registerUser(UserTo user) throws ApplyLoanException,ApplyLoanBusinessException
	{
		  LOG.info("Entered into registerUser method of ApplyLoanBo class");
          	
          boolean flag=false;
        
          SimpleDateFormat newone=new SimpleDateFormat("dd-MMM-yyyy");
         
          Date ApplyDate=new Date();
          Date systemDate=new Date();
          Date IssueDate=new Date();
          Date check=new Date();
          int days,days2;
          
          String system=newone.format(systemDate);
          String AccNo=user.getAccount_number();
          
          
          int p=user.getLoan_amount();
         
          Double rate_of_int=user.getRate_of_interest();
          Double r=rate_of_int/1200;
        
          int nn=user.getDuration_of_loan();
          int durationLoan=user.getDuration_of_loan();
          int n=durationLoan*12;
          Double power=Math.pow(1+r, n);
          Double EMI=p*r*power/(power-1);
       
         
          user.setEMI(EMI);
          
          
          try
          {
        	  ApplyDate=newone.parse(user.getLoan_apply_date());
        	  check=newone.parse(user.getLoan_apply_date());
        	  systemDate=newone.parse(system);
        	  IssueDate=newone.parse(user.getLoan_issue_date());
        	  
        	  days=ApplyDate.getDay();
        	  days2=days+30;
        	  check.setDate(days2);
        	  
        	  
        	 
          }
          catch (ParseException e) 
          {
			throw new ApplyLoanBusinessException("date not in correct format");
		  }
          
          if(IssueDate.after(check))
          {
        	  throw new ApplyLoanBusinessException("Issue date must be within 30 days of apply date");
          }
          
          else if(ApplyDate.before(systemDate))
          {
        	  throw new ApplyLoanBusinessException("Apply Date should be after system Date");
          }
          else if(IssueDate.before(ApplyDate))
          {
        	  throw new ApplyLoanBusinessException("Issue Date should be after Apply Date");
          }
          
          
          else if(durationLoan!=5 && durationLoan!=10 && durationLoan!=15 && durationLoan!=20)
          {
        	  throw new ApplyLoanBusinessException("Duration of Loan should be 5 or 10 or 15 or 20 years only");
          }
          else if(AccNo.length()!=16)
          {
        	  throw new ApplyLoanBusinessException("Account number should be 16 digits only");
          }
          
        	  
          else
          {
        	  UserDAO dao=new UserDAO();
        	 
  			flag=dao.registerUser(user);
          }
          
          LOG.info("Return statement of registerUser method of ApplyLoanBo class"); 
		 return flag;
	}
}
