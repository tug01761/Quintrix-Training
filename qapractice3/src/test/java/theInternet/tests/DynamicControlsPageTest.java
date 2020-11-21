package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.DynamicControlsPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DynamicControlsPageTest extends TheInternetTestBase{

	@Test
	public void canDoInputAfterDynamicControls() {
		//Arrange
		String  expectedSelection = "It's working now!";

		//Act
		String  selectedOption = new DynamicControlsPage(driver, baseUrl)
				.navigate()
				.enableInput()
				.setText()
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
