package com.simplilearn.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	// datasource config
	static final String DB_URL = "jdbc:mysql://localhost:3306/ems_system_db";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

	static Connection connection = null;

	public static Connection getConnection() {
		try {
			// register JDBC Driver;
			Class.forName(JDBC_DRIVER);
			// create connection
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Exception Occured : "+ e.getClass());
			System.out.println("Exception Message : "+ e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Exception Occured : "+ e.getClass());
			System.out.println("Exception Message : "+ e.getMessage());
		}
		// return connection
		return connection;
	}

}
