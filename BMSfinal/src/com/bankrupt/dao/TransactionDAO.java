package com.bankrupt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.bankrupt.exception.TransactionBusinessException;
import com.bankrupt.exception.TransactionException;
import com.bankrupt.vo.AccountVO;
import com.bankrupt.vo.TransactionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TransactionDAO.
 */
public class TransactionDAO {
	private static final Logger LOG = Logger.getLogger("TransactionDAO");
	/** The count. */
	int count=0;
	
	/** The connection. */
	Connection connection=null;
	
	/** The resultset. */
	ResultSet resultset=null;
	
	
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
		LOG.info("Connection Successfull inside TransactionDAO");
		return con;
	}
	
	/**
	 * Fetch details.
	 *
	 * @param temp the acc num
	 * @return the account vo
	 * @throws TransactionException the transaction exception
	 * @throws TransactionBusinessException the transaction business exception
	 */
	public AccountVO fetchDetails(String temp) throws  TransactionException, TransactionBusinessException
	{
		LOG.info(" Inside fetchDetails method of  TransactionDAO");
		
		AccountVO accvo = new AccountVO();
		boolean flag=false;
		try{
		Connection con=getConnection();
		
		String query="select account_number,name,acc_type from bms_customer_details1 where account_number=?";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1,temp);
		ResultSet rs=pst.executeQuery();
				
		Date txndate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String tdate = sdf.format(txndate);
		while(rs.next())
		{
			    
				flag=true;
				accvo.setAccNumber(rs.getString("account_number"));
				accvo.setAccName(rs.getString("name"));
				accvo.setAccType(rs.getString("acc_type"));
				
				accvo.setTxnDate(tdate);
				
				String sqlIdentifier = "select transaction_id.nextval from dual";
				PreparedStatement pst1 = con.prepareStatement(sqlIdentifier);
				ResultSet rs1 = pst1.executeQuery();
				if(rs1.next())
					accvo.setTransactionID(rs1.getInt(1));
		 
				break;
		}
		
		if(!flag)
		{
			throw new TransactionBusinessException("Invalid Account Number");
		}
		}
		catch(SQLException e)
		{
			throw new TransactionException("data connection error");
		} 
		catch (ClassNotFoundException e) 
		{
			throw new TransactionException("Class not found");	
		}
		LOG.info("End of fetchDetails method of  TransactionDAO");
		
		return accvo;
	}
	
	/**
	 * Gets the balance.
	 *
	 * @param accnum the acc num
	 * @return the balance
	 * @throws TransactionException the transaction exception
	 */
	public double getBalance(String accnum) throws TransactionException 
	{
		LOG.info(" Inside getBalance method of  TransactionDAO");
		
		double bal = 0;
		try{
	
		Connection con1=getConnection();
	
		String query="select * from bms_balance1 where account_number=?";
		PreparedStatement pst2=con1.prepareStatement(query);
		pst2.setString(1,accnum);
		ResultSet rs2=pst2.executeQuery();
		
		while(rs2.next())
		{
			bal = rs2.getDouble(2);
		}
		}
		catch(SQLException e)
		{
			throw new TransactionException("data connection error");
		} 
		catch (ClassNotFoundException e) 
		{
			throw new TransactionException("Class not found");	
		}
		LOG.info("End of getBalance method of  TransactionDAO");
		
		return bal;
	}
	
	/**
	 * Gets the minimum balance.
	 *
	 * @param accnum the acc num
	 * @return the minimum balance
	 * @throws TransactionException the transaction exception
	 */
	public double getMinimumBalance(String accnum) throws TransactionException 
	{
		LOG.info(" Inside getMinimumBalance method of  TransactionDAO");
		
		double minbal = 0;
		try{
	
		Connection con6=getConnection();
		String query1="select country from bms_customer_details1 where account_number=?";
		PreparedStatement pst7=con6.prepareStatement(query1);
		pst7.setString(1,accnum);
		ResultSet rs7=pst7.executeQuery();
		String country = null;
		if(rs7.next())
		{
			 country = rs7.getString("country");
		}
		String query="select * from bms_saving_account where country=?";
		PreparedStatement pst6=con6.prepareStatement(query);
		
		pst6.setString(1,country);
		ResultSet rs6=pst6.executeQuery();
		
		while(rs6.next())
		{
			minbal = rs6.getDouble(2);
		}
		}
		catch(SQLException e)
		{
			throw new TransactionException("data connection error");
		} 
		catch (ClassNotFoundException e) 
		{
			throw new TransactionException("Class not found");	
		}
		LOG.info("End of getMinimumBalance method of  TransactionDAO");
		
		return minbal;
	}
	
	/**
	 * Gets the emi amount.
	 *
	 * @param accnum the acc num
	 * @return the emi amount
	 * @throws TransactionException 
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public double getEmiAmount(String accnum) throws TransactionException 
	{
		LOG.info(" Inside getEmiAmount method of  TransactionDAO");
		
		double emi = 0;
		try {
			Connection con3 = getConnection();
			
			String query="select * from bms_emi1 where account_number=?";
			PreparedStatement pst3=con3.prepareStatement(query);
			pst3.setString(1,accnum);
			ResultSet rs3=pst3.executeQuery();
			while(rs3.next())
			{
				emi = rs3.getDouble(3);
			}
		} 
		catch(SQLException e)
		{
			throw new TransactionException("data connection error");
		} 
		catch (ClassNotFoundException e) 
		{
			throw new TransactionException("Class not found");	
		}

		LOG.info("End of getEmiAmount method of  TransactionDAO");
		
		return emi;
	}

	/**
	 * Transaction details.
	 *
	 * @param tvo the tvo
	 * @return true, if successful
	 * @throws TransactionException the transaction exception
	 */
	public boolean transactionDetails(TransactionVO tvo) throws  TransactionException
	{
		LOG.info(" Inside transactionDetails method of  TransactionDAO");
		
		boolean flag=false;
		try{
		Connection con4=getConnection();
		String query="insert into bms_transaction1 values(?,?,?,?,?,?,?,?)";
		PreparedStatement pst4=con4.prepareStatement(query);
		Date d= tvo.getTransactionDate();
		java.sql.Date d1= new java.sql.Date(d.getTime());
		pst4.setInt(1,tvo.getTransactionID());
		pst4.setString(2,tvo.getAccNumber());
		pst4.setString(3,tvo.getAccName());
		pst4.setString(4,tvo.getAccType());
		pst4.setString(5,tvo.getTransactionType());
		pst4.setDate(6,d1);
		pst4.setDouble(7,tvo.getAmount());
		pst4.setDouble(8,tvo.getBalance());
		
		ResultSet rs4=pst4.executeQuery();
		if(rs4.next())
		{
			flag=true;
		}
		
		String query1="update bms_balance1 set balance=? where account_number=?";
		PreparedStatement pst5=con4.prepareStatement(query1);
		pst5.setDouble(1,tvo.getBalance());
		pst5.setString(2,tvo.getAccNumber());
		ResultSet rs5=pst5.executeQuery();
		if(rs5.next())
		{
			
		}
		
		}
		catch(SQLException e)
		{
			throw new TransactionException("data connection error");
		} 
		catch (ClassNotFoundException e) 
		{
			throw new TransactionException("Class not found");	
		}
		LOG.info("End of transactionDetails method of  TransactionDAO");
		
		return flag;
	}
	
	
}
