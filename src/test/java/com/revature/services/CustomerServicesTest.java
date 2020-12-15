package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.models.Account;
import com.revature.models.Customer;

public class CustomerServicesTest {
	private Customer customer;
	private Account account;
	private CustomerServices cs;
	
	@BeforeEach
	public void setupCustomer() {
		customer = new Customer();
		cs = new CustomerServices();
		account = new Account();
		customer.setCustomerId(1);
		account.setAccountName("testaccount");
		account.setBalance(1000);
		account.setCustomerId(1);
	}
	
	@Test
	public void testBalance() {
		assertEquals(1000, cs.balance(customer, account.getAccountName()));
	}
}
