package com.bankrupt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.bankrupt.bo.ViewBO;
import com.bankrupt.exception.ViewException;
import com.bankrupt.exception.ViewStatementException;
import com.bankrupt.vo.ViewTO;
import com.bankrupt.vo.ViewVO;


public class ViewController extends HttpServlet {
	
	private static final Logger LOG = Logger.getLogger("ViewController");
	private static final long serialVersionUID = 1L;

    public ViewController() {
        
    }

    /**
     * doPost method of ViewController 
     * gets the entry made by user into statementGeneration.jsp
     * and on retrival of transactions data sends them to ViewDisplay.jsp
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		LOG.info("Entered into doPost method of ViewController ");
		
		try{
				HttpSession hs=request.getSession();
				String accountNumber=(String)hs.getAttribute("AccountNum");
				
				
				String fD=request.getParameter("fdate");
				String tD=request.getParameter("tdate");
				String Transaction_type=request.getParameter("Transaction_type");
				int Transaction_per_page=Integer.parseInt(request.getParameter("Transaction_per_page"));
				DateFormat originalFormat = new SimpleDateFormat("MM/dd/yyyy");
				DateFormat targetFormat = new SimpleDateFormat("dd-MMM-yyyy");
				
				
				Date date=new Date();
				Date date2=new Date();
				try {
					date = originalFormat.parse(fD);
					 date2 = originalFormat.parse(tD);
				} catch (ParseException e) {
				throw new ViewStatementException("date not in correct format");
				}
				String fdate= targetFormat.format(date);  
				
				String tdate = targetFormat.format(date2);  
				ViewVO vo=new ViewVO();
				
				vo.setFdate(fdate);
				vo.setTdate(tdate);
				vo.setTransactionType(Transaction_type);
				vo.setTransactionPerPage(Transaction_per_page);
				vo.setAccountNumber(accountNumber);
				
				
				LOG.info("sets the data recieved from statementgeneration.jsp to ViewVO object");
			
				
				ViewBO bo=new ViewBO();
				List<ViewTO> output=bo.fetchTotalData(vo);
				
				
			 
				if(output.size()!=0)
				{
					ViewTO x=output.get(1);
					String Account_number=x.getAccountNumber();
					request.setAttribute("accNumber",Account_number);
					request.setAttribute("result", output);
					LOG.info("Redirected to ViewDisplay.jsp ");
					RequestDispatcher rd=request.getRequestDispatcher("ViewDisplay.jsp");
					rd.forward(request, response);
				}
				else
				{
					throw new ViewStatementException("no transactions found");
				}
			
			
			
		}catch (ViewStatementException e) {
			
			request.setAttribute("message", e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("statementGeneration.jsp");
			rd.forward(request, response);
		} catch (ViewException e) {
			
			request.setAttribute("errMessage", e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("statementError.jsp");
			rd.forward(request, response);
		}
	}

}
