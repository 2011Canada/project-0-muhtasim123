package com.revature.repositories;

public class TransactionDAO {

	public void addTransaction(String transaction){
		//write SQL stuff
		//insert into transaction values (?), transaction
		System.out.println(transaction);
	}
	
	public void allTransactions() {
		//write SQL stuff
		//select * from transactions and then loop through results and display
		System.out.println("All transactions");
	}
}
