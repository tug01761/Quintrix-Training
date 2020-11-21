package mysql;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class MySQLTest {
	
	MySQLAccess database = new MySQLAccess();

	@Test
	public void getFilmTitlesThatContainsAirplane() {
		
		List<String> expectedSolution = new ArrayList<String>();
			expectedSolution.add("AIRPLANE SIERRA");
			expectedSolution.add("RAGING AIRPLANE");
			
		List<String> selectedOption = new ArrayList<String>();
		
		try {
			selectedOption = database.getFilmTitlesThatContainsAirplane();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(selectedOption, expectedSolution);
	}
	
	@Test
	public void getFilmCountInStock() {
		
		int expectedSolution = 4;
		
		int selectedOption = 0;
		
		try {
			selectedOption = database.getStockCountForFilmAlienCenter();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(selectedOption, expectedSolution);

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
