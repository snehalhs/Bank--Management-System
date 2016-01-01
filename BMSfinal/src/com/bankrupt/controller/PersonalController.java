package com.bankrupt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bankrupt.bo.PersonalBO;
import com.bankrupt.exception.ApplyLoanBusinessException;
import com.bankrupt.exception.ApplyLoanException;
import com.bankrupt.vo.PersonalTo;


public class PersonalController extends HttpServlet {
	private static final Logger LOG = Logger.getLogger("PersonalController");
	private static final long serialVersionUID = 1L;
       
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	LOG.info("Entered into doPost method of PersonalController ");
		
    	ServletConfig te=getServletConfig();
	    ServletContext wr=te.getServletContext();
	    String accno=(String) wr.getAttribute("acno");
	    
	    
	    ServletConfig forLoan=getServletConfig();
	    ServletContext wr1=forLoan.getServletContext();
	    String loan_id=(String) wr1.getAttribute("loanid");
	    
	    
	    
		
    	try
    	{
    		PersonalTo user2=new PersonalTo();
    		user2.setCompany_name(request.getParameter("company_name"));
    		user2.setDesignation(request.getParameter("designation"));
    		user2.setAccount_number(accno);
    		user2.setLoan_id(loan_id);
    		try
    		{
    		user2.setAnnual_income(Long.parseLong(request.getParameter("annual_income")));
    		}
    		catch(NumberFormatException e)
			{
    			throw new ApplyLoanBusinessException("Annual Income is either empty or not in correct format");
			}
    		try
    		{
    		user2.setTotalexp(Double.parseDouble(request.getParameter("totalexp")));
    		}
    		catch(NumberFormatException e)
			{
				throw new ApplyLoanBusinessException("Total Experience is either empty or not in correct format");
			}
    		try
    		{
    			user2.setCurrentexp(Double.parseDouble(request.getParameter("currentexp")));
    		}
    		catch(NumberFormatException e)
			{
				throw new ApplyLoanBusinessException("Current Experience is either empty or not in correct format");
			}
    		
    		Long AnnualIncome=Long.parseLong(request.getParameter("annual_income"));
    		String Company=request.getParameter("company_name");
    		Double TotalExp=Double.parseDouble(request.getParameter("totalexp"));
    		Double CurrentExp=Double.parseDouble(request.getParameter("currentexp"));
    		String Designation=request.getParameter("designation");
    		
    		
    		if(AnnualIncome==null)
    		{
    			request.setAttribute("message", "Enter Annual income");
				 RequestDispatcher rd=request.getRequestDispatcher("PersonalOrHousing.jsp");
					rd.forward(request, response);
    		}
    		else if(Company.equals(""))
    		{
    			request.setAttribute("message", "Enter Company Name");
				 RequestDispatcher rd=request.getRequestDispatcher("PersonalOrHousing.jsp");
					rd.forward(request, response);
    		}
    		else if(Designation.equals(""))
    		{
    			request.setAttribute("message", "Enter Designation");
				 RequestDispatcher rd=request.getRequestDispatcher("PersonalOrHousing.jsp");
					rd.forward(request, response);
    		}
    		else if(TotalExp==null)
    		{
    			request.setAttribute("message", "Enter Total Experience");
				 RequestDispatcher rd=request.getRequestDispatcher("PersonalOrHousing.jsp");
					rd.forward(request, response);
    		}
    		else if(CurrentExp==null)
    		{
    			request.setAttribute("message", "Enter Current Experience");
				 RequestDispatcher rd=request.getRequestDispatcher("PersonalOrHousing.jsp");
					rd.forward(request, response);	
    		}
    		else
    		{
    		PersonalBO bo2=new PersonalBO();
    		if(bo2.registerUser(user2))
		    {
    			
    			
		    	RequestDispatcher rd=request.getRequestDispatcher("successpersonal.jsp");
		    	LOG.info("Redirected to successpersonal.jsp ");
				
				rd.forward(request, response);
		    }
    		}
    	}
    	catch(ApplyLoanBusinessException e)
		{
			request.setAttribute("message", e.getMessage());
			RequestDispatcher rr=request.getRequestDispatcher("PersonalOrHousing.jsp");
			rr.forward(request, response);
		}
		catch(ApplyLoanException e)
		{
			
			request.setAttribute("errMessage", e.getMessage());
			RequestDispatcher rr=request.getRequestDispatcher("errorloan.jsp");
			rr.forward(request, response);
		}
    	
    	
	}

}
