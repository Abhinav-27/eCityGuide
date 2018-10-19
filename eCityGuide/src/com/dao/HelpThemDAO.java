package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelpThemDAO {

	String sql5 = "select id from users where email=?";
	String sql6 = "insert into answers(user_id, question_id, answer_text, date_created) values(?, ?, ?, ?)";
	
	public void insert(String email, int question_id, String answer, String date) {
		ConnectDB connect = new ConnectDB();
		Connection con = connect.ConnecttoDB();
		ResultSet rs = null;
		
		try {
			PreparedStatement ps1 = con.prepareStatement(sql5);
			ps1.setString(1, email);
			rs = ps1.executeQuery();
			
			int user_id=0;
			while(rs.next()) {
			user_id = rs.getInt("id");
			}
			
			PreparedStatement ps2 = con.prepareStatement(sql6);
			ps2.setInt(1, user_id);
			ps2.setInt(2, question_id);
			ps2.setString(3, answer);
			ps2.setString(4, date);
			
			int i = ps2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
