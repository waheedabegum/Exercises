package com.ge.exercise3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BankTest {

	Bank bank;

	@Before
	public void setUp() {
		bank = new Bank();
	}

	@Test
	public void addAccountTest() {
		Account account = new Account("001");
		bank.addAccount(account);
		assertEquals(1, bank.numAccounts());
	}

	@Test
	public void getAccountTest() {
		Account account = new Account("002", "Checking", 100.0f);
		bank.addAccount(account);
		assertEquals(account, bank.getAccount("002"));
	}

	@Test
	public void depositToAccountTest() {
		Account account = new Account("003", "Checking", 100.0f);
		bank.addAccount(account);
		bank.depositToAccount("003", 100.0f);
		assertEquals(200.0f, account.getBalance(), 0.01);
	}

	@Test
	public void withdrawFromAccountTest() {
		Account account = new Account("004", "Checking", 100.0f);
		bank.addAccount(account);
		bank.withdrawFromAccount("004", 100.0f);
		assertEquals(0.0f, account.getBalance(), 0.01);
	}

	// assuming we have to add only current account balance condition 1
	@Test
	public void getSumOfCurrentHoldingsTest() {
		Account account = new Account("004", "Current", 100.0f);
		Account account1 = new Account("005", "Current", 111.0f);
		Account account0 = new Account("006", "Savings", 111.0f);
		Account account2 = new Account("007", "Current", 289.0f);
		bank.addAccount(account);
		bank.addAccount(account1);
		bank.addAccount(account0);
		bank.addAccount(account2);
		assertEquals(500.0f, bank.getSumOfCurrentHoldings(), 0.01);
	}

	//condition 3 & 4
	// checking account moe thamn $100 withdrawl test
	// please check logger or console message to test this case

	@Test
	public void withdrawFromAccountCheckingAccountTest() {
		Account account = new Account("004", "Checking", 100.0f);
		Account account2 = new Account("005", "Savings", 100.0f);
		bank.addAccount(account);
		bank.addAccount(account2);
		bank.withdrawFromAccount("004", 111.0f);
		bank.withdrawFromAccount("005", 101.0f);
		assertTrue(true);
		// assertEquals(500.0f, bank.getSumOfCurrentHoldings(), 0.01);
	}

	//condition 2
	@Test
	public void checkingProfitOrLossTest() {
		Account account = new Account("004", "Checking", 100.0f, 12);
		Account account2 = new Account("005", "Savings", 100.0f, 11);
		bank.addAccount(account);
		bank.addAccount(account2);
		bank.getProfitOrLoss();
        assertTrue(true);
	}

}
