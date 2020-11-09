package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.CheckboxPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CheckboxPageTest extends TheInternetTestBase {
	WebDriver driver;
	
	@Test
	public void tc4canCheckCheckBox() {
		//Arrange
		//String url = "http://the-internet.herokuapp.com/";
		Boolean expectedInput = true;

		//Act
		Boolean selectedInput = new CheckboxPage(webDriver, baseUrl)
				.navigate()
				.check()
				.getStatus();

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
