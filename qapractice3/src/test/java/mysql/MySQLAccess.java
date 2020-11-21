package mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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

	public List<String> getFilmTitlesThatContainsAirplane() throws Exception {
		statement = connection.createStatement();

		String query = "SELECT title from film WHERE title LIKE '%AIRPLANE%';";

		resultSet = statement.executeQuery(query);

		List<String> answer = new ArrayList<String>();

		boolean flag = false;
		while(resultSet.next()) {
			flag = true;
			answer.add(resultSet.getString(1));
		}

		if (flag == true) {
			System.out.println("\nRecords retrieved and displayed");
		} else {
			System.out.println("Record not found");
		}

		return answer;

	}

	public int getStockCountForFilmAlienCenter() throws Exception{
		statement = connection.createStatement();

		String query1 = "SET @filmId = (SELECT f.film_id \r\n"
				+ "FROM film AS f\r\n"
				+ "WHERE f.title = 'Alien Center');";
		
		String query2 = "SET @filmCount = 0;";
		
		String query3 = "CALL film_in_stock(@filmId, 2, @filmCount);";
		
		String query4 = "SELECT @filmCount;";

		resultSet = statement.executeQuery(query1);
		resultSet = statement.executeQuery(query2);
		resultSet = statement.executeQuery(query3);
		resultSet = statement.executeQuery(query4);
		
		int answer = 0;
		
		boolean flag = false;
		while(resultSet.next()) {
			flag = true;
			answer = resultSet.getInt(1);
		}

		if (flag == true) {
			System.out.println("\nRecords retrieved and displayed");
		} else {
			System.out.println("Record not found");
		}
		
		return answer;
	}

}