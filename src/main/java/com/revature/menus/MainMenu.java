package com.revature.menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainMenu {
	
	static int menuState = 0;
	static Logger logger = LogManager.getLogger("com.revature.project0");

	public void firstMenu() {	  
		int choice = 0;
		System.out.println("Select one of the menu option: \n" +
				  "	1 - Login as Customer\n" +
				  "	2 - Login as Employee\n" +
				  "	3 - Create new Customer\n" + 
				  "	4 - Close Application\n");
		
		try {
			Scanner in = new Scanner(System.in);
			choice = in.nextInt();
			in.close();
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
				customerLogin();
				break;
			case 2:
				employeeLogin();
				break;
			case 3:
				newAccount();
				break;
			case 4:
				System.out.println("Thank you for using the Bank Application!");
				System.exit(0);
		}
		 
	}
	
	public void customerLogin() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("-----Customer Login-----");
		
		System.out.println("Enter username:");
		String username = in.nextLine();
		
		System.out.println("Enter password:");
		String password = in.nextLine();
	}
	
	public void employeeLogin() {
		System.out.println("-----Employee Login-----");
	}
	
	public void newAccount() {
		System.out.println("-----New Account------");
	}
}





