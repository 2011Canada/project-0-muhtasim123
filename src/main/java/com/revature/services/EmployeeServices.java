package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Account;
import com.revature.models.Transaction;
import com.revature.repositories.EmployeeDAO;

public class EmployeeServices {
	
	TransactionServices ts = new TransactionServices();
	static Logger logger = LogManager.getLogger("com.revature.project0");
	
	public List<Account> allPendingAccounts(){
		
		List<Account> allAccounts = new ArrayList<Account>();
		EmployeeDAO empdao = new EmployeeDAO();
		
		allAccounts = empdao.allPendingAccounts();
		return allAccounts;
	}
	
	
	public void acceptAccount(String account) {
		
		Account acc = new Account();
		acc.setAccountName(account);
		
		EmployeeDAO empdao = new EmployeeDAO();
		
		empdao.acceptAccount(acc);
		
		Transaction t = new Transaction("Account " + account + " has been accepted");
		ts.addTransaction(t);
		
		System.out.println("Account " + account + " has been accepted");
		logger.info("Account " + account + " has been accepted");
	}
	
	public void rejectAccount(String account) {
		
		Account acc = new Account();
		acc.setAccountName(account);
		
		EmployeeDAO empdao = new EmployeeDAO();
		
		empdao.rejectAccount(acc);
		
		Transaction t = new Transaction("Account " + account + " has been rejected");
		ts.addTransaction(t);
		
		System.out.println("Account " + account + " has been rejected");
		logger.info("Account " + account + " has been rejected");
	}
	
	public void viewAllAccounts() {
		
		EmployeeDAO empdao = new EmployeeDAO();
		empdao.viewAllAccounts();
	}
}
