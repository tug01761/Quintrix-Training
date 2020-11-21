package mysql;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class MySQLTest {
	
	MySQLAccess database = new MySQLAccess();

	@Test
	public void GetFilmTitlesThatContainsAirplane() {
		try {
			database.GetFilmTitlesThatContainsAirplane();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1() {

	}
	
	
	
	@BeforeTest
	public void beforeTest() {
		try {
			database.connectToDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void afterTest() {
		try {
			database.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
