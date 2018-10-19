package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	
	String sql2 = "select * from users where email=? and password=?";
	public boolean check(String email, String pass) {
		
		ConnectDB connect = new ConnectDB();
		Connection con = connect.ConnecttoDB();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql2);
			ps.setString(1, email);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
