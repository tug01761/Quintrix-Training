package theInternet.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

import framework.PageObjectBase;

public class DynamicLoadingElementPage extends PageObjectBase {

	public DynamicLoadingElementPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	@FindBy(css="button")
	WebElement startButton;
	
	@FindBy(id="finish")
	WebElement finishText;
	
	public DynamicLoadingElementPage clickButton() {
		startButton.click();
		return this;
	}
	
	public String getText() {
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS) 
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() 
		{
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(By.id("finish"));
				String getTextOnPage = element.getText();
				if(getTextOnPage.equals("Hello World!")){
					return element;
				}else{
					return null;
				}
			}
		});
		return element.getText();
	}
	
}
