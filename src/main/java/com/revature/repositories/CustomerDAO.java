package com.revature.repositories;

import java.util.Random;

import com.revature.models.Account;
import com.revature.models.Customer;

public class CustomerDAO {
	
	public void createCustomer(Customer c) {
		//write SQL stuff
		int userid = 0;
		
		System.out.println("\n\nAccount for " + c.getFirstName() + " " + c.getLastName() + " is created");
	
		Random rand = new Random();
		userid = rand.nextInt();
		System.out.println(userid);
		c.setCustomerId(userid);
	}
	
	public void createAccount(Account a) {
		//write SQL stuff
		System.out.println("Account created '" + a.getAccountName() + "'");
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
}
