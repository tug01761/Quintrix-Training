package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.HoversPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HoversPageTest extends TheInternetTestBase{

	@Test
	public void canAccessPage() {
		//Arrange
		String expectedSelection = ("http://the-internet.herokuapp.com/users/2");

		//Act
		String selectedOption = new HoversPage(driver, baseUrl)
				.navigate()
				.hoverObject()
				.getResult();

		//Assert
		Assert.assertEquals(selectedOption, expectedSelection);
	}


	@BeforeTest
	public void beforeTest() {
		super.beforeTest();
	}

	@AfterTest
	public void afterTest() {
		super.afterTest();
	}

}
