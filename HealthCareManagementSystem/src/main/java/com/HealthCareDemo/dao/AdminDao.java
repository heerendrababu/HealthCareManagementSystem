package com.HealthCareDemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDao 
{
	private static String dbUrl = "jdbc:mysql://localhost:3306/practiceproject";
	private static String dbUsername = "root";
	private static String dbPassword = "Giri@226";

	private static Connection cn = null;
	private static PreparedStatement ps = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	// (1) Check if admin login details are correct
	public static boolean checkAdminLogin(String e, String p) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from admin");

			if (rs != null)
			{
				while (rs.next()) 
				{
					String dbemail = rs.getString(2);
					String dbpass = rs.getString(3);
					if (dbemail.equals(e) && dbpass.equals(p))
					{
						return true; // Admin login success
					}
				}
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return false; // Admin login failure
	}

	// (1) Check if doctor email already exists
    public static boolean checkDoctorEmailExists(String email) {
        boolean exists = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            
            String query = "select demail from DocVerify where demail = ?";
            ps = cn.prepareStatement(query);
            ps.setString(1, email); // `email` is the method parameter
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
    

    // (2) Insert doctor details into the database
    public static void insertDoctorVerifyDetails(String name, String email)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            
         // Ensure the DocVerify table exists before inserting data
            String createTableSQL = "create table if not exists DocVerify ("
                    + "did int primary key auto_increment, "
                    + "dname varchar(40) not null, "
                    + "demail varchar(40) not null unique)";
            st = cn.createStatement();
            st.executeUpdate(createTableSQL);
            
         // Insert doctor details
            String query = "insert into DocVerify (dname, demail) values (?, ?)";
            ps = cn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

