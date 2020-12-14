package com.revature.services;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Transaction;
import com.revature.models.Transfers;
import com.revature.repositories.CustomerDAO;

public class CustomerServices {
	
	TransactionServices ts = new TransactionServices();
	
	public void createCustomer(String username, String password, String firstName, String lastName) {
		
		Customer cus = new Customer(username, password, firstName, lastName);
		
		CustomerDAO cusdao = new CustomerDAO();
		
		cusdao.createCustomer(cus);
		
		Transaction t = new Transaction("Customer login created for " + cus.getFirstName() + " " + cus.getLastName());
		ts.addTransaction(t);
		

	}
	
	public void createAccount(String accountName, int customerId, double balance) {
		
		Account acc = new Account(accountName, customerId, balance, 0);
		
		CustomerDAO cusdao = new CustomerDAO();
		cusdao.createAccount(acc);
		
		Transaction t = new Transaction("Account " + acc.getAccountName() + " created for " + acc.getCustomerId());
		ts.addTransaction(t);
	}

	public void viewAccount(Customer c) {
		CustomerDAO cusdao = new CustomerDAO();
		cusdao.viewAccount(c);
	}
	
	public void depositFunds(Customer c, double amount, String account) {
		
		CustomerDAO cusdao = new CustomerDAO();
		Account acc = new Account();
		acc.setAccountName(account);
		
		cusdao.depositFunds(c, acc, amount);
		
		Transaction t = new Transaction("$" + amount + " deposited into account " + account + " for customer " + c.getCustomerId());
		ts.addTransaction(t);
	}
	
	public double balance(Customer c, String account) {
		
		double balance = 0;
		
		CustomerDAO cusdao = new CustomerDAO();
		Account acc = new Account();
		
		acc.setAccountName(account);
		balance = cusdao.balance(acc);
		
		return balance;
	}
	
	public void withdrawFunds(Customer c, double amount, String account) {
		
		CustomerDAO cusdao = new CustomerDAO();
		Account acc = new Account();
		
		acc.setAccountName(account);
	
		cusdao.withdrawFunds(c, acc, amount);
		
		Transaction t = new Transaction("$" + amount + " withdrawn into account " + account + " for customer " + c.getCustomerId());
		ts.addTransaction(t);
	}
	
	public void allBalance(Customer c) {
		
		CustomerDAO cusdao = new CustomerDAO();
		cusdao.allBalance(c);
	}
	
	public void transferFunds(Customer c, String accountFrom, String accountTo, double amount) {
		//Account accFrom = new Account();
		//Account accTo = new Account();
		CustomerDAO cusdao = new CustomerDAO();
		
		Transfers transfer  = new Transfers();
		transfer.setAccountFrom(accountFrom);
		transfer.setAccountTo(accountTo);
		transfer.setAmount(amount);
		transfer.setTransferStatus(0);
		transfer.setCustomerId(c.getCustomerId());
		cusdao.transferFunds(transfer);
		
		Transaction t = new Transaction("$" + amount + " transfered from account " + accountFrom + " to account " + accountTo);
		ts.addTransaction(t);
		
	}
	
	public void viewTransfers(Customer c) {
		CustomerDAO cusdao = new CustomerDAO();
		
		cusdao.viewTransfers(c);
	}
	
	public void acceptTransfer(int transferId) {
		Transfers transfer = new Transfers();
		transfer.setTransferId(transferId);
		
		CustomerDAO cusdao = new CustomerDAO();
		cusdao.acceptTransfer(transfer);
	}

}
