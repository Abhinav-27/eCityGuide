package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationDAO {
	
	String sql1 = "insert into users(fname, lname, mob, email, password, date_created) values(?, ?, ?, ?, ?, ?)"; 
	
	public void insert(String fname, String lname, String mob, String email, String pass, String date) {
		ConnectDB connect = new ConnectDB();
		Connection con = connect.ConnecttoDB();
		try {
			PreparedStatement ps = con.prepareStatement(sql1);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, mob);
			ps.setString(4, email);
			ps.setString(5, pass);
			ps.setString(6, date);
			int i = ps.executeUpdate(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
