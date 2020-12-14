package com.revature.models;

public class Employee extends User {
	public Employee (String username, String password, String firstName, String lastName) {
		super(username, password, lastName, firstName);
	}
	
	//default
	public Employee() {
		super();
	}
}
