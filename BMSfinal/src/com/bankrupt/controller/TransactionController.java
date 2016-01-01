package com.bankrupt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bankrupt.bo.TransactionBO;
import com.bankrupt.exception.TransactionBusinessException;
import com.bankrupt.exception.TransactionException;
import com.bankrupt.vo.TransactionVO;


// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class TransactionController.
 */
public class TransactionController extends HttpServlet {
	private static final Logger LOG = Logger.getLogger("TransactionController");
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * Instantiates a new transaction controller.
     *
     * @see HttpServlet#HttpServlet()
     */
    public TransactionController() {
        super();
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
		LOG.info("Entered into doPost method of TransactionController ");
		
		TransactionVO txnvo = new TransactionVO();
		try {
				txnvo.setAccNumber(request.getParameter("accountnumber"));
				txnvo.setAccName(request.getParameter("accountname"));
				txnvo.setAccType(request.getParameter("accounttype"));
				txnvo.setTransactionID(Integer.parseInt(request.getParameter("transactionid")));
				txnvo.setTransactionType(request.getParameter("transactiontype"));
		
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String sdate= null;
		
				txnvo.setTransactionDate(sdf.parse(request.getParameter("transactiondate")));
				sdate = sdf.format(txnvo.getTransactionDate());
				txnvo.setTxnDate(sdate);        
		 
		
				String s = request.getParameter("transactiontype");
		
				TransactionBO txnbo = new TransactionBO();
				if(s.equalsIgnoreCase("credit"))
				{
					txnvo.setAmount(Double.parseDouble(request.getParameter("amount")));
					txnbo.doDeposit(txnvo);
				} 
		
				else if(s.equalsIgnoreCase("debit"))
				{
					txnvo.setAmount(Double.parseDouble(request.getParameter("amount")));
					txnbo.doWithdrawal(txnvo);
			
				} 
			
		
				else if(s.equalsIgnoreCase("Loan EMI"))
				{
					txnbo.doLoanEmiDebit(txnvo);
				} 
			
				else
				{
					throw new TransactionBusinessException("Select the Transaction Type");
				}
				
				request.setAttribute("balance",txnvo.getBalance());
				LOG.info("Redirected to TransactionSuccess.jsp ");
				
				javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("TransactionSuccess.jsp");
				rd.forward(request, response);
				
			}
		catch (NumberFormatException e) 
		{
			
			try 
			{
				throw new TransactionBusinessException("Enter valid amount");
			} 
			catch (TransactionBusinessException e1) 
			{
				request.setAttribute("message", e1.getMessage());
				RequestDispatcher rd=request.getRequestDispatcher("AccountDetails.jsp");
				rd.forward(request, response);
			}
			
		}
		catch(TransactionException e)
		{
			RequestDispatcher rd=request.getRequestDispatcher("TransactionError.jsp");
			rd.forward(request, response);
		}	
		catch (TransactionBusinessException e) 
		{
			
			request.setAttribute("message", e.getMessage());
			request.setAttribute("result", txnvo);
			javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("AccountDetails.jsp");
			rd.forward(request, response);
		} 
		catch (ParseException e)
		{
			
		} 
		
  }
}
