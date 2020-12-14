package com.revature.menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
		
		int loginAttempt = cusLogin.customerLogin(username, password);
		
		if (loginAttempt == 1) {
			System.out.println("\n\nLogin Successful!");
			System.out.println("\n\n-----Customer Menu!-----");
			customerMenu();
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
		
		int loginAttempt = empLogin.employeeLogin(username, password);
		
		if (loginAttempt == 1) {
			System.out.println("\n\nLogin Successful!");
			System.out.println("\n\n-----Employee Menu!-----");
			employeeMenu();
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
		cs.createAccount(username, password, firstName, lastName);
		
		System.out.println("\n\n\n");
		firstMenu();
	}
	
	public void customerMenu() {
		
	}
	
	public void employeeMenu() {
		
	}
}





