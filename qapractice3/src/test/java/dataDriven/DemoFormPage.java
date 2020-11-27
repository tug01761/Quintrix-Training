package dataDriven;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;
import framework.ReactDropdown;
import framework.TableControlExtension;

public class DemoFormPage extends PageObjectBase {





	public DemoFormPage(WebDriver driver, String url) {
		super(driver, url);
	}

	@FindBy(id="firstName")
	WebElement firstNameTextBox;

	@FindBy(id="lastName")
	WebElement lastNameTextBox;

	@FindBy(id="userEmail")
	WebElement emailTextBox;

	@FindBy(id="gender-radio-1")
	WebElement maleGenderRadio;

	@FindBy(id="gender-radio-2")
	WebElement femaleGenderRadio;

	@FindBy(id="gender-radio-3")
	WebElement otherGenderRadio;

	@FindBy(id="userNumber")
	WebElement mobileNumberTextBox;

	@FindBy(id="dateOfBirthInput")
	WebElement dobTextBox;

	@FindBy(id="subjectsInput")
	WebElement subjectsTextBox;

	@FindBy(id="hobbies-checkbox-1")
	WebElement sportsCheckbox;

	@FindBy(id="hobbies-checkbox-2")
	WebElement readingCheckbox;

	@FindBy(id="hobbies-checkbox-3")
	WebElement musicCheckbox;

	@FindBy(id="currentAddress")
	WebElement addressTextbox;

	@FindBy(id="state")
	WebElement stateDropdown;

	@FindBy(id="city")
	WebElement cityDropdown;

	@FindBy(id="submit")
	WebElement submitButton;

	@FindBy(className="table-responsive")
	WebElement confirmationTable;



	public DemoFormPage navigate() {
		super.navigate("");
		return this;
	}

	public DemoFormPage setFirstName(String input) {
		firstNameTextBox.sendKeys(input);
		return this;
	}

	public DemoFormPage setLastName(String input) {
		lastNameTextBox.sendKeys(input);
		return this;
	}

	public DemoFormPage setEmail(String input) {
		emailTextBox.sendKeys(input);
		return this;
	}

	public DemoFormPage setGender(String input) {

		Actions actions = new Actions(driver);

		if(input == "Male")
		{
			actions.moveToElement(maleGenderRadio).click().build().perform();
			//maleGenderRadio.click();
		}
		else if(input == "Female")
		{
			actions.moveToElement(femaleGenderRadio).click().build().perform();
			//femaleGenderRadio.click();
		}
		else if(input =="Other")
		{
			actions.moveToElement(otherGenderRadio).click().build().perform();
			//otherGenderRadio.click();
		}

		return this;
	}

	public DemoFormPage setMobileNumber(String input) {
		mobileNumberTextBox.sendKeys(input);
		return this;
	}

	public DemoFormPage setDOB(String input) {

		String Old_Format = "MM/dd/yyyy";
		String New_Format = "dd MMMM yyyy";
		String newDateString;

		SimpleDateFormat sdf = new SimpleDateFormat(Old_Format);

		try {
			Date d = sdf.parse(input);
			sdf.applyPattern(New_Format);
			newDateString = sdf.format(d);
			dobTextBox.sendKeys(newDateString);
			for(int i = 0; i < newDateString.length(); i++)
			{
				dobTextBox.sendKeys(Keys.ARROW_LEFT);
			}
			for(int i = 0; i < 11; i++)
			{
				dobTextBox.sendKeys(Keys.BACK_SPACE);
			}
			dobTextBox.sendKeys(Keys.ENTER);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return this;
	}


	public DemoFormPage setSubjects(String input) {
		
		String split[] = input.split(", ", 0);
		
		
		for(int i = 0; i < split.length; i++)
		{
		subjectsTextBox.sendKeys(split[i]);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		subjectsTextBox.sendKeys(Keys.ENTER);
		subjectsTextBox.sendKeys(Keys.TAB);
		}

		return this;
	}

	public DemoFormPage setHobbies(String input) {
		Actions actions = new Actions(driver);

		
		
		if(input.contains("Sports"))
		{
			actions.moveToElement(sportsCheckbox).click().build().perform();
			//maleGenderRadio.click();
		}
		if(input.contains("Reading"))
		{
			actions.moveToElement(readingCheckbox).click().build().perform();
			//femaleGenderRadio.click();
		}
		if(input.contains("Music"))
		{
			actions.moveToElement(musicCheckbox).click().build().perform();
			//otherGenderRadio.click();
		}

		return this;
	}

	public DemoFormPage setAddress(String input) {
		addressTextbox.sendKeys(input);
		return this;
	}

	public DemoFormPage setState(String input) {
		ReactDropdown reactStateDropdown = new ReactDropdown(stateDropdown);
		reactStateDropdown.selectByText(input);
		return this;
	}

	public DemoFormPage setCity(String input) {
		ReactDropdown reactCityDropdown = new ReactDropdown(cityDropdown);
		reactCityDropdown.selectByText(input);
		return this;
	}

	public DemoFormPage submit() {
		submitButton.click();
		return this;
	}

	public Student getConfirmation() {

		String confirmationName = new TableControlExtension(confirmationTable, driver).getRow(1).getCell("Values").getText();

		String split1[] = confirmationName.split(" ", 0);
		String confirmationFirstName = split1[0];
		String confirmationLastName = split1[1];


		String confirmationEmail = new TableControlExtension(confirmationTable, driver).getRow(2).getCell("Values").getText();
		String confirmationGender = new TableControlExtension(confirmationTable, driver).getRow(3).getCell("Values").getText();
		String confirmationMobileNumber = new TableControlExtension(confirmationTable, driver).getRow(4).getCell("Values").getText();
		
		String confirmationDOB = new TableControlExtension(confirmationTable, driver).getRow(5).getCell("Values").getText();
		
		
		String Old_Format = "dd MMMM,yyyy";
		String New_Format = "MM/dd/yyyy";
		String newDateString = null;

		SimpleDateFormat sdf = new SimpleDateFormat(Old_Format);
		
		try {
			Date d = sdf.parse(confirmationDOB);
			sdf.applyPattern(New_Format);
			newDateString = sdf.format(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String confirmationSubjects = new TableControlExtension(confirmationTable, driver).getRow(6).getCell("Values").getText();
		String confirmationHobbies = new TableControlExtension(confirmationTable, driver).getRow(7).getCell("Values").getText();
		String confirmationAddress = new TableControlExtension(confirmationTable, driver).getRow(9).getCell("Values").getText();

		
		
		String confirmationStateAndCity = new TableControlExtension(confirmationTable, driver).getRow(10).getCell("Values").getText();

		String split2[] = confirmationStateAndCity.split(" ", 0);
		String confirmationState = split2[0];
		String confirmationCity = split2[1];
		
		 
		Student confirmationStudent = new Student(confirmationFirstName, confirmationLastName, confirmationEmail, confirmationGender, confirmationMobileNumber, newDateString, confirmationSubjects, confirmationHobbies, confirmationAddress, confirmationState, confirmationCity);
		return confirmationStudent;
	}

}
