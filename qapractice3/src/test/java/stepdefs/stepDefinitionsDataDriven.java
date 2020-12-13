package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataDriven.DataDrivenTestBase;
import dataDriven.DemoFormPage;


public class stepDefinitionsDataDriven extends DataDrivenTestBase{

	@Given("^I am on the automation practice form website$")
	public void I_am_on_the_automation_practice_form_website() throws Throwable{
		super.beforeTest();
		DemoFormPage demoForm = new DemoFormPage(driver, baseUrl);
		demoForm.navigate();
		
	}
	
	@When("^I fill the First Name textbox with \"([^\"]*)\"$")
	public void setFirstName(String arg1) throws Throwable {
		DemoFormPage demoForm = new DemoFormPage(driver, baseUrl);
		demoForm.setFirstName(arg1);
	}
	
	@And("^I fill the Last Name textbox with \"([^\"]*)\"$")
	public void setLastName(String arg1) throws Throwable {
		DemoFormPage demoForm = new DemoFormPage(driver, baseUrl);
		demoForm.setLastName(arg1);
	}
	
	@And("I fill the email textbox with \"([^\"]*)\"$")
	public void setEmail(String arg1) throws Throwable {
		DemoFormPage demoForm = new DemoFormPage(driver, baseUrl);
		demoForm.setEmail(arg1);
	}
	
	@And("^I choose the \"([^\"]*)\" gender$")
	public void setGender(String arg1) throws Throwable {
		DemoFormPage demoForm = new DemoFormPage(driver, baseUrl);
		demoForm.setGender(arg1);
	}
	
	@And("^I fill the Mobile Number textbox with \"([^\"]*)\"$")
	public void setMobileNumber(String arg1) throws Throwable {
		DemoFormPage demoForm = new DemoFormPage(driver, baseUrl);
		demoForm.setMobileNumber(arg1);
	}
	
	@And("^I put \"([^\"]*)\" in the dob textbox$")
	public void setDOB(String arg1) throws Throwable {
		DemoFormPage demoForm = new DemoFormPage(driver, baseUrl);
		demoForm.setDOBWrongFormat(arg1);
	}
	
	@And("^I choose \"([^\"]*)\" as the subjects$")
	public void setSubjects(String arg1) throws Throwable {
		DemoFormPage demoForm = new DemoFormPage(driver, baseUrl);
		demoForm.setSubjects(arg1);
	}
	
	@And("^I check \"([^\"]*)\" as the hobbies$")
	public void setHobbies(String arg1) throws Throwable {
		DemoFormPage demoForm = new DemoFormPage(driver, baseUrl);
		demoForm.setHobbies(arg1);
	}
	
	@And("^I put \"([^\"]*)\" as my Current Address$")
	public void setAddress(String arg1) throws Throwable {
		DemoFormPage demoForm = new DemoFormPage(driver, baseUrl);
		demoForm.setAddress(arg1);
	}
	
	@And("^I choose \"([^\"]*)\" as my State$")
	public void setState(String arg1) throws Throwable {
		DemoFormPage demoForm = new DemoFormPage(driver, baseUrl);
		demoForm.setState(arg1);
	}
	
	@And("^I choose \"([^\"]*)\" as my City$")
	public void setCity(String arg1) throws Throwable {
		DemoFormPage demoForm = new DemoFormPage(driver, baseUrl);
		demoForm.setCity(arg1);
	}
	
	@Then("^I can submit the form")
	public void I_can_submit_the_form() throws Throwable {
		DemoFormPage demoForm = new DemoFormPage(driver, baseUrl);
		demoForm.submit();
	}
	
	@And("^I will verify that I put the correct informations$")
	public void assertion() throws Throwable {
		DemoFormPage demoForm = new DemoFormPage(driver, baseUrl);
		System.out.println(demoForm.getConfirmation().toString());
		
		super.afterTest();
	}
	
	

}
