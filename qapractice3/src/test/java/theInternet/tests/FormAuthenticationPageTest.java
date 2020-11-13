package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.FormAuthenticationLoginPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class FormAuthenticationPageTest extends TheInternetTestBase {

	@Test
	public void canGetIntoSecuredPage() {
		//Arrange
		String expectedSelection = "http://the-internet.herokuapp.com/secure";

		//Act
		String selectedOption = new FormAuthenticationLoginPage(driver, baseUrl)
				.navigate()
				.login()
				.getSecuredPage();

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
