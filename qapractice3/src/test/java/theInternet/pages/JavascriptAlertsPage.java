package theInternet.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class JavascriptAlertsPage extends PageObjectBase{
	
	public JavascriptAlertsPage(WebDriver driver, String url) {
		super(driver, url);
	}
			
	Actions actions = new Actions(driver);
	
	@FindBy(css="button[onclick='jsAlert()']")
	WebElement jsAlert;
	
	@FindBy(css="button[onclick='jsConfirm()']")
	WebElement jsConfirm;
	
	@FindBy(css="button[onclick='jsPrompt()']")
	WebElement jsPrompt;
	
	@FindBy(id="result")
	WebElement resultText;

	public JavascriptAlertsPage navigate() {
		super.navigate("/javascript_alerts");
		return this;

	}
	
	public JavascriptAlertsPage clickJSAlert() {

		jsAlert.click();
		return this;
	}

	public String confirmJSAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String alertText = alert.getText();
		
		alert.accept();

		return alertText;
	}

	public JavascriptAlertsPage clickJSConfirm() {
		
		jsConfirm.click();
		return this;
	}

	public String confirmJSConfirm() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String alertText = alert.getText();
		
		alert.accept();

		return alertText;
	}

	public JavascriptAlertsPage clickJSPrompt() {
		
		jsPrompt.click();
		return this;
	}

	public String confirmJSPrompt() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		alert.sendKeys("Hello World");
		
		alert.accept();

		String result = resultText.getText();
		
		return result;
	}

}
