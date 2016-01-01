package com.bankrupt.bo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.bankrupt.dao.UserDAO;
import com.bankrupt.exception.ApplyLoanBusinessException;
import com.bankrupt.exception.ApplyLoanException;
import com.bankrupt.vo.EducationalTo;
import com.bankrupt.vo.UserTo;

// TODO: Auto-generated Javadoc
/**
 * The Class EducationalBO.
 */
public class EducationalBO {
	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger("EducationalBO");
	
	
	
	/**
	 * Register user method is used to check business rules required for educational loan
	 *
	 * @param user1 the user1
	 * @return true, if successful
	 * @throws ApplyLoanException the apply loan exception
	 * @throws ApplyLoanBusinessException the apply loan business exception
	 */
	public boolean registerUser(EducationalTo user1) throws ApplyLoanException,ApplyLoanBusinessException
	{
		LOG.info("Entered into registerUser method of EducationalBO class");
		boolean flag1=false;
		
		
		Long fee=user1.getCourse_fee();
		String course=user1.getCourse();
		String FatherName=user1.getFather_name();
		String FatherOccupation=user1.getFather_occupation();
		Double TotalExpr=user1.getFather_totalexp();
		Double CurrentExp=user1.getFather_currentexp();
	    Long RationCard=user1.getRationcard_number();
	    Long AnnualIncome=user1.getAnnual_income();
	    
	    
		
		if(fee==null)
		{
			throw new ApplyLoanBusinessException("Enter course fee");
		}
		else if(course.equals(null))
		{
			throw new ApplyLoanBusinessException("Enter course");
		}
		else if((FatherName.equals(null)))
		{
			throw new ApplyLoanBusinessException("Enter Father's Name");
		}
		else if(FatherOccupation.equals(null))
		{
			throw new ApplyLoanBusinessException("Enter Father's Occupation");
		}
		else if(TotalExpr==null)
		{
			throw new ApplyLoanBusinessException("Enter Total Experience");
		}
		else if(CurrentExp==null)
		{
			throw new ApplyLoanBusinessException("Enter Experience with Current Company");
		}
		else if(RationCard==null)
		{
			throw new ApplyLoanBusinessException("Enter Ration Card Number");
		}
		else if(AnnualIncome==null)
		{
			throw new ApplyLoanBusinessException("Enter Annual Income");
		}
		else
		{
		UserDAO dao1=new UserDAO();
  	   
		flag1=dao1.educationregister(user1);
		}
		LOG.info("Return statement of registerUser method of EducationalBO class");
		return flag1;
	}
}
