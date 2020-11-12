package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.DisappearingElementsPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DisappearingElementsPageTest extends TheInternetTestBase{

	@Test
	public void canRefreshPage() {
		//Arrange
		String expectedSelection = "Gallery";

		//Act
		String selectedOption = new DisappearingElementsPage(driver, baseUrl)
				.navigate()
				.refreshPage();

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
