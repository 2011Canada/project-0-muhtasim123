package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionFactory;

public class TransactionDAO {
	
	ConnectionFactory cf = ConnectionFactory.getConnectionFacotry();

	public void addTransaction(String transaction){

		Connection conn = cf.getConnection();
		
		try {
			
			String sql = "insert into \"transaction\" (\"transactionText\") values ('" + transaction + "');";
			
			PreparedStatement add = conn.prepareStatement(sql);
			add.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void allTransactions() {
		
		Connection conn = cf.getConnection();
		
		try {
			String sql = "select * from \"transaction\";";
			
			PreparedStatement all = conn.prepareStatement(sql);
			ResultSet res = all.executeQuery();
			
			while(res.next()) {
				System.out.println("Transaction ID: " + res.getInt("transactionId") + "    Transaction: " + res.getString("transactionText"));
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
