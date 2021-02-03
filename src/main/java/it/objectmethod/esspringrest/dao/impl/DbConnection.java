package it.objectmethod.esspringrest.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	protected Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "omdev", "omdev");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}
}
