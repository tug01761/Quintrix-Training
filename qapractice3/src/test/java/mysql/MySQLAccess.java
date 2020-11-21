package mysql;

import java.sql.*;


public class MySQLAccess {

	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	public void connectToDB() throws Exception {
		try {
			// register Oracle thin driver with DriverManager service
			// It is optional for JDBC4.x version
			Class.forName("com.mysql.cj.jdbc.Driver");

			// variables
			final String url = "jdbc:mysql:///sakila";
			final String user = "root";
			final String password = "totot6244230";

			// establish the connection
			connection = DriverManager.getConnection(url, user, password);

			// display status message
			if (connection == null) {
				System.out.println("JDBC connection is not established");
				return;
			} else
				System.out.println("Congratulations," + 
						" JDBC connection is established successfully.\n");


		} catch (Exception e) {
			throw e;
		}
	}

	public void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {

		}
	}

	public void GetFilmTitlesThatContainsAirplane() throws Exception {
		statement = connection.createStatement();

		String query = "SELECT title from film WHERE title LIKE '%AIRPLANE%';";

		resultSet = statement.executeQuery(query);

		boolean flag = false;
		while(resultSet.next()) {
			flag = true;
			System.out.println(resultSet.getString(1));
		}

		if (flag == true) {
			System.out.println("\nRecords retrieved and displayed");
		} else {
			System.out.println("Record not found");
		}

	}

}