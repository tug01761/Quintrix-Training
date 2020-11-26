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
		subjectsTextBox.sendKeys(input);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		subjectsTextBox.sendKeys(Keys.ENTER);
		
		return this;
	}

	public DemoFormPage setHobbies(String input) {
Actions actions = new Actions(driver);
		
		if(input == "Sports")
		{
			actions.moveToElement(sportsCheckbox).click().build().perform();
			//maleGenderRadio.click();
		}
		else if(input == "Reading")
		{
			actions.moveToElement(readingCheckbox).click().build().perform();
			//femaleGenderRadio.click();
		}
		else if(input =="Music")
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
	
}
