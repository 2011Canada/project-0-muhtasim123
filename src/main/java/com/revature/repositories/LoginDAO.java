package com.revature.repositories;

import com.revature.models.Customer;
import com.revature.models.Employee;

public class LoginDAO {
	public Customer customerLogin(String username, String password) {
		Customer c = null;
		if (username.equals("muhtasim") && password.equals("soccer")) {
			c.
			return c;
		} else {
			return null;
		}
	}
	
	public Employee employeeLogin(String username, String password) {
		Employee e;
		if (username.equals("muhtasim") && password.equals("soccer")) {
			return e;
		} else {
			return null;
		}
	}
}