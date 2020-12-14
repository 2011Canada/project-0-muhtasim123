package com.revature.repositories;

import java.util.Random;

import com.revature.models.Account;
import com.revature.models.Customer;

public class CustomerDAO {
	
	public void createCustomer(Customer c) {
		int userid = 0;
		
		System.out.println("\n\nAccount for " + c.getFirstName() + " " + c.getLastName() + " is created");
	
		Random rand = new Random();
		userid = rand.nextInt();
		System.out.println(userid);
		c.setCustomerId(userid);
	}
	
	public void createAccount(Account a) {

		System.out.println("Account created '" + a.getAccountName() + "'");
	}
}
