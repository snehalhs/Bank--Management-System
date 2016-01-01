package com.bankrupt.bo;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.bankrupt.dao.UpdateSearchDAO;
import com.bankrupt.exception.SearchBusinessException;
import com.bankrupt.exception.SearchException;
import com.bankrupt.vo.UpdateVo;


public class UpdateSearchBO {
	private static final Logger LOG = Logger.getLogger("UpdateSearchBO");
	UpdateSearchDAO dao=new UpdateSearchDAO();
	public boolean searchDetails(String CUSTOMER_ID1)throws SearchBusinessException, SearchException
	{
		//cuLogger.info("Method searchDetails Invoked in CustomerUpdatebo" + cid1);
		boolean flag=false;	
		String CUSTOMER_ID=CUSTOMER_ID1;		
		try {
			flag=dao.searchDetailsdao(CUSTOMER_ID);					
			if(flag==false){
				throw new SearchBusinessException("Please enter the correct Phone Number");
			}
		} catch (SearchBusinessException e) {				
			throw new SearchBusinessException("Please enter a valid Customer Id");
		} 	
		//cuLogger.info("Returned Value in searchDetails BO:"+flag);		
		return flag;
	}  
	
	public UpdateVo displayDetails(String CUSTOMER_ID)throws SearchBusinessException,SearchException
	{
		//cuLogger.info("Method displayDetails Invoked in CustomerUpdatebo");		
		UpdateVo to=dao.displayDetails(CUSTOMER_ID);
		//cuLogger.info("Return Value in BO:"+to);				
		return to;
}
	public boolean updateCustomer(UpdateVo to) throws SearchBusinessException,SearchException{
		//cuLogger.info("Method Updatecustomer Invoked in CustomerUpdatebo");	
		boolean successflag=true;	
		successflag=dao.updateCustomer(to);		
		//cuLogger.info("Returned Value in Updatecustomer BO:"+successflag);	
		return successflag;		
	}
	
	
	
	
}
