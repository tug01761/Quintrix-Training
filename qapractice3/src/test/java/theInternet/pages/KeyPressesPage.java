package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class KeyPressesPage extends PageObjectBase{

	public KeyPressesPage(WebDriver driver, String url) {
		super(driver, url);
	}

	@FindBy(id="target")
	WebElement textBox;
	
	@FindBy(id="result")
	WebElement resultText;

	public KeyPressesPage navigate() {
		super.navigate("/key_presses");
		return this;
	}
	
	public KeyPressesPage enterKey() {
		textBox.sendKeys("A");
		return this;
	}

	public String getResult() {
		
		return resultText.getText();
	}

}
