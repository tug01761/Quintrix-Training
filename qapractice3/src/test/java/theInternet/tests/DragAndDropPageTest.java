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
		String expectedSelection = "B";

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
		super.beforeTest();
	}

	@AfterTest
	public void afterTest() {
		super.afterTest();
	}

}
