package views;

import java.util.Scanner;

import BankApplication.Bank;
import views.SignUpView;

public class MainView extends View {
			
		public void signUp() {
			
		}
		
		public void login() {
			
		}

		@Override
		public void DisplayOptions() {
			System.out.println("Welcome to the Broke Bank! To get started, please choose an option below:");
			System.out.println("Press 1 to sign up for an account");
			System.out.println("Press 2 to login to your account");
			System.out.println("Press 3 to quit");
			
		}

		@Override
		public void ProcessInput() {
			String input = Bank.sc.nextLine();
			switch (input) {
			case "1": Bank.setCurrentView(nextViews.get(0)); // the first element in the list will be sign up
				break;
			case "2": Bank.setCurrentView(nextViews.get(1)); // the second element in the list will be login
				break;
			case "3": 
				Bank.running = false;
				break;
			default:
				System.out.println("Invalid input, please try again");
				
			}
			
		}
	
}
