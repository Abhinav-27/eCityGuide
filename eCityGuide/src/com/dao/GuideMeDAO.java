package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GuideMeDAO {
	String sql3 = "select id from users where email=?";
	String sql4 = "insert into questions(user_id, title, date_created) values(?, ?, ?)";
	
	public void insert(String email, String question, String date) {
		ConnectDB connect = new ConnectDB();
		Connection con = connect.ConnecttoDB();
		ResultSet rs = null;
		  
		try {
			PreparedStatement ps1 = con.prepareStatement(sql3);
			ps1.setString(1, email);
			rs = ps1.executeQuery();
	
			int user_id=0;
			while(rs.next()) {
			user_id = rs.getInt("id");
			}
			PreparedStatement ps2 = con.prepareStatement(sql4);
			ps2.setInt(1, user_id);
			ps2.setString(2, question);
			ps2.setString(3, date);
			int i = ps2.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
