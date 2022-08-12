package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimeZone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent1";

		try {
			System.out.println("Connecting to Database: " + jdbcUrl);
			Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection Successful!");
			
			
		} catch (SQLException e) {
			System.out.println("Error Message: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
