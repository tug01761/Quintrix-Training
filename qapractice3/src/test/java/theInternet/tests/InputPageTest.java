package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.InputPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class InputPageTest extends TheInternetTestBase {

	@Test
	public void tc21canInputInteger() {
		//Arrange
		int expectedInput = 100;

		//Act
		int selectedInput = new InputPage(driver, baseUrl)
				.navigate()
				.setInteger(expectedInput)
				.getInteger();


		//Assert
		Assert.assertEquals(selectedInput, expectedInput);
	}

	@BeforeTest
	public void beforeTest() {
		super.beforeTest("firefox");
	}

	@AfterTest
	public void afterTest() {
		super.afterTest();
	}

}
