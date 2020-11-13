package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.SortableDataTablesPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SortableDataTablesPageTest extends TheInternetTestBase{

	@Test
	public void canGetTableCellContents() {
		//Arrange
		String expectedText = "$50.00";

		//Act
		String actualText = new SortableDataTablesPage(driver, baseUrl)
				.navigate()
				.getAmountDueForUserTableRow1();

		//Assert
		Assert.assertEquals(actualText, expectedText);
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
