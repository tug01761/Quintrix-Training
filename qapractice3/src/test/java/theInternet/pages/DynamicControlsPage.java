package theInternet.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import framework.PageObjectBase;

public class DynamicControlsPage extends PageObjectBase {

	public DynamicControlsPage(WebDriver driver, String url) {
		super(driver, url);
	}

	@FindBy(css="button[onclick='swapInput()']")
	WebElement enableButton;

	@FindBy(id ="message")
	WebElement alertMessage;

	public DynamicControlsPage navigate() {
		super.navigate("/dynamic_controls");
		return this;
	}

	public DynamicControlsPage enableInput() {
		enableButton.click();
		return this;
	}

	public DynamicControlsPage setText() {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS) 
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() 
		{
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(By.id("message"));
				String getTextOnPage = element.getText();
				if(getTextOnPage.equals("It's enabled!")){
					driver.findElement(By.cssSelector("input[type='text']")).sendKeys("It's working now!");
					return element;
				}else{
					System.out.println("FluentWait Failed");
					return null;
				}
			}
		});



			//wait.until(alertMessage.getText() == "It's enabled!");
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='text']")));

			//driver.findElement(By.cssSelector("input[type='text']")).sendKeys("It's working now!");

			return this;
		}

		public String getText() {

			return driver.findElement(By.cssSelector("input[type='text']")).getAttribute("value");
		}

	}
