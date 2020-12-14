package com.revature.models;

public class Account {
	
	String accountName;
	int customerId;
	double balance;
	int accountState;
	
	//default
	public Account() {
		super();
	}
	
	public Account(String accountName, int customerId, double balance, int accountState) {
		this.accountName = accountName;
		this.customerId = customerId;
		this.balance = balance;
		this.accountState = accountState;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccountState() {
		return accountState;
	}

	public void setAccountState(int accountState) {
		this.accountState = accountState;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	

}
