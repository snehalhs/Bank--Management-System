package com.bankrupt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.bankrupt.bo.UserLoginBO;
import com.bankrupt.exception.EntryException;

/**
 * Servlet implementation class EntryController
 */
public class BankLoginController extends HttpServlet {
	private static final Logger LOG = Logger.getLogger("BankLoginController");
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BankLoginController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		LOG.info("Entered into doPost method of BankLoginController ");
		
			
		try {	
			
		String customerId=request.getParameter("cusid");
		String pwd=request.getParameter("pwd");
		
		
		UserLoginBO bo=new UserLoginBO();
		boolean b=true;
		
			String acc_no=bo.checkUser(customerId, pwd);
			
			if(acc_no==null)
			{
				b=false;
				RequestDispatcher rs=request.getRequestDispatcher("UserLoginPage.jsp");
				LOG.info("Redirected to UserLoginPage.jsp ");
				
				rs.forward(request,response);
				
			}
			else
			{
				HttpSession session=request.getSession();
				session.setAttribute("AccountNum", acc_no);
				session.setAttribute("cusid",customerId);
				LOG.info("Redirected to bankHomePage.jsp ");
				RequestDispatcher rs=request.getRequestDispatcher("bankHomePage.jsp");
				rs.forward(request,response);
			}
				
			
			
			
		}
		
		
		
		 catch (EntryException e) {
				
			 
			}
			
		
		
	}

}
