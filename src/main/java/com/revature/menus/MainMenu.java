package com.revature.menus;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.repositories.LoginDAO;
import com.revature.services.CustomerServices;
import com.revature.services.EmployeeServices;
import com.revature.services.TransactionServices;

public class MainMenu {
	
	static int menuState = 0;
	static Logger logger = LogManager.getLogger("com.revature.project0");
	Scanner in = new Scanner(System.in);

	public void firstMenu() {	  
		int choice = 0;
		System.out.println("Select one of the menu option: \n" +
				  "	1 - Login as Customer\n" +
				  "	2 - Login as Employee\n" +
				  "	3 - Create new Customer\n" + 
				  "	4 - Close Application\n");
		
		try {
			choice = in.nextInt();
			if (choice <= 0 || choice > 4) {
				System.out.println("\n\nPlease enter a valid option: \n");
				firstMenu();
			}
		} catch (InputMismatchException e) {
			System.out.println("\n\nPlease enter a valid option: \n");
			firstMenu();
		}
		
		switch(choice) {
			case 1:
				System.out.println("\n\n-----Customer Login-----");
				customerLogin();
				break;
			case 2:
				System.out.println("\n\n-----Employee Login-----");
				employeeLogin();
				break;
			case 3:
				System.out.println("\n\n-----Create New Customer Account------");
				newCustomer();
				break;
			case 4:
				System.out.println("\n\nThank you for using the Bank Application!");
				System.exit(0);
		}
		 
	}
	
	public void customerLogin() {
		
		String username = "";
		String password = "";
		
		System.out.print("Enter username:");
		in.nextLine(); //dummy input 
		username = in.nextLine();

		System.out.print("Enter password:");
		password = in.nextLine();
		
		LoginDAO cusLogin = new LoginDAO();
		
		Customer cus = cusLogin.customerLogin(username, password);
		
		if (cus != null) {
			System.out.println("\n\nLogin Successful!");
			System.out.println("\n\n-----Customer Menu!-----");
			customerMenu(cus);
		} else {
			System.out.println("\n\nLogin credentials incorrect, please try again\n");
			customerLogin();
		}
	}
	
	public void employeeLogin() {
		
		String username = "";
		String password = "";
		
		System.out.print("Enter username:");
		in.nextLine(); //dummy input 
		username = in.nextLine();

		System.out.print("Enter password:");
		password = in.nextLine();
		
		LoginDAO empLogin = new LoginDAO();
		
		Employee emp = empLogin.employeeLogin(username, password);
		
		if (emp != null) {
			System.out.println("\n\nLogin Successful!");
			System.out.println("\n\n-----Employee Menu!-----");
			employeeMenu(emp);
		} else {
			System.out.println("\n\nLogin credentials incorrect, please try again\n");
			employeeLogin();
		}
	}
	
	public void newCustomer() {
		
		in.nextLine();
		
		System.out.print("Enter first name: ");
		String firstName = in.nextLine();
		
		System.out.print("Enter last name: ");
		String lastName = in.nextLine();
		
		System.out.print("Enter username: ");
		String username = in.nextLine();
		
		System.out.print("Enter paswsword: ");
		String password = in.nextLine();
		
		CustomerServices cs = new CustomerServices();
		cs.createCustomer(username, password, firstName, lastName);
		
		System.out.println("\n\n\n");
		firstMenu();
	}
	
	public void customerMenu(Customer c) {
		
		int choice = 0;
		System.out.println("\nHello " + c.getFirstName() + " " + c.getLastName() + "!");
		
		System.out.println("\nSelect one of the options below: " +
				"\n	1 - Apply for a new account" +
				"\n	2 - Deposit Funds" +
				"\n	3 - Withdraw Funds" +
				"\n	4 - View Balance" +
				"\n	5 - Transfer Funds" +
				"\n	6 - View Pending Transfers" +
				"\n	7 - Logout");
		
		try {
			choice = in.nextInt();
			if (choice <= 0 || choice > 7) {
				System.out.println("\n\nPlease select a valid option: \n");
				customerMenu(c);
			}
		} catch (InputMismatchException e) {
			System.out.println("\n\nPlease select a valid option: \n");
			customerMenu(c);
		}
		
		switch(choice) {
			case 1:
				System.out.println("\n-----New Account-----\n");
				newAccountMenu(c);
				break;
			case 2:
				System.out.println("\n-----Deposit Funds-----\n");
				depositFunds(c);
				break;
			case 3:
				System.out.println("\n-----Withdraw Funds-----\n");
				withdrawFunds(c);
				break;
			case 4:
				System.out.println("\n-----View Balance-----\n");
				viewBalance(c);
				break;
			case 5:
				System.out.println("\n-----Transfer Funds-----\n");
				transferFunds(c);
				break;
			case 6:
				System.out.println("\n-----View Pending Transfer-----\n");
				pendingTransfer(c);
				break;
			case 7:
				System.out.println("\n-----Logged out!-----\n");
				firstMenu();
		}
		
	}
	
	public void newAccountMenu(Customer c) {
		
		in.nextLine();
		
		System.out.println("Emter account name: ");
		String accountName = in.nextLine();
		
		System.out.println("Enter starting balance: ");
		double balance = in.nextDouble();
		
		int customerId = c.getCustomerId();
		
		CustomerServices cs = new CustomerServices();
		cs.createAccount(accountName, customerId, balance);
		
		customerMenu(c);
	}
	
	public void depositFunds(Customer c) {
		
		CustomerServices cs = new CustomerServices();
		
		cs.viewAccount(c);
		
		in.nextLine();
		
		System.out.print("\n\nEnter the account name: ");
		String accountName = in.nextLine();
		
		System.out.print("Enter deposit amount: ");
		double amount = in.nextDouble();
		
		if (amount > 0) {
			cs.depositFunds(c, amount, accountName);
			customerMenu(c);
		} else {
			System.out.println("\nCannot deposit negative amount!\n\n");
			depositFunds(c);
		}
		
	}
	
	public void withdrawFunds(Customer c) {
		
		CustomerServices cs = new CustomerServices();
		
		cs.viewAccount(c);
		
		in.nextLine();
		
		System.out.print("\n\nEnter the account name: ");
		String accountName = in.nextLine();
		
		System.out.print("Enter withdrawal amount: ");
		double amount = in.nextDouble();
		
		double balance = cs.balance(c, accountName);
		
		if (amount > balance) {
			System.out.println("There is not enough funds in this account\n\n");
			withdrawFunds(c);
		} else if (amount < 0) {
			System.out.println("\nCannot withdraw negative amount!\n\n");
			withdrawFunds(c);
		} else {
			cs.withdrawFunds(c, amount, accountName);
			customerMenu(c);
		}
	}
	
	public void viewBalance(Customer c) {
		
		CustomerServices cs = new CustomerServices();
		
		cs.allBalance(c);
		
		System.out.println("\n\n\n");
		
		customerMenu(c);
	}
	
	public void transferFunds(Customer c) {
		
		CustomerServices cs = new CustomerServices();
		
		cs.viewAccount(c);
		
		in.nextLine(); 
		
		System.out.print("Select account to transfer from: ");
		String accountFrom = in.nextLine();
		
		System.out.print("Enter account name to transfer to: ");
		String accountTo = in.nextLine();
		
		System.out.print("Enter amount to transfer: ");
		double amount = in.nextDouble();
		
		double balance = cs.balance(c, accountFrom);
		
		if (amount > balance) {
			System.out.println("There is not enough funds in this account\n\n");
			customerMenu(c);
		} else {
			cs.transferFunds(c, accountFrom, accountTo, amount);
			customerMenu(c);
		}
		
	}
	
	public void pendingTransfer(Customer c) {
		
		CustomerServices cs = new CustomerServices();
		
		cs.viewTransfers(c);
		
		System.out.print("\n\nSelect transfer to accept: ");
		int transferId = in.nextInt();
		
		cs.acceptTransfer(transferId);
		
		customerMenu(c);
		
	}
	
	public void employeeMenu(Employee e) {
		
		int choice = 0;
		System.out.println("\nHello " + e.getFirstName() + " " + e.getLastName() + "!");
		
		System.out.println("\nSelect one of the options below: " +
				"\n	1 - Approve Accounts" +
				"\n	2 - Reject Accounts" +
				"\n	3 - View All Accounts" +
				"\n	4 - View All Transactions" +
				"\n	5 - Logout");
		
		try {
			choice = in.nextInt();
			if (choice <= 0 || choice > 5) {
				System.out.println("\n\nPlease select a valid option: \n");
				employeeMenu(e);
			}
		} catch (InputMismatchException ex) {
			System.out.println("\n\nPlease select a valid option: \n");
			employeeMenu(e);
		}
		
		switch(choice) {
			case 1:
				System.out.println("\n-----Approve Accounts-----\n");
				approveAccount(e);
				break;
			case 2:
				System.out.println("\n-----Reject Accounts-----\n");
				rejectAccount(e);
			case 3:
				System.out.println("\n-----View All Accounts-----\n");
				viewAllAccounts(e);
				break;
			case 4:
				System.out.println("\n-----View All Transactions-----\n");
				viewAllTransactions(e);
				break;
			case 5:
				System.out.println("\n-----Logged Out-----\n");
				firstMenu();
		}
	}
	
	public void approveAccount(Employee e) {
		
		EmployeeServices es = new EmployeeServices();
		List<Account> allPendingAccounts = new ArrayList<Account>();
		
		List<String> accountNames = new ArrayList<>();
		
		allPendingAccounts = es.allPendingAccounts();
		
		for (int i = 0; i < allPendingAccounts.size(); i++) {
			System.out.println("Account Name: " + allPendingAccounts.get(i).getAccountName() +
					"	Account Balance: " + allPendingAccounts.get(i).getBalance() +
					"	Customer ID: " + allPendingAccounts.get(i).getCustomerId());
			
			String accountName = allPendingAccounts.get(i).getAccountName();
			accountNames.add(accountName);
		}
		
		System.out.println("\n\n\n");
		
		in.nextLine();
		
		System.out.print("Enter account name to approve: ");
		String account = in.nextLine();
		
		for (int i = 0; i < accountNames.size(); i++) {
			if (accountNames.get(i).contentEquals(account)) {
				es.acceptAccount(account);
				employeeMenu(e);
			}
		}
		
		System.out.println("\n\nInvalid selection!\n\n\n");
		approveAccount(e);
	}
	
	public void rejectAccount(Employee e) {
		
		EmployeeServices es = new EmployeeServices();
		List<Account> allPendingAccounts = new ArrayList<Account>();
		
		List<String> accountNames = new ArrayList<>();
		
		allPendingAccounts = es.allPendingAccounts();
		
		for (int i = 0; i < allPendingAccounts.size(); i++) {
			System.out.println("Account Name: " + allPendingAccounts.get(i).getAccountName() +
					"	Account Balance: " + allPendingAccounts.get(i).getBalance() +
					"	Customer ID: " + allPendingAccounts.get(i).getCustomerId());
			
			String accountName = allPendingAccounts.get(i).getAccountName();
			accountNames.add(accountName);
		}
		
		System.out.println("\n\n\n");
		
		in.nextLine();
		
		System.out.print("Enter account name to reject: ");
		String account = in.nextLine();
		
		for (int i = 0; i < accountNames.size(); i++) {
			if (accountNames.get(i).contentEquals(account)) {
				es.rejectAccount(account);
				employeeMenu(e);
			}
		}
		System.out.println("\n\nInvalid selection!\n\n\n");
		rejectAccount(e);
	}
	
	public void viewAllAccounts(Employee e) {
		
		EmployeeServices es = new EmployeeServices();
		es.viewAllAccounts();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		employeeMenu(e);
		
	}
	
	public void viewAllTransactions(Employee e) {
	
		TransactionServices ts = new TransactionServices();
		ts.allTransactions();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		employeeMenu(e);
	}
}





