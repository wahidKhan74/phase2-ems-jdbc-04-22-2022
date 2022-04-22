package com.simplilearn.jdbcapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEmployeeWithPS {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement pstatement = null;

		try {
			// 1. create connection
			connection = DatabaseConnection.getConnection();
			// 2. create insert query
			String query = "INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`)"
					+ " VALUES (?,?,?,?,?,?);";
			// 3. create a statement
			pstatement = connection.prepareStatement(query);

			// 4. set query parameters
			pstatement.setInt(1, 101);
			pstatement.setString(2, "Kim");
			pstatement.setString(3, "Young");
			pstatement.setString(4, "kim.yung@gmail.com");
			pstatement.setString(5, "Engineering");
			pstatement.setDouble(6, 87868.43);
			
			// 4. execute query
			int rowsAffected = pstatement.executeUpdate();

			System.out.println("No of Rows Affected " + rowsAffected);

		} catch (SQLException e) {
			System.out.println("Exception Occured : " + e.getClass());
			System.out.println("Exception Message : " + e.getMessage());
		}
	}
}
