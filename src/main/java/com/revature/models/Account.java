package com.revature.models;

public class Account {
	
	int customerId;
	double balance;
	int accountState;
	
	public Account() {
		this.customerId = 0;
		this.balance = 0;
		this.accountState = 0;
	}
	
	public Account(int customerId, double balance, int accountState) {
		this.customerId = customerId;
		this.balance = balance;
		this.accountState = accountState;
	}

}
