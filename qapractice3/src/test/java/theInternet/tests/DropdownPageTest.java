package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.DropdownPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DropdownPageTest extends TheInternetTestBase{

	@Test
	public void tc8canSelectDropdownListItem() {
		//Arrange
		//String url = "http://the-internet.herokuapp.com/";
		String expectedSelection = "Option 2";

		//Act
		String selectedOption = new DropdownPage(webDriver, baseUrl)
				.navigate()
				.select(expectedSelection)
				.getOption();

		//Assert
		Assert.assertEquals(selectedOption, expectedSelection);
	}

	@BeforeTest
	public void beforeTest() {
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\mikel\\OneDrive\\Desktop\\geckodriver.exe");
		//driver = new FirefoxDriver();
		super.beforeTest();
	}

	@AfterTest
	public void afterTest() {
		super.afterTest();
		//driver.quit();
	}

}
