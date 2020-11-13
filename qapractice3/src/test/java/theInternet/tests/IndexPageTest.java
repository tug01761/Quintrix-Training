package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.IndexPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class IndexPageTest extends TheInternetTestBase{
	
	@Test
	public void canNavigateToIndexPage() {
		//Arrange
		String expectedPageTitle = "The Internet";

		//Act
		String actualPageTitle = new IndexPage(driver, baseUrl)
				.navigate()
				.getTitle();

		//Assert
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
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
