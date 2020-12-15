package com.revature.services;

import com.revature.models.Transaction;
import com.revature.repositories.TransactionDAO;

public class TransactionServices {

	public void addTransaction(Transaction transaction) {
		
		TransactionDAO tdao = new TransactionDAO();
		tdao.addTransaction(transaction.getTransaction());
	}
	
	public void allTransactions() {
		
		TransactionDAO tdao = new TransactionDAO();
		tdao.allTransactions();
	}
}