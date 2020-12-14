package com.revature.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.util.ConnectionFactory;

public class LoginDAO {
	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFacotry();
	
	public Customer customerLogin(String username, String password) {
		
		Connection conn = this.cf.getConnection();
		
		try {
			String sql = "select * from customer where \"username\" = '" + username + "' and \"password\" = '" + password + "';";
			
			Statement ps = conn.createStatement();
			ResultSet res = ps.executeQuery(sql);
			
			Customer c;
			
			while (res.next()) {
				c = new Customer();
				c.setCustomerId(res.getInt("customerId"));
				c.setUsername(res.getString("username"));
				c.setPassword(res.getString("password"));
				c.setFirstName(res.getString("firstName"));
				c.setLastName(res.getString("lastName"));
				
				return c;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public Employee employeeLogin(String username, String password) {
		
		Connection conn = this.cf.getConnection();
		
		try {
			String sql = "select * from employee where \"username\" = '" + username + "' and \"password\" = '" + password + "';";
			
			Statement ps = conn.createStatement();
			ResultSet res = ps.executeQuery(sql);
			
			Employee e;
			
			while (res.next()) {
				e = new Employee();
				e.setUsername(res.getString("username"));
				e.setPassword(res.getString("password"));
				e.setFirstName(res.getString("firstName"));
				e.setLastName(res.getString("lastName"));
				
				return e;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}