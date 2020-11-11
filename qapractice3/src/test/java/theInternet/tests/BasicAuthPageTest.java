package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.BasicAuthPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class BasicAuthPageTest extends TheInternetTestBase {
	@Test
	public void canAccessPage() {
		//Arrange
		String successText = "Congratulations! You must have the proper credentials.";

		//Act
		String pageSource = new BasicAuthPage(driver, baseUrl)
								.navigate()
								.getPageSource();

		//Assert
		Assert.assertTrue(pageSource.contains(successText));
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
