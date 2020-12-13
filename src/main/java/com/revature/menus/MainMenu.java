package com.revature.menus;

import java.util.Scanner;

public class MainMenu {
	
	static int menuState = 0;
	
	public static void display() {
		// TODO Auto-generated method stub



	}
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	} 
}





Scanner in = new Scanner(System.in);

System.out.println("Select one of the menu option: \n" +
		"	1 - Login as Customer\n"
		+ "	2 - Login as Employee\n"
		+ "	3 - Create new Customer\n"
		+ "	4 - Close Application");

String choice = in.nextLine();
try {
	int x = Integer.parseInt(choice);
	if(x <= 0 || x > 4) {
		System.out.println("\n\nMake a valid choice please:");
		MainMenu.display();
	}
} catch(NumberFormatException e) {
	System.out.println("\n\nMake a valid choice please:");
	MainMenu.display();
} 

in.close();