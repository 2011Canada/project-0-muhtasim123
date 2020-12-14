package com.revature.launchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.menus.MainMenu;

public class MainLauncher {
	
	static Logger logger = LogManager.getLogger("com.revature.project0");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Bank Application!");
		logger.info("Bank App started");
		MainMenu menu = new MainMenu();
		menu.firstMenu();
		
	}

}
