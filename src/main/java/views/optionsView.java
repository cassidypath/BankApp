package views;

import java.util.ArrayList;
import java.util.List;

import BankApplication.Bank;
import models.Account;
import service.Service;

public class optionsView extends View {

	Service s = new Service();
	List<Account> accountList = new ArrayList<>();
	Account a = null;

	@Override
	public void DisplayOptions() {
		System.out.println("Please choose an account below");
		System.out.println("1 - Checking");
		System.out.println("2 - Savings");
		System.out.println("3- Go back to Main Menu");
//		MainView mainView = new MainView();
//		mainView.DisplayOptions();

	}

	@Override
	public void ProcessInput() {

		String input = Bank.sc.nextLine();
		switch (input) {
		case "1":
			this.checking();
			break;
		case "2":
			this.savings();
			break;
		case "3":
			Bank.setCurrentView(new MainView());
			break;
		default:
			System.out.println("Invalid option, please try again");
		}

	}

	public void checking() {
		accountList = s.accountList(Bank.currentUser.getId());
		a = s.findCheckingAccount(accountList);
		System.out.println("Here is your checking balance: " + a.getBalance());
		System.out.println("Press 1 to Withdraw");
		System.out.println("Press 2 to Deposit");
		System.out.println("Press 3 to Transfer into your savings account");

		String input = Bank.sc.nextLine();
		switch (input) {
		case "1":
			this.withdraw(a);
			break;
		case "2":
			this.deposit(a);
			break;
		case "3":
			this.transfer(a);
			break;
		default:
			System.out.println("Done");
		}
	}

	public void savings() {
		accountList = s.accountList(Bank.currentUser.getId());
		a = s.findSavingsAccount(accountList);
		System.out.println("Here is your savings balance: " + a.getBalance());
		System.out.println("Press 1 to Withdraw");
		System.out.println("Press 2 to Deposit");
		System.out.println("Press 3 to Transfer into your checking account");

		String input = Bank.sc.nextLine();
		switch (input) {
		case "1":
			this.withdraw(a);
			break;
		case "2":
			this.deposit(a);
			break;
		case "3":
			this.transfer(a);
			break;
		default:
			System.out.println("Done");
		}
	}

	public void deposit(Account acc) {
		System.out.println("How much would you like to deposit?");
		double db = Double.parseDouble(Bank.sc.nextLine());
		Account account = s.deposit(db, acc);
		System.out.println("Your account balance is now " + account.getBalance());
	}

	public void withdraw(Account acc) {
		System.out.println("How much would you like to withdraw?");
		double db = Double.parseDouble(Bank.sc.nextLine());
		Account account = s.withdraw(db, acc);
		System.out.println("Your account balance is now " + account.getBalance());
		
	}
	
	public void transfer(Account idFrom) {
		System.out.println(idFrom);
		System.out.println("Enter the amount you would like to transfer");
		double db = Double.parseDouble(Bank.sc.nextLine());
		System.out.println("Enter the account ID you would like to transfer to");
		int idTo = Integer.parseInt(Bank.sc.nextLine());
		Account account = s.transfer(db, idFrom, idTo);
		System.out.println("Your account balance is now " + account.getBalance());
	}
	
}
