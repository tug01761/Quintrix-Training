package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.ContextMenuPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ContextMenuPageTest extends TheInternetTestBase{

	@Test
	public void canAccessPage() {
		//Arrange
		String expectedSelection = "You selected a context menu";

		//Act
		String selectedOption = new ContextMenuPage(driver, baseUrl)
				.navigate()
				.doRightClick()
				.getAlert();

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
