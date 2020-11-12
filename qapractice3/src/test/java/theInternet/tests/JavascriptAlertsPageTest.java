package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.JavascriptAlertsPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class JavascriptAlertsPageTest extends TheInternetTestBase {

	@Test
	public void confirmingJSAlert() {
		//Arrange
		String expectedSelection = "I am a JS Alert";

		//Act
		String selectedOption = new JavascriptAlertsPage(driver, baseUrl)
				.navigate()
				.clickJSAlert()
				.confirmJSAlert();

		//Assert
		Assert.assertEquals(selectedOption, expectedSelection);
	}
	
	@Test
	public void confirmingJSConfirm() {
		//Arrange
		String expectedSelection = "I am a JS Confirm";

		//Act
		String selectedOption = new JavascriptAlertsPage(driver, baseUrl)
				.navigate()
				.clickJSConfirm()
				.confirmJSConfirm();

		//Assert
		Assert.assertEquals(selectedOption, expectedSelection);
	}
	
	@Test
	public void confirmingJSPrompt() {
		//Arrange
		String expectedSelection = "You entered: Hello World";

		//Act
		String selectedOption = new JavascriptAlertsPage(driver, baseUrl)
				.navigate()
				.clickJSPrompt()
				.confirmJSPrompt();

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
