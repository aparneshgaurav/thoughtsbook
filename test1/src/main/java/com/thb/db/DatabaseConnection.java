package com.thb.db;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {

	public static Connection getConnection() {

		System.out.println("-------- h2 JDBC Connection Testing ------");

		try {

			Class.forName("org.h2.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your h2 JDBC Driver?");
			e.printStackTrace();

		}

		System.out.println("h2 JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:h2:~/test", "sa",
					"");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		return connection;
	}

}