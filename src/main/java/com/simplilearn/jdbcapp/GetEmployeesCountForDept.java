package com.simplilearn.jdbcapp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class GetEmployeesCountForDept {

	public static void main(String[] args) {
		
		Connection connection = null;
		CallableStatement cstm = null;

		try {
			// 1. create connection
			connection = DatabaseConnection.getConnection();
			
			// 2. create a callable statement
			cstm = connection.prepareCall("{ call get_count_for_department(?,?) }");

			// 4. set callable stm query parameters	
			String department = "HR";
			cstm.setString(1, department);  // input parameter to callable stm
			
			cstm.registerOutParameter(2, Types.INTEGER);
			
			// 4. execute query
			 cstm.execute();

			// 5.collect the output 
			 int employeeCount = cstm.getInt(2);
			
			 System.out.println("The Employee Count for Department "+ department +" is ," +employeeCount);

		} catch (SQLException e) {
			System.out.println("Exception Occured : " + e.getClass());
			System.out.println("Exception Message : " + e.getMessage());
		}

	}

}
