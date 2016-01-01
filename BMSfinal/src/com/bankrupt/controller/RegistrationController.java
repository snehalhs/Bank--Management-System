package com.bankrupt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bankrupt.bo.RegistrationBO;
import com.bankrupt.exception.RegistrationBusinessException;
import com.bankrupt.exception.RegistrationException;
import com.bankrupt.vo.RegistrationVO;

/**
 * Servlet implementation class RegistrationController
 */
public class RegistrationController extends HttpServlet {
	private static final Logger LOG = Logger.getLogger("RegistrationController");
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistrationController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LOG.info("Entered into doPost method of RegistrationController ");
		
	RegistrationVO vo=new RegistrationVO();
	RegistrationBO bo=new RegistrationBO();
	try {
		
	vo.setACC_TYPE(request.getParameter("acctype"));
	vo.setADDRESS(request.getParameter("add"));
	vo.setBRANCH_NAME(request.getParameter("branchname"));
	vo.setCITIZEN_STATUS(request.getParameter("citizenstatus"));
	vo.setCONTACT_NUMBER(Integer.parseInt(request.getParameter("contactno")));
	vo.setCITIZENSHIP(request.getParameter("ship"));
	vo.setCOUNTRY(request.getParameter("country"));
	vo.setEMAIL(request.getParameter("email"));
	vo.setDOB(request.getParameter("dob"));
	vo.setGENDER(request.getParameter("gender"));
	vo.setGUARDIAN_NAME(request.getParameter("gnname"));
	vo.setGUARDIAN_TYPE(request.getParameter("gtype"));
	vo.setID_DOC_NO(request.getParameter("idno"));
	vo.setID_PROOF_TYPE(request.getParameter("id type"));
	vo.setINITIAL_DEPOSIT_AMOUNT(Integer.parseInt(request.getParameter("InitialDepAmnt")));
	vo.setMARITAL_STATUS(request.getParameter("maritalstatus"));
	vo.setNAME(request.getParameter("name"));
	vo.setPASSWORD(request.getParameter("pwd"));
	vo.setREF_ACC_NO(request.getParameter("refaccno"));
	vo.setREF_ADDRESS(request.getParameter("refaddrs"));
	vo.setREF_HOLDER_NAME(request.getParameter("refname"));
	vo.setSTATE(request.getParameter("state"));
	vo.setUSERNAME(request.getParameter("username"));
	vo.setREG_DATE(request.getParameter("reg"));
	vo.setACTIVATION_DATE(bo.activationDate());
	String d=vo.toString();
	
		boolean b=bo.registerDetails(vo);
	
		if(b)
		{
		
			RequestDispatcher rd=request.getRequestDispatcher("RegisterSuccess.jsp");
			LOG.info("Redirected to RegisterSuccess.jsp ");
			
			rd.forward(request, response);
			
		}
	}
		
	 catch (RegistrationBusinessException e) {
			
		 request.setAttribute("message", e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("RegistrationPage1.jsp");
			rd.forward(request, response);
		}
		catch (RegistrationException e) {
			
			request.setAttribute("message", e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("RegisterError.jsp");
			rd.forward(request, response);
		}

	}

}
