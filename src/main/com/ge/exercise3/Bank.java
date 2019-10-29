package com.ge.exercise3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Bank {

	private static final Logger logger = LogManager.getLogger(Bank.class);
	private Map<String, Account> accountMap;

	public Bank() {
		accountMap = new HashMap<>();
	}

	public Account getAccount(String accountNumber) {
		return accountMap.get(accountNumber);
	}

	public void addAccount(Account account) {
		accountMap.put(account.getAccountNumber(), account);
	}

	public void depositToAccount(String accountNumber, float amount) {
		getAccount(accountNumber).deposit(amount);
	}

	// Conditions 3 & 4

	public void withdrawFromAccount(String accountNumber, float amount) {
		// checking account more thamn $100 withdrawl
		for (Account i : accountMap.values()) {
			if (i.getAccountType().equalsIgnoreCase("Checking") && amount >= 100.0f) {
				logger.info("cannot withdraw more than $100");
				System.out.println("Oops...can not withdraw");

			} else if (i.getAccountType().equalsIgnoreCase("Savings") && i.getBalance() - amount < 0.0f) {
				logger.info("cannot have negative balance in savings account");
				System.out.println("Oops...can not withdraw from savings account");
			}

			else {
				getAccount(accountNumber).withdraw(amount);
			}
		}

	}

	public int numAccounts() {
		return accountMap.size();
	}

	// condition 1
	// to get sum of all current accounts
	public float getSumOfCurrentHoldings() {
		float result = 0f;

		for (Account i : accountMap.values()) {
			if (i.getAccountType().equalsIgnoreCase("Current")) {
				result += i.getBalance();
			} else {
				continue;
			}
		}
		return result;
	}

	// condition 2

	public String getProfitOrLoss() {
		float totalMonthlyInterest = 0.0f, totalFee = 0.0f;
		for (Account i : accountMap.values()) {
			totalMonthlyInterest += i.getValueNextMonthIntrest();
			totalFee += i.getMonthlyFee();
		}
		if (totalMonthlyInterest > totalFee) {
			return "Loss";
		} else
			return "Profit";

	}

}
