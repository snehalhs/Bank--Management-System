package com.bankrupt.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.bankrupt.bo.ApplyLoanBO;
import com.bankrupt.dao.UserDAO;
import com.bankrupt.exception.ApplyLoanBusinessException;
import com.bankrupt.exception.ApplyLoanException;
import com.bankrupt.vo.UserTo;



/**
 * The Class ApplyLoanController.
 */
public class ApplyLoanController extends HttpServlet {
	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger("ApplyLoanController");
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	   
		LOG.info("Entered into doPost method of ApplyLoanController ");
		
		
		ServletConfig congig=getServletConfig();
		ServletContext context=congig.getServletContext(); 
		
		HttpSession hs=request.getSession();
		String mm=(String)hs.getAttribute("AccountNum");
		
	    ServletConfig te=getServletConfig();
	    ServletContext wr=te.getServletContext();
		wr.setAttribute("acno", mm);
		
		
		
		
        
		
		
		try{
			UserTo user=new UserTo();
		
	        user.setLoan_type(request.getParameter("loan_type"));
	        user.setAccount_number(mm);
			
			
			SimpleDateFormat sf1=new SimpleDateFormat("MM/dd/yyyy");
			SimpleDateFormat sf2=new SimpleDateFormat("dd-MMM-yyyy");
			String oldDate=request.getParameter("loan_apply_date");
			Date oldDate1=new Date();
			try {
				 oldDate1=sf1.parse(oldDate);
			} catch (ParseException e1) {
			
			}
			String newDate=sf2.format(oldDate1);
			
		    user.setLoan_apply_date(newDate);
			
			
			String issuedate=request.getParameter("loan_issue_date");
			Date oldIssue=new Date();
			try {
				oldIssue=sf1.parse(issuedate);
			} catch (ParseException e1) {
				
				
			}
			String newIssue=sf2.format(oldIssue);
			
		    user.setLoan_issue_date(newIssue);
		
		    
			
		    
		 try{
			user.setLoan_amount(Integer.parseInt(request.getParameter("loan_amount")));
		   }
		catch(NumberFormatException e)
		{
			throw new ApplyLoanBusinessException("Loan amount is either empty on not in correct format");
		}
		try{
			user.setDuration_of_loan(Integer.parseInt(request.getParameter("duration_of_loan")));
		}
		catch(NumberFormatException e)
		{
			throw new ApplyLoanBusinessException("Duration of loan is either empty or not in correct format");
		}
		try{
			user.setRate_of_interest(Double.parseDouble(request.getParameter("rate_of_interest")));
		}
		catch(NumberFormatException e)
		{
			throw new ApplyLoanBusinessException("Rate of Interest is either empty or not in correct format");
		}
		
		 String ss1=request.getParameter("loan_type");
		 
		 String applyDate=request.getParameter("loan_apply_date");
		 String IssueDate=request.getParameter("loan_issue_date");
		 
		 
		 if(ss1.equals("select"))
		 {
			 request.setAttribute("message", "select loan Type");
			 RequestDispatcher rd=request.getRequestDispatcher("ApplyLoan.jsp");
				rd.forward(request, response);
		 }
		 else if(applyDate.equals("")||applyDate.equals(null))
		 {
			 request.setAttribute("message", "select Loan Apply date");
			 RequestDispatcher rd=request.getRequestDispatcher("ApplyLoan.jsp");
				rd.forward(request, response);
			 
		 }
		 else if(IssueDate.equals("") || IssueDate.equals(null))
		 {
			 request.setAttribute("message", "select Loan Issue date");
			 RequestDispatcher rd=request.getRequestDispatcher("ApplyLoan.jsp");
				rd.forward(request, response);
		 }
		
		
		 else
		 {
		ApplyLoanBO bo=new ApplyLoanBO();
		if(bo.registerUser(user))
		{
			
			if(user.getLoan_type().equals("Educational"))
			{
				context.setAttribute("loanid", user.getLoan_id());
				LOG.info("Redirected to Educational.jsp ");
				
				RequestDispatcher rd=request.getRequestDispatcher("Educational.jsp");
				rd.forward(request, response);
			}
			if(user.getLoan_type().equals("Personal_Housing"))
			{   context.setAttribute("loanid", user.getLoan_id());
				RequestDispatcher rd=request.getRequestDispatcher("PersonalOrHousing.jsp");
				LOG.info("Redirected to PersonalOrHousing.jsp");
				
				rd.forward(request, response);
			}
			
		}
		 }
		
	}
		catch(ApplyLoanBusinessException e)
		{
			request.setAttribute("message", e.getMessage());
			RequestDispatcher rr=request.getRequestDispatcher("ApplyLoan.jsp");
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
