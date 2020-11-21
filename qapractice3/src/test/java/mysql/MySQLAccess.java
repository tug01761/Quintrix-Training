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

	public int insertStoreToTable() throws Exception {
		statement = connection.createStatement();

		String query1 = "START TRANSACTION;";

		String query2 = "INSERT INTO staff (first_name, last_name, address_id, email, store_id, `active`, username) \r\n"
				+ "VALUES (\"John\", \"Doe\", \"18\", \"rando@gmail.com\", \"2\", \"1\", \"newJohn\");";

		String query3 = "SET @staffId = LAST_INSERT_ID();";

		String query4 = "INSERT INTO address (address, district, city_id, phone, location) \r\n"
				+ "VALUES ('110 Main', 'Dime Box', 300, 7137778888, ST_GeomFromText('POINT(1 1)'));";

		String query5 = "SET @addressId = LAST_INSERT_ID();";

		String query6 = "INSERT INTO store (manager_staff_id, address_id) \r\n"
				+ "VALUES (@staffId, @addressId);";

		String query7 = "SET @storeId = LAST_INSERT_ID();";

		String query8 = "UPDATE staff \r\n"
				+ "SET store_id = @storeId\r\n"
				+ "WHERE staff_id = @staffId;";

		String query9 = "ROLLBACK;";

		//String query10 = "SELECT * FROM store WHERE store_id = 2";

		int count = 0; 

		count += statement.executeUpdate(query1);
		count += statement.executeUpdate(query2);
		count +=statement.executeUpdate(query3);
		count +=statement.executeUpdate(query4);
		count +=statement.executeUpdate(query5);
		count +=statement.executeUpdate(query6);
		count +=statement.executeUpdate(query7);
		count +=statement.executeUpdate(query8);
		count +=statement.executeUpdate(query9);

		return count;

		/*
		resultSet = statement.executeQuery(query10);

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
		 */

	}



	public int updateCurrentDate() throws Exception {
		statement = connection.createStatement();

		String query1 = "START TRANSACTION;";

		String query2 = "SET SQL_SAFE_UPDATES = 0;";

		String query3 = "UPDATE store AS s\r\n"
				+ "INNER JOIN address AS a ON a.address_id = s.address_id\r\n"
				+ "SET s.last_update = CURDATE()\r\n"
				+ "WHERE a.address = '2210 South';";

		String query4 = "SET SQL_SAFE_UPDATES = 1;";

		String query5 = "ROLLBACK;";

		//String query6 = "SELECT * FROM store WHERE store_id = 10";

		int count = 0;

		count += statement.executeUpdate(query1);
		count += statement.executeUpdate(query2);
		count += statement.executeUpdate(query3);
		count += statement.executeUpdate(query4);
		count += statement.executeUpdate(query5);

		/*
		resultSet = statement.executeQuery(query6);

		int date = 0;

		boolean flag = false;
		while(resultSet.next()) {
			flag = true;
			date = resultSet.getInt(4);
		}

		if (flag == true) {
			System.out.println("\nRecords retrieved and displayed");
		} else {
			System.out.println("Record not found");
		}

		return date;
		 */
		return count;
	}

	public int canDeleteStoreRow() throws Exception{
		statement = connection.createStatement();

		String query1 = "START TRANSACTION;";

		String query2 = "SET SQL_SAFE_UPDATES = 0;";

		String query3 = "DELETE s.*\r\n"
				+ "FROM store AS s\r\n"
				+ "INNER JOIN address AS a ON a.address_id = s.address_id\r\n"
				+ "WHERE a.address = '110 Main';";

		String query4 = "SET SQL_SAFE_UPDATES = 1;";

		String query5 = "ROLLBACK;";

		int count = 0;

		count += statement.executeUpdate(query1);
		count += statement.executeUpdate(query2);
		count += statement.executeUpdate(query3);
		count += statement.executeUpdate(query4);
		count += statement.executeUpdate(query5);

		return count;

	}




}