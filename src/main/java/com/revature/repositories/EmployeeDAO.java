package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.util.ConnectionFactory;

public class EmployeeDAO {
	
	ConnectionFactory cf = ConnectionFactory.getConnectionFacotry();

	public List<Account> allPendingAccounts(){

		List<Account> allAccounts = new ArrayList<Account>();
		
		Connection conn = cf.getConnection();
		
		try {
			String sql = "select * from \"account\" where \"accountState\" = 0";
			
			PreparedStatement showPending = conn.prepareStatement(sql);
			ResultSet res = showPending.executeQuery();
			
			while(res.next()) {
				Account a = new Account();
				a.setAccountName(res.getString("accountName"));
				a.setBalance(res.getDouble("balance"));
				a.setCustomerId(res.getInt("customerId"));
				
				allAccounts.add(a);
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return allAccounts;
		
	}
	
	public void acceptAccount(Account a) {
		
		Connection conn = cf.getConnection();
		
		
		try {
			String sql = "update \"account\" set \"accountState\" = 1 where \"accountName\" = '" + a.getAccountName() + "';";
			
			PreparedStatement approve = conn.prepareStatement(sql);
			approve.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void rejectAccount(Account a) {
		
		Connection conn = cf.getConnection();
		
		
		try {
			String sql = "delete from \"account\" where \"accountName\" = '" + a.getAccountName() + "';";
			
			PreparedStatement reject = conn.prepareStatement(sql);
			reject.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void viewAllAccounts() {
		
		Connection conn = cf.getConnection();
		
		try {
			String sql = "select * from \"account\"";
			
			PreparedStatement showAll = conn.prepareStatement(sql);
			ResultSet res = showAll.executeQuery();
			
			while(res.next()) {
				System.out.println("Account Name: " + res.getString("accountName") +
						"	Account Balance: " + res.getDouble("balance") +
						"	Customer ID: " + res.getInt("customerId"));
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
