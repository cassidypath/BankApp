package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionUtil;
import models.Account;

public class AccountDao {

	public List<Account> getAccountInfo(int id) {

		List<Account> acc = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			String query = "SELECT a.* FROM customer_account ca\r\n"
					+ "INNER JOIN customer c ON ca.customer_id = c.id\r\n"
					+ "INNER JOIN accounts a ON ca.account_id = a.id\r\n" + "WHERE c.id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			// .next returns a boolean, so it returns true or false
			while (rs.next()) {
				// getting information from the database and applying it to a customer object.
				acc.add(new Account(rs.getInt("id"), rs.getDouble("balance"), rs.getString("accountType"),
						rs.getInt("account_number"), rs.getBoolean("status")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}

	public Account deposit(double db, Account acc) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			double accBalance = acc.getBalance();
			double newBalance = accBalance + db;
			
			String query = "UPDATE accounts SET balance = ? WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, newBalance);
			ps.setInt(2, acc.getId());
			ps.execute();
			Account account = new Account();
			account.setId(acc.getId());
			account.setBalance(newBalance);
			account.setAccountType(acc.getAccountType());
			account.setOwners(acc.getOwners());
			account.setStatus(acc.isStatus());
			return account;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Account withdraw(double db, Account acc) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			double accBalance = acc.getBalance();
			double newBalance = accBalance - db;
			
			String query = "UPDATE accounts SET balance = ? WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, newBalance);
			ps.setInt(2, acc.getId());
			ps.execute();
			Account account = new Account();
			account.setId(acc.getId());
			account.setBalance(newBalance);
			account.setAccountType(acc.getAccountType());
			account.setOwners(acc.getOwners());
			account.setStatus(acc.isStatus());
			return account;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Account transfer(double db, Account idFrom, int idTo) {
try (Connection conn = ConnectionUtil.getConnection()) {
			String q = "SELECT * FROM accounts where id = ?";
			Account accountTo = new Account();
			PreparedStatement prepStatement = conn.prepareStatement(q);
			prepStatement.setInt(1, idTo);
			ResultSet resultSet = prepStatement.executeQuery();
			resultSet.next();
			accountTo.setBalance(resultSet.getDouble("balance"));
			accountTo.setId(resultSet.getInt("id"));
	
			double accountFrom = idFrom.getBalance();
			double newFromBalance = accountFrom - db;
			
			double accountToNewBalance = accountTo.getBalance() + db;
			
			
			String query = "UPDATE accounts SET balance = ? WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, newFromBalance);
			ps.setInt(2, idFrom.getId());
			ps.execute();
			
			String query2 = "UPDATE accounts SET balance = ? WHERE id = ?";
			PreparedStatement prepareState = conn.prepareStatement(query2);
			prepareState.setDouble(1, accountToNewBalance);
			prepareState.setInt(2, idTo);
			prepareState.execute();
			return idFrom;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
	}
	
	
	}
	
	
	
}
