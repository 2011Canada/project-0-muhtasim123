package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Transfers;
import com.revature.util.ConnectionFactory;

public class CustomerDAO {
	
	ConnectionFactory cf = ConnectionFactory.getConnectionFacotry();
	
	public void createCustomer(Customer c) {

		Connection conn = cf.getConnection();

		
		try {
			String sql = "insert into \"customer\" (\"username\", \"password\", \"firstName\", \"lastName\") "
					+ "values (?, ?, ?, ?) "
					+ "returning \"customerId\";";
			
			PreparedStatement insertCustomer = conn.prepareStatement(sql);
			
			insertCustomer.setString(1, c.getUsername());
			insertCustomer.setString(2, c.getPassword());
			insertCustomer.setString(3, c.getFirstName());
			insertCustomer.setString(4, c.getLastName());
			
			ResultSet res = insertCustomer.executeQuery();
			
			if (res.next()) {
				c.setCustomerId(res.getInt("customerId"));
			} else {
				throw new SQLException();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void createAccount(Account a) {
	
		Connection conn = cf.getConnection();
		
		try {
			String sql = "insert into \"account\" (\"accountName\", \"balance\", \"accountState\", \"customerId\") "
					+ "values (?, ?, ?, ?);";
			
			PreparedStatement insertAccount = conn.prepareStatement(sql);
			
			insertAccount.setString(1, a.getAccountName());
			insertAccount.setDouble(2, a.getBalance());
			insertAccount.setInt(3, a.getAccountState());
			insertAccount.setInt(4, a.getCustomerId());
			
			insertAccount.executeUpdate();

			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void viewAccount(Customer c) {
		
		Connection conn = cf.getConnection();
		
		try {
			String sql = "select \"accountName\", \"balance\" from \"account\" where \"customerId\" = '" + c.getCustomerId() + "' and \"accountState\" = 1;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet res = ps.executeQuery();
			
			while (res.next()) {
				System.out.println("Account name: " + res.getString("accountName") + "		Balance: " + res.getDouble("balance"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void depositFunds(Customer c, Account a, double amount) {
		
		Connection conn = cf.getConnection();
		double balance = balance(a);
		double total = balance+amount;
		
		try {
			String sql = "update \"account\" set \"balance\" = " + total + " where \"accountName\" = '" + a.getAccountName() + "';";
			
			Statement depositFunds = conn.createStatement();
			depositFunds.executeUpdate(sql);
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public double balance(Account a) {
		
		double balance = 0;
		
		Connection conn = cf.getConnection();
		
		try {
			String sql = "select \"balance\" from \"account\" where \"accountName\" = '" + a.getAccountName() + "';";
			
			PreparedStatement getBalance = conn.prepareStatement(sql);
			ResultSet res = getBalance.executeQuery();
			
			while (res.next()) {
				balance = res.getDouble("balance");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return balance;
	}
	
	public void withdrawFunds(Customer c, Account a, double amount) {
		
		Connection conn = cf.getConnection();
		double balance = balance(a);
		double total = balance-amount;
		
		try {
			String sql = "update \"account\" set \"balance\" = " + total + " where \"accountName\" = '" + a.getAccountName() + "';";
			
			Statement withdrawFunds = conn.createStatement();
			withdrawFunds.executeUpdate(sql);
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void allBalance(Customer c) {
		
		Connection conn = cf.getConnection();
		
		try {
			String sql = "select \"accountName\", \"balance\" from \"account\" where \"customerId\" = " + c.getCustomerId() + ";";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet res = ps.executeQuery();
			
			while (res.next()) {
				System.out.println("Account name: " + res.getString("accountName") + "		Balance: " + res.getDouble("balance"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void transferFunds(Transfers transfer) {
		
		Connection conn = cf.getConnection();
		
		try {
			String sql = "insert into \"transfer\" (\"accountFrom\", \"accountTo\", \"amount\", \"transferStatus\", \"customerId\") values (?, ?, ?, ?, ?);";
			
			PreparedStatement insertTransfer = conn.prepareStatement(sql);
			
			insertTransfer.setString(1, transfer.getAccountFrom());
			insertTransfer.setString(2, transfer.getAccountTo());
			insertTransfer.setDouble(3, transfer.getAmount());
			insertTransfer.setInt(4, transfer.getTransferStatus());
			insertTransfer.setInt(5, transfer.getCustomerId());
			
			insertTransfer.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void viewTransfers(Customer c) {
		
		Connection conn = cf.getConnection();
		
		try {
			String sql = "select * from \"transfer\" where \"customerId\" = " + c.getCustomerId() + " and \"transferStatus\" = 0;";
			
			PreparedStatement getTransfer = conn.prepareStatement(sql);
			ResultSet res = getTransfer.executeQuery();
			
			while(res.next()) {
				System.out.println("Transfer: " + res.getInt("transferId") + "	From: " + res.getString("accountFrom") + "	To: " + res.getString("accountTo") + "	Amount: " + res.getDouble("amount"));
			}
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void acceptTransfer(Transfers t) {
		
		Connection conn = cf.getConnection();
		
		try {
			String select = "select * from \"transfer\" where \"transferId\" = " + t.getTransferId() + ";";
			
			PreparedStatement ps = conn.prepareStatement(select);
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				t.setAccountFrom(res.getString("accountFrom"));
				t.setAccountTo(res.getString("accountTo"));
				t.setAmount(res.getDouble("amount"));
				t.setCustomerId(res.getInt("customerId"));
			}
			
			Account a = new Account();
			a.setAccountName(t.getAccountFrom());
			Account a2 = new Account();
			a2.setAccountName(t.getAccountTo());
			
			double totalFrom = balance(a) - t.getAmount();
			double totalTo = balance(a2) + t.getAmount();
			
			String accountFrom = "update \"account\" set \"balance\" = " + totalFrom + " where \"accountName\" = '" + t.getAccountFrom() + "';";
			
			String accountTo = "update \"account\" set \"balance\" = " + totalTo + " where \"accountName\" = '" + t.getAccountTo() + "';";
			
			PreparedStatement ps1 = conn.prepareStatement(accountFrom);
			ps1.executeUpdate();
			
			PreparedStatement ps2 = conn.prepareStatement(accountTo);
			ps2.executeUpdate();
			
			String sql = "update \"transfer\" set \"transferStatus\" = 1 where \"transferId\" = " + t.getTransferId() + ";";
			
			PreparedStatement updateTransfer = conn.prepareStatement(sql);
			
			updateTransfer.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
