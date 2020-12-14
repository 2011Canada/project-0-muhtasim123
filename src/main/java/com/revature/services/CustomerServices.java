package com.revature.services;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.repositories.CustomerDAO;

public class CustomerServices {
	
	public void createCustomer(String username, String password, String firstName, String lastName) {
		
		Customer cus = new Customer(username, password, firstName, lastName);
		
		CustomerDAO cusdao = new CustomerDAO();
		
		cusdao.createCustomer(cus);
	}
	
	public void createAccount(String accountName, int customerId, double balance) {
		
		Account acc = new Account(accountName, customerId, balance, 0);
		
		CustomerDAO cusdao = new CustomerDAO();
		cusdao.createAccount(acc);
	}

}
