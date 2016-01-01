package com.bankrupt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bankrupt.exception.SearchBusinessException;
import com.bankrupt.exception.SearchException;
import com.bankrupt.vo.UpdateVo;



public class UpdateSearchDAO {
	private static final Logger LOG = Logger.getLogger("UpdateSearchDAO");
	private java.sql.Connection getConnection()throws SQLException, ClassNotFoundException
	{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection	con=DriverManager.getConnection("jdbc:oracle:thin:@10.241.47.160:1521:oracle","training","training");
		
		return con;
	}
	
	public boolean searchDetailsdao(String customer_id) throws SearchBusinessException,SearchException{
		Connection con = null;
		
		boolean flag=false;
		try{		
			int count=0;
			
			con=getConnection();			
			String q="select * from bms_customer_details1 where CUSTOMER_ID=?";
			PreparedStatement pst1=con.prepareStatement(q);		
			pst1.setString(1, customer_id);				
			ResultSet rs1=pst1.executeQuery();
			while(rs1.next())
			{
				count++;
			}
			if(count>0){
				flag=true;
			}		
		
			
		}catch (ClassNotFoundException e) {
				throw new SearchBusinessException(e) ;
		}catch (SQLException e) {
				throw new SearchBusinessException(e) ;
		}
			
		return flag;
	}
	
	public UpdateVo displayDetails(String CUSTOMER_ID)throws SearchBusinessException,SearchException
	{
		Connection con=null;
		
		UpdateVo to=new UpdateVo();
		try{			
			con=getConnection();			
			String customer_id=CUSTOMER_ID;	
			String query="select CUSTOMER_ID,NAME,ACCOUNT_NUMBER,COUNTRY,STATE,GENDER,DOB,REG_DATE,BRANCH_NAME,ID_PROOF_TYPE,ID_DOC_NO,REF_HOLDER_NAME,REF_ACC_NO,REF_ADDRESS,ADDRESS,CONTACT_NUMBER,EMAIL,MARITAL_STATUS,ACC_TYPE,CITIZENSHIP,CITIZEN_STATUS,GUARDIAN_TYPE,GUARDIAN_NAME from bms_customer_details1 where CUSTOMER_ID=?";
			PreparedStatement pst1=con.prepareStatement(query);
			pst1.setString(1, customer_id);			
			ResultSet rs1=pst1.executeQuery();			
			while(rs1.next())
			{		
				to.setCUSTOMER_ID(rs1.getString(1));
				to.setNAME(rs1.getString(2));
				to.setACCOUNT_NUMBER(rs1.getString(3));
				to.setCOUNTRY(rs1.getString(4));
				to.setSTATE(rs1.getString(5));
				to.setGENDER(rs1.getString(6));
				to.setDOB(rs1.getString(7));
				to.setREG_DATE(rs1.getString(8));
				//to.setBank_name(bank_name);
				to.setBRANCH_NAME(rs1.getString(9));
				//to.setIfsc_code(ifsc_code);
				to.setID_PROOF_TYPE(rs1.getString(10));
				to.setID_DOC_NO(rs1.getString(11));
				to.setREF_HOLDER_NAME(rs1.getString(12));
				to.setREF_ACC_NO(rs1.getString(13));
				to.setREF_ADDRESS(rs1.getString(14));
				to.setADDRESS(rs1.getString(15));
				to.setCONTACT_NUMBER(rs1.getString(16));
				to.setEMAIL(rs1.getString(17));
				to.setMARITAL_STATUS(rs1.getString(18));
				to.setACC_TYPE(rs1.getString(19));
				to.setCITIZENSHIP(rs1.getString(20));
				to.setCITIZEN_STATUS(rs1.getString(21));
				to.setGUARDIAN_TYPE(rs1.getString(22));
				to.setGUARDIAN_NAME(rs1.getString(23));
					
			}
						
		}catch ( ClassNotFoundException e) {			
			//cuLogger.error("Exception Object in displayDetails Method:"+e);
			throw new SearchException(e); 
		}catch (SQLException e) {			
			//cuLogger.error("Exception Object in displayDetails Method:"+e);			
			throw new SearchException(e);
		}
		
		//cuLogger.info("Data Obtained from displayDetails in CustomerUpdateDAO :"+to);
		return to;		
		}
	
	public boolean updateCustomer(UpdateVo to) throws SearchBusinessException,SearchException{
		boolean flag=false;
		Connection con=null;
		//cuLogger.info("Method updateCustomer Invoked in CustomerUpdateDAO" + to);	
		try{
			con=getConnection();
			//cuLogger.debug("We got Connection in registerUser Method");
			//String customer_id=Integer.toString(to.getCustomer_id());
			String query="update bms_customer_details1 set ADDRESS=?,CONTACT_NUMBER=?,EMAIL=?,MARITAL_STATUS=?,ACC_TYPE=?,CITIZENSHIP=?,CITIZEN_STATUS=?,GUARDIAN_TYPE=?,GUARDIAN_NAME=? where CUSTOMER_ID=?";
			PreparedStatement pst=con.prepareStatement(query);			
			//cuLogger.debug("PreparedStatement Object Created");
			
			pst.setString(1,to.getADDRESS());
			pst.setString(2,to.getCONTACT_NUMBER());
			pst.setString(3,to.getEMAIL());
			pst.setString(4,to.getMARITAL_STATUS());
			pst.setString(5,to.getACC_TYPE());
			pst.setString(6,to.getCITIZENSHIP());
			pst.setString(7,to.getCITIZEN_STATUS());
			pst.setString(8,to.getGUARDIAN_TYPE());
			pst.setString(9,to.getGUARDIAN_NAME());
			pst.setString(10,to.getCUSTOMER_ID());
						
			//cuLogger.debug("Values setted to PreparedStatement Object");
			int i=pst.executeUpdate();		
			//cuLogger.info("Return value of executeUpdate Method: "+i);
			if(i>0)
			{
				flag=true;
			}
		}
		catch (ClassNotFoundException e) 
		{
			//cuLogger.error("Exception Object in updateCustomer Method:"+e);
			throw new SearchBusinessException(e);
		}
		catch (SQLException e) 
		{
			//cuLogger.error("Exception Object in updateCustomer Method:"+e);
			throw new SearchException(e);
		}
		
		//cuLogger.info("Returned Value of flag inside updateCustomer in DAO: "+flag);		
		return flag;
	}	
	
	
	
}
