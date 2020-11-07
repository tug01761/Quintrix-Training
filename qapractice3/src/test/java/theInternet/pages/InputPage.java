package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.Input;
import framework.PageObjectBase;


public class InputPage extends PageObjectBase {

	public InputPage(WebDriver driver, String url) {
		super(driver, url);
	}

	@FindBy(css="input[type='number']")
	WebElement textBox;

	public InputPage navigate() {
		super.navigate("/inputs");
		return this;
	}

	public InputPage setInteger(int input) {
		Input inputWrapped = new Input(textBox);
		inputWrapped.setInteger(input);
		return this;
	}

	public int getInteger(){
		return Integer.parseInt(textBox.getAttribute("value"));
	}

}