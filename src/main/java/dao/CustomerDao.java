package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionUtil;
import models.Customer;

public class CustomerDao {

	// SignUp
    public Customer createUser(Customer user) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String query = "INSERT INTO customer (user_name, first_name, last_name, password) VALUES (?, ?, ?, ?) RETURNING id";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getPassword());
            
            // ResultSet starts before the first ruself, so we need to call next at least once
            ResultSet rs = ps.executeQuery();
            rs.next();
            user.setId(rs.getInt("id"));
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // Login
    public Customer findByUsername(String userName) {
    	
    	Customer cust = null;
    	
    	try (Connection conn = ConnectionUtil.getConnection()) {
    						// Look up username from customer table. ? represents user value
    		String query = "SELECT * FROM customer WHERE user_name = ?";
    		PreparedStatement ps = conn.prepareStatement(query);
    		ps.setString(1, userName);
    		
    		// results of query will be stored in ResultSet
    		ResultSet rs = ps.executeQuery();
    		// .next returns a boolean, so it returns true or false
            while(rs.next()) {
            	// getting information from the database and applying it to a customer object.
            	cust = new Customer(rs.getInt("id"), rs.getString("user_name"), rs.getString("password"), rs.getString("first_name"), rs.getString("last_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
    	}
        return cust;
    }
}
