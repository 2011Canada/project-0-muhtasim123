package com.revature.menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.repositories.LoginDAO;
import com.revature.services.CustomerServices;

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
				"\n	6 - View Pending Transfers");
		
		try {
			choice = in.nextInt();
			if (choice <= 0 || choice > 6) {
				System.out.println("\n\nPlease select a valid option: \n");
				customerMenu(c);
			}
		} catch (InputMismatchException e) {
			System.out.println("\n\nPlease select a valid option: \n");
			customerMenu(c);
		}
		
		switch(choice) {
			case 1:
				System.out.println("\n-----New Account-----");
				newAccountMenu(c);
				break;
			case 2:
				System.out.println("2");
				break;
			case 3:
				System.out.println("3");
				break;
			case 4:
				System.out.println("4");
				break;
			case 5:
				System.out.println("5");
				break;
			case 6:
				System.out.println("6");
				break;
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
	
	public void employeeMenu(Employee e) {
		
	}
}





