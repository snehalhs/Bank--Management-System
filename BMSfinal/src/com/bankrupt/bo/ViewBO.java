package com.bankrupt.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.log4j.Logger;

import com.bankrupt.dao.ViewDAO;
import com.bankrupt.exception.ViewException;
import com.bankrupt.exception.ViewStatementException;
import com.bankrupt.vo.*;







public class ViewBO {
	
	private static final Logger LOG = Logger.getLogger("ViewBO");
	/**
	 * This functions dateCheck checks whether the to Date for statement generation is before or equal Current date, 
	 *  if to date is after current date , it returns false
	 * @param ViewVO object
	 * @return boolean value
	 * @throws ViewStatementException
	 */
	private boolean dateCheck(ViewVO vo) throws ViewStatementException
	{ 
			LOG.info("Entered into dateCheck method of ViewBO class");
			
			boolean valid=true;
			
			 String tD=vo.getTdate();
			 SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
			
			 Date toDate=new Date();
			 try {
				
				toDate=sdf.parse(tD);
			 } catch (ParseException e) {
				throw new ViewStatementException("Date not in correct format");
				}
			 
			 Date currentDate=new Date();
			 if(currentDate.before(toDate))
				valid=false;
			
			 LOG.info("Return statement of dateCheck method of ViewBO class");
	
			 return valid;
	}
	/**
	 * This function dateCheck2 checks the difference between to and from date,
	 * if from date is after to date,it returns false
	 * @param ViewVo object
	 * @return boolean value
	 * @throws ViewStatementException
	 */
	private boolean datecheck2(ViewVO vo) throws ViewStatementException 
		{
			 LOG.info("Entered into datecheck2 method of ViewBO class");
		
			 boolean valid=true;
			 String fD=vo.getFdate();
			 String tD=vo.getTdate();
			 SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
			 Date fromDate=new Date();
			 Date toDate=new Date();
			 try {
				fromDate = sdf.parse(fD);
				toDate=sdf.parse(tD);
			 } catch (ParseException e) {
				
				throw new ViewStatementException("Date not in correct format");
			 }	
				if(fromDate.after(toDate))
				{
					valid=false;
				}
			 LOG.info("Return statement of dateCheck2 method of ViewBO class");

			 return valid;
		}

	
	/**
	 * This function dateGap checks the difference between from and to date for statement generation,
	 * If the gap is more than 12 months,it returns false
	 * @param ViewVO object
	 * @return boolean value
	 * @throws ViewStatementException
	 */
	private boolean dateGap(ViewVO vo) throws ViewStatementException
		{
			 LOG.info("Entered into dateGap method of ViewBO class");
				
			 boolean valid=true;
			 String fD=vo.getFdate();
			 String tD=vo.getTdate();
			 SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
			 Date fromDate=new Date();
			 Date toDate=new Date();
			 try {
				fromDate = sdf.parse(fD);
				toDate=sdf.parse(tD);
			 } catch (ParseException e) {
				throw new ViewStatementException("Date not in correct format");
				}
			 Calendar c1=Calendar.getInstance();
			 Calendar c2=Calendar.getInstance();
			 c1.setTime(toDate);
			 c2.setTime(fromDate);
			 long diff=c1.getTimeInMillis()-c2.getTimeInMillis();
			 int diffDay=(int) (diff/(24*60*60*1000));
			 if(diffDay>365)
				 {
				 valid=false;
				 }
			
			 LOG.info("Return statement of dateGap method of ViewBO class");

			 return valid;
		}

	
	/**
	 * This function fetchTotalData retrieves the transactions done by the current user from ViewDAO class 
	 * @param ViewVO object
	 * @return List of ViewTO type object
	 * @throws ViewException
	 * @throws ViewStatementException
	 */
	public List<ViewTO> fetchTotalData(ViewVO vo)throws ViewException,ViewStatementException
		 {
			LOG.info("Entered into fetchTotalData method of ViewBO class");
		
			  if(dateCheck(vo)==false)
				 throw new ViewStatementException("Date after current date is entered");
			 
			  if(datecheck2(vo)==false)
				  throw new ViewStatementException("from  date is after To date");
				  
			  if(dateGap(vo)==false)
					 throw new ViewStatementException("Difference between from and To date is more than 12 months");
				  
		
			  List<ViewTO> list=new ArrayList<ViewTO>();
			  ViewDAO dao=new ViewDAO();
			  list=dao.displayDetails(vo);
				
				
			  LOG.info("Return statement of fetchTotalData method of ViewBO class");

			  return list;
				  
		 }
	
 
}
