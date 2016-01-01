package com.bankrupt.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.bankrupt.bo.TransactionBO;
import com.bankrupt.exception.*;
import com.bankrupt.vo.AccountVO;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class AccountExistanceController.
 */
public class AccountExistanceController extends HttpServlet {
	private static final Logger LOG = Logger.getLogger("AccountExistanceController");
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AccountExistanceController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		LOG.info("Entered into doPost method of AccountExistanceController ");
		
			HttpSession hs = request.getSession();
			TransactionBO txnbo = new TransactionBO();
			AccountVO avo = new AccountVO();
		try {
			String temp = request.getParameter("accountnumber");
			
			String accnum=(String)hs.getAttribute("AccountNum");
			
			if(temp.equalsIgnoreCase(accnum))
			{
				avo.setAccNumber(temp);
				
				avo = txnbo.validateAccountNumber(temp);
			}
			else
			{
				throw new TransactionBusinessException("Invalid account number");
			}
			 if(avo!=null)
				{
					hs.setAttribute("result", avo);
					
					RequestDispatcher rd=request.getRequestDispatcher("AccountDetails.jsp");
					LOG.info("Redirected to AccountDetails.jsp");
					rd.include(request, response);
				}
			 
				
		} 
		catch(NumberFormatException e)
		{
			try {
				throw new TransactionBusinessException();
			} catch (TransactionBusinessException e1) {
				
			}
		}
		catch(TransactionBusinessException e)
		{
			request.setAttribute("message",e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("Transaction.jsp");
			rd.include(request, response);
		}
		catch(TransactionException e)
		{
			RequestDispatcher rd=request.getRequestDispatcher("TransactionError.jsp");
			rd.include(request, response);
		}	
		
	}

}
