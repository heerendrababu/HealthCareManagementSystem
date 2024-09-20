package com.HealthCareDemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.HealthCareDemo.model.Doctor;
import com.HealthCareDemo.model.Patient;

public class PatientDao 
{
	  private static String  dbUrl = "jdbc:mysql://localhost:3306/practiceproject";
	    private static String dbUsername = "root";
	    private static String dbPassword = "Giri@226";

	    private static Connection cn = null;
	    private static PreparedStatement ps = null;
	    private static Statement st = null;
	    private static ResultSet rs = null;
	    
	    public static void insertPatientDetails(Patient p) {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            cn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
	            st = cn.createStatement();

	            // Create table if it does not exist
	            String createTableQuery = "create table if not exists doctor(did int primary key auto_increment,name varchar(40),demail varchar(40) unique,"
	            		+ "dmob bigint unique,dpass varchar(40),"
	            		+ "gender varchar(40),dprofess varchar(40))";
	                   
	            st.executeUpdate(createTableQuery);

	            // Insert doctor details
	            String insertQuery = "insert into doctor (name, demail, dmob, dpass, gender, dprofess) VALUES (?, ?, ?, ?, ?, ?)";
	            ps = cn.prepareStatement(insertQuery);

	            // Set values from the Doctor object
	            ps.setString(1, p.getName());
	            ps.setString(2, p.getDemail());
	            ps.setLong(3, p.getDmob());
	            ps.setString(4, p.getDpass());
	            ps.setString(5, p.getGender());
	            ps.setString(6, p.getDprofess());

	            // Execute insert query
	            ps.executeUpdate();

	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        } finally
	        {
	            // Close resources
	            if (ps != null) {
	                try {
	                    ps.close();
	                } catch (SQLException e1) {
	                    e1.printStackTrace();
	                }
	            }
	            if (st != null) {
	                try {
	                    st.close();
	                } catch (SQLException e1) {
	                    e1.printStackTrace();
	                }
	            }
	            if (cn != null) {
	                try {
	                    cn.close();
	                } catch (SQLException e1)
	                {
	                    e1.printStackTrace();
	                }
	            }
	        }
	    }  

  
}
