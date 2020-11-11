package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.IndexPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class IndexPageTest extends TheInternetTestBase{
	
	@Test
	public void canNavigateToIndexPage() {
		//Arrange
		//String url = "http://the-internet.herokuapp.com/";
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
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\mikel\\OneDrive\\Desktop\\geckodriver.exe");
		//driver = new FirefoxDriver();
		super.beforeTest("firefox");
	}

	@AfterTest
	public void afterTest() {
		super.afterTest();
		//driver.quit();
	}

}
