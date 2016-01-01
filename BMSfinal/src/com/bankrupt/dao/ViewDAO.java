package com.bankrupt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.bankrupt.exception.ViewException;
import com.bankrupt.exception.ViewStatementException;
import com.bankrupt.vo.ViewTO;
//import com.cts.exception.RegistrationException;
//import com.cts.to.UserTo;
import com.bankrupt.vo.ViewVO;

public class ViewDAO {
	private static final Logger LOG = Logger.getLogger("ViewDAO");
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
		LOG.info("Connection Successfull inside ViewDAO");
		
		return con;
	}
	/**
	 * This function fetchTotalData retrieves the transactions done by the current user from Database 
	 * @param ViewVO object
	 * @return List of ViewTO type object
	 * @throws ViewException
	 * @throws ViewStatementException
	 */
	public List<ViewTO> displayDetails(ViewVO vo)throws ViewException,ViewStatementException
	{
		 LOG.info(" Inside displayDetails method of  ViewDAO");
			
		List<ViewTO> list=new ArrayList<ViewTO>();
		Connection con;
		try{
			con=getConnection();
			String transaction_type=vo.getTransactionType();
			
			if(transaction_type.equals("All_transaction"))
			{ 
				String query="select transaction_date,transaction_id,transaction_type,transaction_amount,transaction_balance from bms_transaction1 where TRANSACTION_DATE between ? and ? AND account_number=? ORDER BY transaction_date DESC,transaction_id DESC";   
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1, vo.getFdate());
				pst.setString(2, vo.getTdate());
				pst.setString(3, vo.getAccountNumber());
				
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					ViewTO to=new ViewTO();
					java.util.Date newDate = rs.getDate(1);
					
					to.setFdate(vo.getFdate());
					to.setTdate(vo.getTdate());
					to.setAccountNumber(vo.getAccountNumber());
					to.setTransactionDate(newDate);
					to.setTransactionId(rs.getInt(2));
					to.setTransactionType(rs.getString(3));
					
					to.setTransactionAmount(rs.getDouble(4));
					to.setBalance(rs.getDouble(5));
			
					
					
					list.add(to);
				}
			}
			else if(transaction_type.equals("Credit"))
			{
				
				String query="select transaction_date,transaction_id,transaction_type,transaction_amount,transaction_balance from bms_transaction1 where TRANSACTION_DATE between ? and ? AND account_number=? AND TRANSACTION_TYPE like 'credit' ORDER BY transaction_date DESC,transaction_id DESC";   
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1, vo.getFdate());
				pst.setString(2, vo.getTdate());
				pst.setString(3, vo.getAccountNumber());
				
			
			
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					ViewTO to=new ViewTO();
					
					java.util.Date newDate = rs.getDate(1);
					
					to.setFdate(vo.getFdate());
					to.setTdate(vo.getTdate());
					to.setAccountNumber(vo.getAccountNumber());
					to.setTransactionDate(newDate);
					to.setTransactionId(rs.getInt(2));
					to.setTransactionType(rs.getString(3));
					to.setTransactionAmount(rs.getDouble(4));
					to.setBalance(rs.getDouble(5));
			
					
					list.add(to);
				}
			}
			else
			{
				String query="select transaction_date,transaction_id,transaction_type,transaction_amount,transaction_balance from bms_transaction1 where TRANSACTION_DATE between ? and ? AND account_number=? AND TRANSACTION_TYPE  not like 'credit' ORDER BY transaction_date DESC,transaction_id DESC";   
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1, vo.getFdate());
				pst.setString(2, vo.getTdate());
				pst.setString(3, vo.getAccountNumber());
				
				
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					ViewTO to=new ViewTO();
					
					java.util.Date newDate = rs.getDate(1);
					to.setFdate(vo.getFdate());
					to.setTdate(vo.getTdate());
					to.setAccountNumber(vo.getAccountNumber());
					to.setTransactionDate(newDate);
					to.setTransactionId(rs.getInt(2));
					to.setTransactionType(rs.getString(3));
					to.setTransactionAmount(rs.getDouble(4));
					to.setBalance(rs.getDouble(5));
			
					list.add(to);	
				}
				
			}
			con.close();
		}catch ( ClassNotFoundException e) {
			throw new ViewException(e); 
		}catch (SQLException e) {
			throw new ViewException(e);
		}finally{
			
			
		}
		 LOG.info(" End of  displayDetails method of  ViewDAO");
			
		return list;
		
	}
	
}
