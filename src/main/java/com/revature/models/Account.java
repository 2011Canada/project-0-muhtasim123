package com.revature.models;

public class Account {
	
	int customerId;
	double balance;
	int accountState;
	
	public Account(int customerId, double balance, int accountState) {
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
	
	

}
