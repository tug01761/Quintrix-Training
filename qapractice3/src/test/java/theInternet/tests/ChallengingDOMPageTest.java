package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.ChallengingDOMPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ChallengingDOMPageTest extends TheInternetTestBase {
	
	
	@Test
	public void isCanvasExist() {
		//Arrange
		Boolean expectedSelection = true;

		//Act
		Boolean selectedOption = new ChallengingDOMPage(driver, baseUrl)
				.navigate()
				//.clickButton()
				.isCanvasExist();

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
