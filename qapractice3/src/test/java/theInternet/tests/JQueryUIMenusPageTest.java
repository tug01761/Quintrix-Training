package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.JQueryUIMenusPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class JQueryUIMenusPageTest extends TheInternetTestBase{

	@Test
	public void canAccessPage() {
		//Arrange
		String expectedSelection = ("http://the-internet.herokuapp.com/jqueryui");

		//Act
		String selectedOption = new JQueryUIMenusPage(driver, baseUrl)
				.navigateToPage()
				.navigateThroughUIMenus()
				.getURL();

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
