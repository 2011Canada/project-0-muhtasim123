package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		//write SQL stuff
		//int customerId = c.getCustomerId();
		System.out.println("muhtasim");
	}
	
	public void depositFunds(Customer c, Account a, double amount) {
		//write SQL stuff
		System.out.println("$" + amount + " deposited in account " + a.getAccountName());
	}
	
	public double balance(Account a) {
		//write SQL stuff
		double balance = 500;
		return balance;
	}
	
	public void withdrawFunds(Customer c, Account a, double amount) {
		//write SQL stuff
		System.out.println("$" + amount + " withdrawn from account " + a.getAccountName());
	}
	
	public void allBalance(Customer c) {
		//write SQL stuff
		System.out.println("Account: muhtasim		Balance: $500");
	}
	
	public void transferFunds(Transfers transfer) {
		//write SQL stuff
		//remember to include a transfer status in the query
		System.out.println("$" + transfer.getAmount() + " transfered from " + transfer.getAccountFrom() + " to " + transfer.getAccountTo());
	}
	
	public void viewTransfers(Customer c) {
		//write SQL stuff
		//select * by customerId and loop through results then print
		System.out.println("Transfer Pending");
	}
	
	public void acceptTransfer(Transfers t) {
		//write SQL stuff
		//accept transfer according to the transfer id
	}
}
