package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static ConnectionFactory cf = new ConnectionFactory(1);
	
	public static ConnectionFactory getConnectionFacotry() {
		return cf;
	}
	
	private Connection [] conn;
	
	private ConnectionFactory(int numberOfConnections) {
		
		String url = "jdbc:postgresql://revature-db.cfdbjt00wi4b.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=bankapp";
		String user = "postgres";
		String password = "Soccer123!";
		try {
			this.conn = new Connection[numberOfConnections];
			for (int i = 0; i < this.conn.length; i++) {
				Connection conn = DriverManager.getConnection(url, user, password);
				this.conn[i] = conn;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return this.conn[0];
	}

}
