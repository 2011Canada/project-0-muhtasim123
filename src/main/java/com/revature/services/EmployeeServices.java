package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.repositories.EmployeeDAO;

public class EmployeeServices {
	
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
	}
}
