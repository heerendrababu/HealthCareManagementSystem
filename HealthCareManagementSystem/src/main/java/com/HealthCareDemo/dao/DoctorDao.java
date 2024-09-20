package com.HealthCareDemo.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.HealthCareDemo.model.Doctor;

public class DoctorDao 
{


	    private static String dbUrl = "jdbc:mysql://localhost:3306/practiceproject";
	    private static String dbUsername = "root";
	    private static String dbPassword = "Giri@226";

	    private static Connection cn = null;
	    private static PreparedStatement ps = null;
	    private static Statement st = null;
	    private static ResultSet rs = null;
     
	    public static boolean checkDoctorEmailExists(String email) {
	        boolean exists = false;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            cn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
	            
	            String query = "select demail from Doctor where demail = ?";
	            ps = cn.prepareStatement(query);
	            ps.setString(1, email);
	            rs = ps.executeQuery();

	            if (rs.next()) {
	                exists = true; // Email already exists
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (ps != null) ps.close();
	                if (cn != null) cn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return exists;
	    }

	    // Method to create the table if it does not exist and insert doctor details
	    public static void insertDoctorDetails(Doctor d) {
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
	            ps.setString(1, d.getName());
	            ps.setString(2, d.getDemail());
	            ps.setLong(3, d.getDmob());
	            ps.setString(4, d.getDpass());
	            ps.setString(5, d.getGender());
	            ps.setString(6, d.getDprofess());

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
    public static boolean checkDoctorLogin(String email,String password)
    {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			st = cn.createStatement();
			rs = st.executeQuery("select*from Doctor");
			
			if (rs != null)
			{
				while (rs.next()) 
				{
					/*String dbemail = rs.getString("email");
					String dbpass = rs.getString("password");*/
                             //(or)
					String demail = rs.getString(3);
					String dpass = rs.getString(5);
					if (demail.equals(email) && dpass.equals(password))
					{
						return true; // Admin login success
					}
				}
			}
			
		} 
    	catch (ClassNotFoundException | SQLException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
    	
     }
	}
  
