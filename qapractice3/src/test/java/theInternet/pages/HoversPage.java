package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class HoversPage extends PageObjectBase{

	public HoversPage(WebDriver driver, String url) {
		super(driver, url);
	}

	@FindBy(xpath="//[@id='content']/div/div[%s]/img,2")
	WebElement hoverObject;
	
	String redirectLinkText = "//[@id='content']/div/div[%s]/div/a,2";

	public HoversPage navigate() {
		super.navigate("/hovers");
		return this;
	}

	public HoversPage hoverObject() {
		Actions action = new Actions(driver);
		
		action.moveToElement(hoverObject).perform();
		WebElement redirectLink = driver.findElement(By.xpath(redirectLinkText));
		redirectLink.click();
		
		return this;
	}

	public String getResult() {
		String url = driver.getCurrentUrl();

		return url;
	}

}
