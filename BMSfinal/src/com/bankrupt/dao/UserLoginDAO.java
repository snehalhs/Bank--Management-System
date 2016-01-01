package com.bankrupt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bankrupt.exception.EntryException;


public class UserLoginDAO {
	private static final Logger LOG = Logger.getLogger("UserLoginDAO");
	private java.sql.Connection getConnection()throws SQLException, ClassNotFoundException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection	con=DriverManager.getConnection("jdbc:oracle:thin:@10.241.47.160:1521:oracle","training","training");
		LOG.info("Connection Successfull inside UserLoginDAO");
		
		return con;
	}
	
	public String checkUser(String customerId, String pwd) throws EntryException
	{
		 LOG.info(" Inside checkUser method of  UserLoginDAO");
		 	
		String str=null;
		Connection con;
		
	try {
		
		con=getConnection();
		String query="select account_number from bms_customer_details1 where customer_id=? and password=? ";
		PreparedStatement pst=con.prepareStatement(query);
		
		pst.setString(1, customerId);
		pst.setString(2, pwd);
		ResultSet rs=pst.executeQuery();
		
		if(rs.next())
		{
			
			str=rs.getString(1);
		
		}
						
		} catch ( ClassNotFoundException e) {
			
			throw new EntryException(e); 
		}catch (SQLException e) {
			
			throw new EntryException(e);
		}
	
	
		 LOG.info(" End of  checkUser method of  UserLoginDAO");
		 
	return str;
	}
}
