package BankApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import models.Account;
import models.Customer;
import views.LoginView;
import views.MainView;
import views.SignUpView;
import views.View;
import views.optionsView;

public class Bank {
	public static View currentView;
	public static Customer currentUser;

	public static Scanner sc = new Scanner(System.in);
	public static boolean running = false;
	
	public static void Initialize() {
		
		running = true;
		
		//	Instance Constructor
		View mainView = new MainView();
		View signupView = new SignUpView();
		View loginView = new LoginView();
		View optionsView = new optionsView();
		
		mainView.nextViews.add(signupView);
		mainView.nextViews.add(loginView);
		mainView.nextViews.add(optionsView);
		signupView.setPreviousView(mainView);
		loginView.setPreviousView(mainView);
		optionsView.setPreviousView(mainView);
		
		currentView = mainView;
	}
	
	public static Customer getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(Customer currentUser) {
		Bank.currentUser = currentUser;
	}

	public static boolean isRunning() {
		return running;
	}

	public static void setRunning(boolean running) {
		Bank.running = running;
	}

	public static View getCurrentView() {
		return currentView;
	}

	public static void setCurrentView(View currentView) {
		Bank.currentView = currentView;
	}
	
	public static void Run() {
		currentView.DisplayOptions();
		currentView.ProcessInput();
	}
	
}
