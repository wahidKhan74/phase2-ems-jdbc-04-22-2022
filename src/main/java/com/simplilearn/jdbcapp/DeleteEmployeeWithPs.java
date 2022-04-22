package com.simplilearn.jdbcapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEmployeeWithPs {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement pstatement = null;

		try {
			// 1. create connection
			connection = DatabaseConnection.getConnection();
			// 2. create insert query
			String updateQuery = "DELETE from employees "
					+ " where id=?";
			
			// 3. create a statement
			pstatement = connection.prepareStatement(updateQuery);

			// 4. set update query parameters			
			pstatement.setInt(1, 101);
			
			// 4. execute query
			int rowsAffected = pstatement.executeUpdate();

			System.out.println("The Employees Deleted :" + rowsAffected);

		} catch (SQLException e) {
			System.out.println("Exception Occured : " + e.getClass());
			System.out.println("Exception Message : " + e.getMessage());
		}
	}
}
