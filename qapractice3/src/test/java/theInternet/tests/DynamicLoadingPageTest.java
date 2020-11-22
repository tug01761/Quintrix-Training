package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.DynamicLoadingPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DynamicLoadingPageTest extends TheInternetTestBase{

	@Test
	public void canDoInputAfterDynamicControls() {
		//Arrange
		String  expectedSelection = "Hello World!";

		//Act
		String  selectedOption = new DynamicLoadingPage(driver, baseUrl)
				.navigate()
				.clickOnLink()
				.clickButton()
				.getText();

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
