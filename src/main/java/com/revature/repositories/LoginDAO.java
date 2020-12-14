package com.revature.repositories;

import com.revature.models.Customer;
import com.revature.models.Employee;

public class LoginDAO {
	public Customer customerLogin(String username, String password) {
		Customer c = new Customer();
		if (username.equals("muhtasim") && password.equals("soccer")) {
			c.setFirstName("muhtasim");
			c.setLastName("customer");
			c.setUsername(username);
			c.setPassword(password);
			c.setCustomerId(1);
			return c;
		} else {
			return null;
		}
	}
	
	public Employee employeeLogin(String username, String password) {
		Employee e = new Employee();
		if (username.equals("muhtasim") && password.equals("soccer")) {
			e.setFirstName("muhtasim");
			e.setLastName("employee");
			e.setUsername(username);
			e.setPassword(password);
			return e;
		} else {
			return null;
		}
	}
}