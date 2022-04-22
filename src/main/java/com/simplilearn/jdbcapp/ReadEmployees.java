package com.simplilearn.jdbcapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadEmployees {
	
	public static void main(String[] args) {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			// 1. create connection
			connection = DatabaseConnection.getConnection();
			// 2. create a statement
			statement = connection.createStatement();
			// 3. read query & execute
			String query = "select * from employees";
			resultSet = statement.executeQuery(query);
			
			// 4. read result set 
			while(resultSet.next()) {
				System.out.println("------------------");
				System.out.println(resultSet.getInt("id"));
				System.out.println(resultSet.getString("first_name"));
				System.out.println(resultSet.getString("last_name"));
				System.out.println(resultSet.getString("email"));
				System.out.println(resultSet.getDouble("salary"));
				System.out.println(resultSet.getString("department"));
			}
		} catch (SQLException e) {
			System.out.println("Exception Occured : "+ e.getClass());
			System.out.println("Exception Message : "+ e.getMessage());
		}
	}

}
