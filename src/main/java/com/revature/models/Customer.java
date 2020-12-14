package com.revature.models;

public class Customer extends User{
	private int bankAccount;
	private int customerId;
	
	//for new customer with bank account
	public Customer (String username, String password, String firstName, String lastName, int bankAccount) {
		super(username, password, firstName, lastName);
		this.bankAccount = bankAccount;
	}
	
	//for new customer without bank account
	public Customer (String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
		bankAccount = 0;
	}

	public int getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(int bankAccount) {
		this.bankAccount = bankAccount;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	
}
