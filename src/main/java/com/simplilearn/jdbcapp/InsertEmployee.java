package com.simplilearn.jdbcapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEmployee {
	
	public static void main(String[] args) {
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			// 1. create connection
			connection = DatabaseConnection.getConnection();
			// 2. create a statement
			statement = connection.createStatement();
			// 3. create insert query 
			String query ="INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`)"
					+ " VALUES (13,'Snow','White','white.snow@zoo.com', 'Zoo', 80000.00);";
			//4. excute query 
			int rowsAffected =  statement.executeUpdate(query);
			
			System.out.println("No of Rows Affected "+rowsAffected);
			
		} catch (SQLException e) {
			System.out.println("Exception Occured : "+ e.getClass());
			System.out.println("Exception Message : "+ e.getMessage());
		}
	}
}
