package com.bankrupt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bankrupt.bo.UpdateSearchBO;
import com.bankrupt.exception.SearchBusinessException;
import com.bankrupt.exception.SearchException;
import com.bankrupt.vo.UpdateVo;

/**
 * Servlet implementation class UpdateController
 */
public class UpdateController extends HttpServlet {
	private static final Logger LOG = Logger.getLogger("UpdateController");
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try
		{						
			//String [] typeofvendor= request.getParameterValues("typeofvendor");			
			UpdateVo to=new UpdateVo();		
			
			to.setCONTACT_NUMBER(request.getParameter("CONTACT_NUMBER"));
			to.setADDRESS(request.getParameter("ADDRESS"));
			to.setACCOUNT_NUMBER(request.getParameter("ACCOUNT_NUMBER"));
			to.setEMAIL(request.getParameter("EMAIL"));
			to.setMARITAL_STATUS(request.getParameter("MARITAL_STATUS"));
			to.setACC_TYPE(request.getParameter("ACC_TYPE"));
			to.setCITIZENSHIP(request.getParameter("CITIZENSHIP"));
			to.setCITIZEN_STATUS(request.getParameter("CITIZEN_STATUS"));
			to.setGUARDIAN_TYPE(request.getParameter("GUARDIAN_TYPE"));
			to.setGUARDIAN_NAME(request.getParameter("GUARDIAN_NAME"));
			to.setCUSTOMER_ID(request.getParameter("CUSTOMER_ID"));
			/*
			
			
			catch(NullPointerException e){
				throw new NullPointerException("Please select atleast one vendor type");
			}*/
			//cuLogger.info("CustomerUpdate invoked Customer_name:" + to.getCustomer_name());			
			
			//cuLogger.info("CustomerUpdate Before Sending data to RegistrationBO:" + to);
			UpdateSearchBO bo=new UpdateSearchBO();
			if(bo.updateCustomer(to))
			{				
				//cuLogger.info("CustomerUpdate Control Transffered to CustomerUpdateSuccess.jsp:" );
				RequestDispatcher rd=request.getRequestDispatcher("CustomerUpdateSuccess.jsp");
				rd.forward(request, response);	
			}
		}
		catch (SearchBusinessException e)
		{
				request.setAttribute("message", e.getMessage());
				//cuLogger.error("Exception occured when processing updateCustomer: "+ e.getCause());
				
				RequestDispatcher rd=request.getRequestDispatcher("CustomerUpdateDetails.jsp");
				rd.include(request, response);
		} 
		catch (SearchException e)
		{
				request.setAttribute("errMessage", e.getMessage());
				//cuLogger.error("Exception occured when processing updateCustomer: "+ e.getCause());
				RequestDispatcher rd=request.getRequestDispatcher("CustomerUpdateError.jsp");
				rd.forward(request, response);
		} 	
	}

}
