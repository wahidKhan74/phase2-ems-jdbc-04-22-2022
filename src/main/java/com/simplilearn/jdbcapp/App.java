package com.simplilearn.jdbcapp;

import java.sql.Connection;

public class App {
	
	public static void main(String[] args) {

		Connection conn = null;

		try {
			// 1. create connection
			conn = DatabaseConnection.getConnection();
			if (conn != null) {
				System.out.println("JDBC Connection is successfull.");
			} else {
				System.out.println("JDBC Connection Failed.");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
