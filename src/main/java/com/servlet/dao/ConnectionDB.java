package com.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	public static Connection getConection() {
		Connection connection = null;
		try {
			String url = "jdbc:mysql://localhost:3306/user_ltw";
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,"root","");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Loi ket noi DBMS " + e.getMessage());
		}
		
		return connection;
	}
}
