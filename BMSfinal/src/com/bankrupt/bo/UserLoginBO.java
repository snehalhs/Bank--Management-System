package com.bankrupt.bo;

import org.apache.log4j.Logger;

import com.bankrupt.dao.UserLoginDAO;
import com.bankrupt.exception.EntryException;

public class UserLoginBO {
	
	private static final Logger LOG = Logger.getLogger("UserLoginBO");
public String checkUser(String customerId, String pwd) throws EntryException
{
	LOG.info("Entered into checkUser method of UserLoginBO class");
	
String back;
UserLoginDAO dao=new UserLoginDAO();
back=dao.checkUser(customerId, pwd);

LOG.info("Return statement of checkUser method of UserLoginBO class");
return back;
}
}
