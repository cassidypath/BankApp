package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable {
	
	private int id;
	private double balance;
	private String accountType;
	private List<Customer> owners = new ArrayList<>();
	private int accountNumber;
	private boolean status;
	
	public Account() {
		// Method that references the parent object and object class
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int id, double balance, String accountType, int accountNumber,
			boolean status) {
		super();
		this.id = id;
		this.balance = balance;
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public List<Customer> getOwners() {
		return owners;
	}

	public void setOwners(List<Customer> owners) {
		this.owners = owners;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", accountType=" + accountType + ", owners=" + owners
				+ ", accountNumber=" + accountNumber + ", status=" + status + "]";
	}

}

	