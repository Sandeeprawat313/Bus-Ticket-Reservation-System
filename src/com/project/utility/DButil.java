package com.project.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
	
	public static Connection provideConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/web20sb101db";
		
		try {
			conn = DriverManager.getConnection(url, "root", "8860578502");
			
			if(conn!=null)
				System.out.println("Connection established.........................");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
	public static void main(String[] args) {
		DButil.provideConnection();
	}
	
}
