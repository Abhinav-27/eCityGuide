package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectDB {
	public Connection ConnecttoDB() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/development?verifyServerCertificate=false&useSSL=true", "root", "system");
			System.out.println("Driver Connected");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
