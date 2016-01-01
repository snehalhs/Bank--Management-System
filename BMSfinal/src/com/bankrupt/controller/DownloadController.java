package com.bankrupt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


import com.bankrupt.download.MakeTXT;
import com.bankrupt.vo.ViewTO;





public class DownloadController extends HttpServlet {
	private static final Logger LOG = Logger.getLogger("DownloadController");
	private static final long serialVersionUID = 1L;
       
    
    public DownloadController() {
        super();
       
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LOG.info("Entered into doPost method of DownloadController ");
		
		ServletConfig config=getServletConfig();
		ServletContext context=config.getServletContext();
		List<ViewTO> obj=(List<ViewTO>)context.getAttribute("list");
		
		HttpSession hs=request.getSession();
		String cusId=(String)hs.getAttribute("cusid");
		
		ViewTO x=obj.get(1);
		String aNo=x.getAccountNumber();
		String fdate=x.getFdate();
		String tdate=x.getTdate();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
		Date d1=new Date();
		Date d2=new Date();
		try {
			d1=sdf.parse(fdate);
			 d2=sdf.parse(tdate);
		} catch (ParseException e) {
			
		}
		
		SimpleDateFormat sdf1=new SimpleDateFormat("ddMMyyyy");
		String fd=sdf1.format(d1);
		String td=sdf1.format(d2);
		
		String name=cusId+"-"+fd+"-"+td;
		String flname=name+".txt";
		
		MakeTXT m=new MakeTXT();
		boolean b=m.csvFormat(obj,name);
		
		if(b)
			{
			LOG.info("data obbtained is written to the TXT file");
			request.setAttribute("rest", flname);
			RequestDispatcher rd=request.getRequestDispatcher("downloadsuccess.jsp");
			LOG.info("Redirected to downloadsuccess.jsp ");
			rd.forward(request, response);
			}
		
	}

}
