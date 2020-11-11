package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.AddRemoveElementsPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AddRemoveElementsPageTest extends TheInternetTestBase{

	@Test
	public void tc1canAddElements() {
		//Arrange
		int expectedSelection = 2;

		//Act
		int selectedOption = new AddRemoveElementsPage(driver, baseUrl)
				.navigate()
				.addElements(2)
				.getTotalDelete();

		//Assert
		Assert.assertEquals(selectedOption, expectedSelection);
	}

	
	@Test
	public void tc1canRemoveElements() {
		//Arrange
		int expectedSelection = 2;

		//Act
		int selectedOption = new AddRemoveElementsPage(driver, baseUrl)
				.navigate()
				.addElements(4)
				.removeElements(2)
				.getTotalDelete();

		//Assert
		Assert.assertEquals(selectedOption, expectedSelection);

	}

	@BeforeTest
	public void beforeTest() {
		super.beforeTest("chrome");
	}

	@AfterTest
	public void afterTest() {
		super.afterTest();
	}
}
