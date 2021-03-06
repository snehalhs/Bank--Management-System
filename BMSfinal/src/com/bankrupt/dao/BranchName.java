package com.bankrupt.dao;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	import java.util.HashSet;

import java.util.Set;

import org.apache.log4j.Logger;

	public class BranchName { 
		private static final Logger LOG = Logger.getLogger("BranchName");
	private Set<String> branch = new HashSet<String>();   
	public BranchName() {
		// TODO Auto-generated constructor stub
		LOG.info("Inside Constructor of BranchName");
		
	    
	    	try {
	    	Class.forName("oracle.jdbc.driver.OracleDriver");
	    	Connection	con=DriverManager.getConnection("jdbc:oracle:thin:@10.241.47.160:1521:oracle","training","training");
	    	String query = "select branch_name from bms_branch_code";
	    	PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
				
					branch.add(rs.getString(1));   
				}
				LOG.info("end of the BranchName Constructor");
				
			} catch (ClassNotFoundException e) {
				
			}   catch (SQLException e) {
				
			}                

	    
	
	}
	public Set<String> getBranchName() {
		
		return branch;
	}
	
}
