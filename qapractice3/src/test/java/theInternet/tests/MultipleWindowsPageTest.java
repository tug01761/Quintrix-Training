package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.MultipleWindowsPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class MultipleWindowsPageTest extends TheInternetTestBase{

	@Test
	public void confirmingNewWindow() {

		String expectedUrl = "http://the-internet.herokuapp.com/windows/new";

		String selectedUrl = new MultipleWindowsPage(driver, baseUrl)
				.navigate()
				.clickLink()
				.openNewTab()
				.getNewWindowUrl();


		Assert.assertEquals(selectedUrl, expectedUrl);
		
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
