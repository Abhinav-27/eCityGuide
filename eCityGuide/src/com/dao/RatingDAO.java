package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RatingDAO {
	
	String sql7 = "select id from users where email=? ";
	String sql8 = "select q.id from questions q, answers a  where q.id = a.question_id and a.id = ?";
	String sql9 = "insert into rating(user_id, question_id, answer_id, rating, date_created) values(?, ?, ?, ?, ?)";
	public void insert(String email, int answer_id, String rating, String date) {
		ConnectDB connect = new ConnectDB();
		Connection con = connect.ConnecttoDB();
		ResultSet rs = null;
		
		try {
			PreparedStatement ps1 = con.prepareStatement(sql7);
			ps1.setString(1, email);
			rs = ps1.executeQuery();
			
			int user_id =0;
			while(rs.next()) {
				user_id = rs.getInt("id");
			}
			System.out.println("user_id:::::::::::::::::::"+user_id);
			PreparedStatement ps2 = con.prepareStatement(sql8);
			ps2.setInt(1, answer_id);
			rs = ps2.executeQuery();
			
			int question_id =0;
			while(rs.next()) {
				question_id = rs.getInt("id");
			}
			System.out.println("question_id::::::::::::::::::::::"+question_id);
			PreparedStatement ps3 = con.prepareStatement(sql9);
			ps3.setInt(1, user_id);
			ps3.setInt(2, question_id);
			ps3.setInt(3, answer_id);
			ps3.setString(4, rating);
			ps3.setString(5, date);
			int i = ps3.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
