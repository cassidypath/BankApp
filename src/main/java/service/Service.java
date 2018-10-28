package service;

import java.util.List;

import BankApplication.Bank;
import dao.AccountDao;
import dao.CustomerDao;
import models.Account;
import views.optionsView;

public class Service {

	CustomerDao uDao = new CustomerDao();
	AccountDao aDao = new AccountDao();

	// return true or false if user exists
	public boolean usernameAndPasswordValidation(String userName, String password) {
		try {
			if (uDao.findByUsername(userName).getUserName() != null) {
				if (password.equals(uDao.findByUsername(userName).getPassword())) {
					Bank.setCurrentUser(uDao.findByUsername(userName));
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Account> accountList(int id) {
		return aDao.getAccountInfo(id);
	}

	// For loop to go through the Checking Account list
	public Account findCheckingAccount(List<Account> account) {
		Account acc = null;
		// Begins at the first index and goes through the account list (checkings and
		// savings)
		for (int i = 0; i < account.size(); i++) {
			// We get an index for an account and check the accountType, if it's checking
			// then assign it to acc
			if (account.get(i).getAccountType().equals("checking")) {
				acc = account.get(i);
			}
		}
		return acc;
	}

	public Account findSavingsAccount(List<Account> account) {
		Account acc = null;
		for (int i = 0; i < account.size(); i++) {
			if (account.get(i).getAccountType().equals("savings")) {
				acc = account.get(i);
			}
		}
		return acc;
	}

	public Account withdraw(double db, Account acc) {

		if (db < 0) {
			System.out.println("Invalid input");
			return null;
		} else {
//	balance = amount - acc.getBalance();
			return aDao.withdraw(db, acc);
		}
	}

	public Account deposit(double db, Account acc) {
		// double balance = 0;
		if (db < 0) {
			System.out.println("Invalid input");
			return null;
		} else {
			// balance = amount + acc.getBalance();
			return aDao.deposit(db, acc);
//			System.out.println("Success");
//			new optionsView();
		}
	}

	public Account transfer(double db, Account idFrom, int idTo) {
		if (db < 0) {
			System.out.println("Invalid Input");
			return null;
		} else {
			return aDao.transfer(db, idFrom, idTo);

		}
	}


}
