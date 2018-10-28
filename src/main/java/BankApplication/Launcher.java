package BankApplication;

import java.util.Scanner;
import views.MainView;

public class Launcher {
	
		public static void main(String[] args) {
			Bank.Initialize();
			 while(Bank.isRunning()) {
				 Bank.Run();
			 }	
		}
		
	}


