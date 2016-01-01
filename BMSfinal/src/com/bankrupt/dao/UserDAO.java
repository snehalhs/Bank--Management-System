package com.bankrupt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bankrupt.exception.ApplyLoanException;
import com.bankrupt.vo.EducationalTo;
import com.bankrupt.vo.PersonalTo;
import com.bankrupt.vo.UserTo;
import com.bankrupt.exception.ApplyLoanException;
import com.bankrupt.exception.ApplyLoanException;

/**
 * The Class UserDAO.
 */
public class UserDAO {
	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger("UserDAO");

/**
 * Gets the connection.
 *
 * @return the connection
 * @throws SQLException the sQL exception
 * @throws ClassNotFoundException the class not found exception
 */
private java.sql.Connection getConnection()throws SQLException, ClassNotFoundException
{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection	con=DriverManager.getConnection("jdbc:oracle:thin:@10.241.47.160:1521:oracle","training","training");
	LOG.info("Connection Successfull inside UserDAO");
	
	return con;
}
 

    /**
     * Register user method will generate the loan id and will insert the basic loan details in database
     *
     * @param user the user
     * @return true, if successful
     * @throws ApplyLoanException the apply loan exception
     */
    public boolean registerUser(UserTo user) throws ApplyLoanException
  {
     boolean flag1=false;
     LOG.info(" Inside registerUser method of  UserDAO");
 	
     
     try
     {
		Connection con=getConnection();
		
		int myId=0;
			String sqlIdentifier = "select Loan2_sequence.nextval from dual";
			PreparedStatement pst1 = con.prepareStatement(sqlIdentifier);
			ResultSet rs1 = pst1.executeQuery();
			if(rs1.next())
			 {
			      myId = rs1.getInt(1);
			 }
			String myId1= Integer.toString(myId);
			String loan_id="L-"+myId1;
			
			
		
		   user.setLoan_id(loan_id);
		   
		   
		
		String query="insert into bms_loan1 values(?,?,?,?,?,?,?,?)";
		
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1, user.getLoan_id());
		pst.setString(2, user.getAccount_number());
		pst.setString(3,user.getLoan_type());
		pst.setInt(4, user.getLoan_amount());
		pst.setString(5, user.getLoan_apply_date());
		pst.setString(6, user.getLoan_issue_date());
		pst.setDouble(7, user.getRate_of_interest());
		pst.setDouble(8, user.getDuration_of_loan());
		
		
		
		int i=pst.executeUpdate();
		if(i>0)
		{
			
			flag1=true;
		}
		
		
		
		String query1="insert into bms_emi1 values(?,?,?)";
		PreparedStatement psmt=con.prepareStatement(query1);
		
		
		psmt.setString(1, user.getLoan_id());
		psmt.setString(2, user.getAccount_number());
		psmt.setDouble(3, user.getEMI());
		 
		int j=psmt.executeUpdate();
		if(j>0)
		{
			flag1=true;
		}
		else
		{
			flag1=false;
		}
	 }
      catch (ClassNotFoundException e)
      {
	   throw new ApplyLoanException(e);
	  }
      catch (SQLException e)
       {
		throw new ApplyLoanException(e);
	   }
      LOG.info("End of registerUser method of  UserDAO");
		
  return flag1;

}
    
    
    
    
    /**
     * Education register method insert the educational loan details in database
     *
     * @param user1 the user1
     * @return true, if successful
     * @throws ApplyLoanException the apply loan exception
     */
    public boolean educationregister(EducationalTo user1) throws ApplyLoanException
	  {
	     boolean flag1=false;
	     
	     LOG.info(" Inside educationregister method of  UserDAO");
	  	 
	     
	    try
	     {
			Connection con=getConnection();
			
			String query="insert into bms_educational_loan1 values(?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(3,user1.getCourse());
			pst.setLong(4, user1.getCourse_fee());
			pst.setString(5, user1.getFather_name());
			pst.setString(6, user1.getFather_occupation());
			pst.setDouble(7, user1.getFather_totalexp());
			pst.setDouble(8, user1.getFather_currentexp());
			pst.setLong(9, user1.getRationcard_number());
			pst.setLong(10, user1.getAnnual_income());
			pst.setString(2, user1.getAccount_number());
			pst.setString(1, user1.getLaon_id());
			
			
			int i=pst.executeUpdate();
			if(i>0)
			{
				
				flag1=true;
			}
		 }
	     catch (ClassNotFoundException e)
	     {
		   throw new ApplyLoanException(e);
		 }
	     catch (SQLException e)
	     {
			throw new ApplyLoanException(e);
		  }
	     LOG.info("End of educationregister method of  UserDAO");
	 	
			return flag1;

}
    
    
    /**
     * Personal register user method insert the personal/housing loan details in database
     *
     * @param user2 the user2
     * @return true, if successful
     * @throws ApplyLoanException the apply loan exception
     */
    public boolean personalRegisterUser(PersonalTo user2) throws ApplyLoanException
	  {
	     boolean flag1=false;
	     
	     LOG.info(" Inside personalRegisterUser method of  UserDAO");
		  	 
	     
	     try
	     {
			Connection con=getConnection();
			
			String query="insert into bms_personalhousing_loan1 values(?,?,?,?,?,?,?)";
			
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, user2.getLoan_id());
			pst.setString(2, user2.getAccount_number());
			pst.setLong(3, user2.getAnnual_income());
			pst.setString(4, user2.getCompany_name());
			pst.setString(5, user2.getDesignation());
			pst.setDouble(6, user2.getTotalexp());
			pst.setDouble(7, user2.getCurrentexp());
			
			
			int i=pst.executeUpdate();
			
			if(i>0)
			{
				
				flag1=true;
			}
		}
	     catch (ClassNotFoundException e)
	     {
		   throw new ApplyLoanException(e);
		 }
	     catch (SQLException e)
	     {
			throw new ApplyLoanException(e);
		  }
	     LOG.info("End of personalRegisterUser method of  UserDAO");
		 	
			return flag1;

	  }
    
	}
