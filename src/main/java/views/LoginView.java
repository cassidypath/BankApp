package views;

import BankApplication.Bank;
import models.Customer;
import service.Service;

public class LoginView extends View {
	private String username;
	private String password;
	
	
	
	@Override
	public void DisplayOptions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ProcessInput() {
		// TODO Auto-generated method stub
		String input;
		System.out.println("Enter username");
		input = Bank.sc.nextLine();
		this.username = input;
		Customer user;
		// check if the username is valid, if there 
		System.out.println("Enter password");
		input = Bank.sc.nextLine();
		this.password = input;
		
		Service service = new Service();
		
		if (service.usernameAndPasswordValidation(this.username, this.password)) {

		System.out.println("You have successfully logged in!");
		Bank.setCurrentView(new optionsView());
		} else {
			System.out.println("Invalid input, please try again");
			return;
		}
	}



	
}
