package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.DragAndDropPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DragAndDropPageTest extends TheInternetTestBase{
	
	@Test
	public void canAccessPage() {
		//Arrange
		String expectedSelection = "You selected a context menu";

		//Act
		String selectedOption = new DragAndDropPage(driver, baseUrl)
				.navigate()
				.dragAndDrop()
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
