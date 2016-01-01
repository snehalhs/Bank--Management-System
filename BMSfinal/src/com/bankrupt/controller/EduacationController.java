package com.bankrupt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.bankrupt.bo.EducationalBO;
import com.bankrupt.exception.ApplyLoanBusinessException;
import com.bankrupt.exception.ApplyLoanException;
import com.bankrupt.vo.EducationalTo;


public class EduacationController extends HttpServlet {
	private static final Logger LOG = Logger.getLogger("EduacationController");
	private static final long serialVersionUID = 1L;
       
   
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LOG.info("Entered into doPost method of EduacationController ");
		
		ServletConfig te=getServletConfig();
	    ServletContext wr=te.getServletContext();
	    String accno=(String) wr.getAttribute("acno");
	    
	    
	    ServletConfig forLoan=getServletConfig();
	    ServletContext wr1=forLoan.getServletContext();
	    String loan_id=(String) wr1.getAttribute("loanid");
	    
	    
		try
		{
			EducationalTo user1=new EducationalTo();
			user1.setCourse(request.getParameter("course"));
			user1.setFather_name(request.getParameter("father_name"));
			user1.setFather_occupation(request.getParameter("father_occupation"));
			user1.setAccount_number(accno);                                     //To set Account Number
			user1.setLaon_id(loan_id);                                         //To set Loan_id
			try
			{
				user1.setCourse_fee(Long.parseLong(request.getParameter("course_fee")));
			}
			catch(NumberFormatException e)
			{
				throw new ApplyLoanBusinessException("Course fee is either empty or not in correct format");
			}
			try
			{
				user1.setFather_totalexp(Double.parseDouble(request.getParameter("father_totalexp")));
			}
			catch(NumberFormatException e)
			{
				throw new ApplyLoanBusinessException("Experience is either empty or not in proper format");
			}
			try
			{
				user1.setFather_currentexp(Double.parseDouble(request.getParameter("father_currentexp")));
			}
			catch(NumberFormatException e)
			{
				throw new ApplyLoanBusinessException("Current experience is either empty or not in proper format");
			}
			
			
			
			
			try
			{
				 
			user1.setRationcard_number(Long.parseLong(request.getParameter("rationcard_number")));
				 
			}
			catch(NumberFormatException e)
			{
				throw new ApplyLoanBusinessException("Ration card Number should be a number");
			}
			
			try
			{
				user1.setAnnual_income(Long.parseLong(request.getParameter("annual_income")));
			}
		    catch(NumberFormatException e)
		    {
		    	throw new ApplyLoanBusinessException("Annual income is either null or not in correct format");
		    }
		    
			String course1=request.getParameter("course");
		    String FatherName=request.getParameter("father_name");
		    String FatherOccupation=request.getParameter("father_occupation");
		    Double TotalExp=Double.parseDouble(request.getParameter("father_totalexp"));
		    Double CurrentExp=Double.parseDouble(request.getParameter("father_currentexp"));
		    Long Rationcard=Long.parseLong(request.getParameter("rationcard_number"));
		    Long AnnualIncome=Long.parseLong(request.getParameter("annual_income"));
		    
		    
		    if(course1.equals(""))
		    {
		    	request.setAttribute("message", "Enter course");
				 RequestDispatcher rd=request.getRequestDispatcher("Educational.jsp");
					rd.forward(request, response);
		    }
		    else if(FatherName.equals(""))
		    {
		    	request.setAttribute("message", "Enter Father Name");
				 RequestDispatcher rd=request.getRequestDispatcher("Educational.jsp");
					rd.forward(request, response);
		    }
		    else if(FatherOccupation.equals(""))
		    {
		    	request.setAttribute("message", "Enter  Father Occupation");
				 RequestDispatcher rd=request.getRequestDispatcher("Educational.jsp");
					rd.forward(request, response);
		    }
		    else if(TotalExp==null)
		    {
		    	request.setAttribute("message", "Enter Total Experience");
				 RequestDispatcher rd=request.getRequestDispatcher("Educational.jsp");
					rd.forward(request, response);
		    }
		    else if(CurrentExp==null)
		    {
		    	request.setAttribute("message", "Enter Current Experience");
				 RequestDispatcher rd=request.getRequestDispatcher("Educational.jsp");
					rd.forward(request, response);
		    }
		    else if(Rationcard==null)
		    {
		    	request.setAttribute("message", "Enter ration Card Number");
				 RequestDispatcher rd=request.getRequestDispatcher("Educational.jsp");
					rd.forward(request, response);
		    }
		    else if(AnnualIncome==null)
		    {
		    	request.setAttribute("message", "Enter Annual Income");
				 RequestDispatcher rd=request.getRequestDispatcher("Educational.jsp");
					rd.forward(request, response);
		    }
		    else
		    {
		    EducationalBO bo1=new EducationalBO();
		    if(bo1.registerUser(user1))
		    {
		    	RequestDispatcher rd=request.getRequestDispatcher("successeducation.jsp");
		    	LOG.info("Redirected to successeducation.jsp ");
				rd.forward(request, response);
		    }
		    }
		}
		catch(ApplyLoanBusinessException e)
		{
			request.setAttribute("message", e.getMessage());
			RequestDispatcher rr=request.getRequestDispatcher("Educational.jsp");
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
