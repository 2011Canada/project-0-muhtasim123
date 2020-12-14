package com.revature.services;

import com.revature.models.Customer;
import com.revature.repositories.CustomerDAO;

public class CustomerServices {
	
	public void createAccount(String username, String password, String firstName, String lastName) {
		
		Customer cus = new Customer(username, password, firstName, lastName);
		
		CustomerDAO cusdao = new CustomerDAO();
		
		cusdao.createAccount(cus);
	}
}
