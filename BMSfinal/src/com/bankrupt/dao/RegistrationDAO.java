package com.bankrupt.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bankrupt.exception.RegistrationException;
import com.bankrupt.vo.RegistrationVO;

public class RegistrationDAO {
	private static final Logger LOG = Logger.getLogger("RegistrationDAO");
	boolean flag=false;
	String accno="";
	String cusno="";
	RegistrationVO vo=new RegistrationVO();
	
	private java.sql.Connection getConnection()throws SQLException, ClassNotFoundException
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection	con=DriverManager.getConnection("jdbc:oracle:thin:@10.241.47.160:1521:oracle","training","training");
	LOG.info("Connection successful in RegistrationDAO");
		
	
		return con;
	}
	public boolean accountnoGen() throws RegistrationException{
		
		LOG.info("Inside accountnoGen method of RegistrationDAO");
				
		int a=0;
		int b=0;
		Connection con;
		try {
			con = getConnection();
		int myId1=0;
			String sqlIdentifier1 = "select acc_seq1.nextval from dual";
			PreparedStatement pst1 = con.prepareStatement(sqlIdentifier1);
			 ResultSet rs1= pst1.executeQuery();
			 
			   if(rs1.next()){
				   a++;
			     myId1 = rs1.getInt(1);
			     
					}
			   String s="100000000000"+Integer.toString(myId1);
			   accno=s;
			vo.setACCOUNT_NUMBER(s);
			 int myId2=0;
			   String sqlIdentifier2 = "select cust_seq1.nextval from dual";
				PreparedStatement pst2 = con.prepareStatement(sqlIdentifier2);
				 ResultSet rs2 = pst2.executeQuery();
				   if(rs2.next()){
					   b++;
				     myId2 = rs2.getInt(1);
				     
						}
				  String cid= Integer.toString(myId2);
				   String s1="R"+cid;
				  
				   cusno=s1;
				   vo.setCUSTOMER_ID(s1);
			   
		}
		catch (SQLException e) {
			
			throw new RegistrationException(e);
		} catch (ClassNotFoundException e) {
			
			throw new RegistrationException(e);
		}
		LOG.info("End of  accountnoGen method of RegistrationDAO");
		
		return (a>0&&b>0);
		}
	public Integer initialAmount(Integer j,String s) throws RegistrationException{
		LOG.info("Inside initialAmount method of RegistrationDAO");
		
		Connection con;
		int h=0;
		try {
			
			con = getConnection();
				
			PreparedStatement pst=con.prepareStatement("select  initial_amount from bms_saving_account1 where country=?");
			
	
			
			pst.setString(1,s);
			
			ResultSet rd=pst.executeQuery();
			
			
			if(rd.next())
			{
				
				h=rd.getInt(1);
				
			}
			if(h<=j)
			{
				h=0;
			}
			
		}
		catch (SQLException e) {
			
			throw new RegistrationException(e);
		} catch (ClassNotFoundException e) {
			
			throw new RegistrationException(e);
		}
		LOG.info("End of  initialAmount method of RegistrationDAO");
		
		return h;
	
	}
		
	public boolean panVerification(String pan,String num) throws RegistrationException{
		Connection con;

		try {
			LOG.info("Inside panVerification method of RegistrationDAO");
			
			con = getConnection();
			String query="select id_doc_no from bms_customer_details1 where id_proof_type=?,id_doc_no=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(2,num);
			pst.setString(1,pan);
			ResultSet rd=pst.executeQuery();
			if(rd.next()){
			
				flag=false;}
			else
				flag=true;
			
		}
		catch (SQLException e) {
			
			throw new RegistrationException(e);
		} catch (ClassNotFoundException e) {
			
			throw new RegistrationException(e);
		}
		LOG.info("End of  panVerification method of RegistrationDAO");
		
		return flag;
	}
		
	public boolean insertDetails(RegistrationVO vo) throws RegistrationException{
		Connection con;
		try {
			con = getConnection();
			LOG.info("Inside insertDetails method of RegistrationDAO");
			
	
		String query="insert into bms_customer_details1 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement pst=con.prepareStatement(query);
	
		pst.setString(19, vo.getACC_TYPE());
		pst.setString(8,vo.getADDRESS());
		pst.setString(20,vo.getBRANCH_NAME());
		pst.setString(21,vo.getCITIZEN_STATUS());
		pst.setString(9,vo.getCITIZENSHIP());
		pst.setLong(15,vo.getCONTACT_NUMBER());
		pst.setString(10,vo.getCOUNTRY());
		pst.setString(1,cusno);
		pst.setString(16,vo.getDOB());
		pst.setString(12,vo.getEMAIL());
		pst.setString(13,vo.getGENDER());
		pst.setString(7,vo.getGUARDIAN_NAME());
		pst.setString(6,vo.getGUARDIAN_TYPE());
		pst.setString(24,vo.getID_DOC_NO());
		pst.setString(23,vo.getID_PROOF_TYPE());
		pst.setDouble(22,(int) vo.getINITIAL_DEPOSIT_AMOUNT());
		pst.setString(14,vo.getMARITAL_STATUS());
		pst.setString(3,vo.getNAME());
		pst.setString(5,vo.getPASSWORD());
		pst.setString(26,vo.getREF_ACC_NO());
		pst.setString(27,vo.getREF_ADDRESS());
		pst.setString(25,vo.getREF_HOLDER_NAME());
		pst.setString(17,vo.getREG_DATE());
		pst.setString(11,vo.getSTATE());
		pst.setString(4,vo.getUSERNAME());
		pst.setString(2,accno);
		pst.setString(18,vo.getACTIVATION_DATE());
		Integer rd=pst.executeUpdate();
		if(rd>0)
			flag= true;
		PreparedStatement pst1=con.prepareStatement("insert into bms_balance1 values(?,?) ");
		pst1.setString(1, accno);
		pst1.setDouble(2, vo.getINITIAL_DEPOSIT_AMOUNT());
		
		Integer rd1=pst1.executeUpdate();
		
		} catch (SQLException e) {
			
			throw new RegistrationException(e);
		} catch (ClassNotFoundException e) {
			
			throw new RegistrationException(e);
		}
		LOG.info("End of  insertDetails method of RegistrationDAO");
		
		return flag;
		
	}
}
