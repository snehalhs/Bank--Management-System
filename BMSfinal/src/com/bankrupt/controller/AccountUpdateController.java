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

import com.bankrupt.bo.UpdateSearchBO;
import com.bankrupt.exception.SearchBusinessException;
import com.bankrupt.exception.SearchException;
import com.bankrupt.vo.UpdateVo;
/**
 * Servlet implementation class AccountUpdateController
 */
public class AccountUpdateController extends HttpServlet {
	private static final Logger LOG = Logger.getLogger("AccountUpdateController");
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdateVo user=new UpdateVo();
		String CUSTOMER_ID="";
		try{
				CUSTOMER_ID=(request.getParameter("CUSTOMER_ID"));	
				HttpSession session=request.getSession();
				String cus=(String)session.getAttribute("cusid");
				if(!cus.equals(CUSTOMER_ID))
				{
					throw new SearchBusinessException("incorrect id entered");
				}
			UpdateSearchBO bo= new UpdateSearchBO();
			if(bo.searchDetails(CUSTOMER_ID))
			{								
				
				UpdateVo to=bo.displayDetails(CUSTOMER_ID);
				
				{
					if(to!=null)
					{
						request.setAttribute("result", to);
						
						RequestDispatcher rd=request.getRequestDispatcher("AccountUpdateDetails.jsp");
						rd.forward(request, response);
					}
				}
			}					
		}catch (SearchBusinessException e) {			
			request.setAttribute("message", e.getMessage());
			
			RequestDispatcher rd=request.getRequestDispatcher("accountUpdateSearch.jsp");			
			rd.forward(request, response);
		} catch (SearchException e) {			
			request.setAttribute("errMessage", e.getMessage());
			//cuLogger.error("Exception occured when processing searchDetailsdao:"+ e.getCause());
			RequestDispatcher rd=request.getRequestDispatcher("CustomerUpdateError.jsp");
			rd.forward(request, response);
		} 	

}
}
