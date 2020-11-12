package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.RedirectLinkPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class RedirectLinkPageTest extends TheInternetTestBase{

	@Test
	public void canAccessPage() {
		//Arrange
		String expectedSelection = ("http://the-internet.herokuapp.com/status_codes");

		//Act
		String selectedOption = new RedirectLinkPage(driver, baseUrl)
				.navigate()
				.redirect()
				.getPage();

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
