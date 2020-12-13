package stepdefs;

import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.DropdownPage;
import theInternet.pages.MultipleWindowsNewPage;
import theInternet.pages.MultipleWindowsPage;

public class stepDefinitionsTheInternet extends TheInternetTestBase{

/************************************************************************************************/

	//MultipleWindows Feature
	
	@Given("^I am on the theinternet Multiple Windows page$")
	public void I_am_on_the_theinternet_Multiple_Windows_page() throws Throwable {
		super.beforeTest();
		MultipleWindowsPage multipleWindows = new  MultipleWindowsPage(driver, baseUrl);
		multipleWindows.navigate();
	}

	@When("^I click on the hyperlink in the page$")
	public void I_click_on_the_hyperlink_in_the_page() throws Throwable {
		MultipleWindowsPage multipleWindows = new  MultipleWindowsPage(driver, baseUrl);
		multipleWindows.clickLink();
	}

	@Then("^A new window will pop up$")
	public void A_new_window_will_pop_up() throws Throwable {

	}


	@And("^I will be able to access the new window$")
	public void I_will_be_able_to_access_the_new_window() throws Throwable{
		MultipleWindowsPage multipleWindows = new  MultipleWindowsPage(driver, baseUrl);
		multipleWindows.openNewTab();
	}

	@And("^also I will be able to verify that I am in the right window$")
	public void also_I_will_be_able_to_verify_that_I_am_in_the_right_window() throws Throwable{
		MultipleWindowsNewPage multipleWindowsNewTab = new MultipleWindowsNewPage(driver, baseUrl);
		String expectedUrl = "http://the-internet.herokuapp.com/windows/new";
		String selectedUrl = multipleWindowsNewTab.getNewWindowUrl();

		Assert.assertEquals(selectedUrl, expectedUrl);
		
		super.afterTest();
	}
	

/************************************************************************************************/

	//DropDown Feature
	
	@Given("I am on the theinternet Dropdown page")
	public void i_am_on_the_theinternet_Dropdown_page() throws Throwable {
		super.beforeTest();
		DropdownPage dropDownPage = new  DropdownPage(driver, baseUrl);
		dropDownPage.navigate();
	}

	@When("I open the dropdown list to see the options")
	public void i_open_the_dropdown_list_to_see_the_options() throws Throwable {
		
	}

	@Then("The dropdown list options will show up")
	public void the_dropdown_list_options_will_show_up() throws Throwable {

	}

	@And("I click on {string}")
	public void i_click_on(String expectedSelection) throws Throwable {
		DropdownPage dropDownPage = new  DropdownPage(driver, baseUrl);
		dropDownPage.select(expectedSelection);
	}

	@And("I also will verify that {string} is being chosen")
	public void i_also_will_verify_that_is_being_chosen(String expectedSelection) throws Throwable {
		String selectedOption = new DropdownPage(driver, baseUrl).getOption();

		Assert.assertEquals(selectedOption, expectedSelection);
		super.afterTest();
	}
	
	
}