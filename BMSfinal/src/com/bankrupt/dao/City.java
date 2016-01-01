package com.bankrupt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashSet;

import java.util.Set;

import org.apache.log4j.Logger;

public class City {
	private static final Logger LOG = Logger.getLogger("City");
	private Set<String>cities = new HashSet<String>();      
	public  City(String Country)   
	    {
		LOG.info("Inside Constructor of City");
		
	 setCities(Country);   
	    
	 LOG.info("end of the City Constructor");
			}   
	public Set<String> getCities() {   
	return cities;   
	    }   
	private void setCities(String Country) { 
		LOG.info("Inside setCities method of City");
		
	if (Country != null)   
	        {   
		try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection	con=DriverManager.getConnection("jdbc:oracle:thin:@10.241.47.160:1521:oracle","training","training");
					PreparedStatement pst=con.prepareStatement("select state from bms_country_state where country=?");
					pst.setString(1, Country);
					ResultSet rs=pst.executeQuery();
					while(rs.next())
					{
						
						cities.add(rs.getString(1));   
					}
					LOG.info("End statement of setCities method of City");
					
				} catch (ClassNotFoundException e) {
					
				}   catch (SQLException e) {
					
				}                
	       }
	           }   
}
