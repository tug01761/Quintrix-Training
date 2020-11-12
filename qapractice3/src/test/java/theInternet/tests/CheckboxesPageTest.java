package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.CheckboxesPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CheckboxesPageTest extends TheInternetTestBase{
	
	@Test
	public void canUnCheck() {

		String[] boxesToUnCheck = { "checkbox 2" };
		String[] boxesToCheck = { "checkbox 1" };

		String[] selectedCheckboxes = new CheckboxesPage(driver, baseUrl)
				.navigate()
				.selectCheckboxes(boxesToCheck, true)
				.selectCheckboxes(boxesToUnCheck, false)
				.getSelectedCheckboxes();

		Assert.assertEquals(boxesToCheck, selectedCheckboxes);
	}
	
	@Test
	public void canToggle() {

		String[] boxesToCheck = { "checkbox 1", "checkbox 2" };

		String[] selectedCheckboxes = new CheckboxesPage(driver, baseUrl)
				.navigate()
				.selectCheckboxes(boxesToCheck, true)
				.selectCheckboxes(boxesToCheck, false)
				.getSelectedCheckboxes();

		Assert.assertEquals(selectedCheckboxes.length, 0);
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
