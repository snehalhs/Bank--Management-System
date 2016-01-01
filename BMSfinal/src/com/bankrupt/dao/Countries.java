package com.bankrupt.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashSet;

import java.util.Set;

import org.apache.log4j.Logger;

public class Countries {   
	private static final Logger LOG = Logger.getLogger("Countries");
private Set<String>countries = new HashSet<String>();   
public Countries()   
    {
	LOG.info("Inside Constructor of Countries");
	
	try {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection	con=DriverManager.getConnection("jdbc:oracle:thin:@10.241.47.160:1521:oracle","training","training");
    	String query = "select country from bms_country_state";
    	PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
			
				countries.add(rs.getString(1));   
			}
			LOG.info("end of the Countries Constructor");
			
		} catch (ClassNotFoundException e) {
			
		}   catch (SQLException e) {
			
		}                

    }  
public Set<String> getCountries() {   
	return countries;   
	    } 
}
