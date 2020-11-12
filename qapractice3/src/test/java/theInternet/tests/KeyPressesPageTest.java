package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class KeyPressesPageTest extends TheInternetTestBase {

	@Test
	public void canAccessPage() {
		//Arrange
		String expectedSelection = ("You entered: A");

		//Act
		String selectedOption = new KeyPressesPage(driver, baseUrl)
				.navigate()
				.enterKey()
				.getResult();

		//Assert
		Assert.assertEquals(selectedOption, expectedSelection);
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
