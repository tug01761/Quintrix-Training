package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class CheckboxPage extends PageObjectBase{

	public CheckboxPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	@FindBy(css="input[type='checkbox']")
	WebElement checkBox;
	
	public CheckboxPage navigate() {
		super.navigate("/checkboxes");
		return this;
	}
	
	public CheckboxPage check() {
		checkBox.click();
		return this;
	}
	
	public Boolean getStatus() {
		return checkBox.isSelected();
	}

}
