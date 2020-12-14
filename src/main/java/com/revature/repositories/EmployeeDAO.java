package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;

public class EmployeeDAO {

	public List<Account> allPendingAccounts(){
		//write SQL stuff
		//find all accounts where state = 0
		List<Account> allAccounts = new ArrayList<Account>();
		
		Account a1 = new Account();
		Account a2 = new Account();
		
		a1.setAccountName("First Account");
		a1.setAccountState(0);
		a1.setBalance(500);
		a1.setCustomerId(1);
		
		a2.setAccountName("Second Account");
		a2.setAccountState(0);
		a2.setBalance(10000);
		a2.setCustomerId(1);
		
		allAccounts.add(a1);
		allAccounts.add(a2);
		
		return allAccounts;
		
	}
	
	public void acceptAccount(Account a) {
		//write SQL
		//change account status to 1
		
		System.out.println("Account " + a.getAccountName() + " has been approved!");
	}
	
	public void rejectAccount(Account a) {
		//write SQL stuff
		//delete account from accounts table
		
		System.out.println("Account" + a.getAccountName() + " has been rejected!");
	}
	
	public void viewAllAccounts() {
		//write SQL stuff
		//select * from accounts and loop through results and print
		
		//dummy code for test
		
		List<Account> allAccounts = new ArrayList<Account>();
				
		Account a1 = new Account();
		Account a2 = new Account();
		
		a1.setAccountName("First Account");
		a1.setAccountState(0);
		a1.setBalance(500);
		a1.setCustomerId(1);
		
		a2.setAccountName("Second Account");
		a2.setAccountState(0);
		a2.setBalance(10000);
		a2.setCustomerId(1);
		
		allAccounts.add(a1);
		allAccounts.add(a2);
		
		for (int i = 0; i < allAccounts.size(); i++) {
			System.out.println("Account Name: " + allAccounts.get(i).getAccountName() +
					"	Account Balance: " + allAccounts.get(i).getBalance() +
					"	Customer ID: " + allAccounts.get(i).getCustomerId());
		}
	}

}
