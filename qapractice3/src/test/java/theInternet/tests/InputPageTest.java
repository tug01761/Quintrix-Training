package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.InputPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class InputPageTest extends TheInternetTestBase {
	WebDriver driver;

	@Test
	public void tc21canInputInteger() {
		//Arrange
		//String url = "http://the-internet.herokuapp.com/";
		int expectedInput = 100;

		//Act
		int selectedInput = new InputPage(webDriver, baseUrl)
				.navigate()
				.setInteger(expectedInput)
				.getInteger();


		//Assert
		Assert.assertEquals(selectedInput, expectedInput);
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
