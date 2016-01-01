package com.bankrupt.bo;

import org.apache.log4j.Logger;

import com.bankrupt.dao.UserDAO;
import com.bankrupt.exception.ApplyLoanBusinessException;
import com.bankrupt.exception.ApplyLoanException;
import com.bankrupt.vo.EducationalTo;
import com.bankrupt.vo.PersonalTo;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonalBO.
 */
public class PersonalBO {
	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger("PersonalBO");
	
	/**
	 * Register user method pass the control to UserDAO class
	 *
	 * @param user2 the user2
	 * @return true, if successful
	 * @throws ApplyLoanException the apply loan exception
	 * @throws ApplyLoanBusinessException the apply loan business exception
	 */
	public boolean registerUser(PersonalTo user2) throws ApplyLoanException,ApplyLoanBusinessException
	{
		LOG.info("Entered into registerUser method of PersonalBO class");
		
		boolean flags=false;
		
		
		UserDAO dao2=new UserDAO();
  	   
		flags=dao2.personalRegisterUser(user2);
		
		LOG.info("Return statement of registerUser method of PersonalBO class");
		
		return flags;
	}

}
