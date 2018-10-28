package views;

import BankApplication.Bank;

public class ExampleView extends View {

	@Override
	public void DisplayOptions() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.out.println("Choose an option, inside example view");
				System.out.println("0 : Go to previous view");
				//System.out.println("1 : Go to previous view");
				//System.out.println("Q : Quit ");
	}

	@Override
	public void ProcessInput() {
		// TODO Auto-generated method stub
		String input = Bank.sc.next();
		switch(input) {
		case "0":
			Bank.setCurrentView(previousView);
			break;
		case "1":
			//Bank.setCurrentView(nextView);
			break;
		case "Q":
			//Bank.setRunning(false);
			break;
		default:
			System.out.println("Invalid input");
			break;
		}
	}

}
