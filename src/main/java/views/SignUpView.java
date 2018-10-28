package views;

import BankApplication.Bank;
import dao.CustomerDao;
import models.Customer;

public class SignUpView extends View{

	Customer u = new Customer();
	
	@Override
	public void DisplayOptions() {
	
		System.out.println("Sign Up Menu");
		
	}


	@Override
	public void ProcessInput() {
		System.out.println("choose user type");
		System.out.println("0 : customer");
		String input = Bank.sc.nextLine();
		
		switch(input) {
		case "0":
			System.out.println("Enter First name");
			u.setFirstName(Bank.sc.nextLine());
			System.out.println("Enter last name");
			u.setLastName(Bank.sc.nextLine());
			System.out.println("Create a username");
			u.setUserName(Bank.sc.nextLine());
//			if(Bank.users.get(u.getUserName()) != null) {
//				System.out.println("user name already exists");
//				return;
//			}	
			System.out.println("Create a password");
			u.setPassword(Bank.sc.nextLine());
//			u.setUserType("customer");
			
			CustomerDao custDao = new CustomerDao();
			System.out.println(custDao.createUser(u));
		
			Bank.setCurrentView(previousView);
			return;
			
		default:
			System.out.println("invalid input");
		}
		
	}	
	
}

