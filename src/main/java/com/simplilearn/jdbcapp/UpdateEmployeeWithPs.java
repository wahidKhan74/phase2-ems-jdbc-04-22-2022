package com.simplilearn.jdbcapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEmployeeWithPs {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement pstatement = null;

		try {
			// 1. create connection
			connection = DatabaseConnection.getConnection();
			// 2. create insert query
			String updateQuery = "UPDATE employees set last_name=?,first_name=?,email=?,"
					+ " department=?, salary=?"
					+ " where id=?";
			
			// 3. create a statement
			pstatement = connection.prepareStatement(updateQuery);

			// 4. set update query parameters			
			pstatement.setString(1, "Kumar");
			pstatement.setString(2, "Raj");
			pstatement.setString(3, "raj.kumar@gmail.com");
			pstatement.setString(4, "Dev");
			pstatement.setDouble(5, 999999.99);
			pstatement.setInt(6, 101);
			
			// 4. execute query
			int rowsAffected = pstatement.executeUpdate();

			System.out.println("The Employees Updated :" + rowsAffected);

		} catch (SQLException e) {
			System.out.println("Exception Occured : " + e.getClass());
			System.out.println("Exception Message : " + e.getMessage());
		}
	}
}
