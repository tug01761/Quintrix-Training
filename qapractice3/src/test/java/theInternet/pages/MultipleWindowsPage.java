package theInternet.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class MultipleWindowsPage extends PageObjectBase{

	
	public MultipleWindowsPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	
	@FindBy(xpath="//div[@id='content']/div/a")
	WebElement redirectLink;
	
	public MultipleWindowsPage navigate() {
		super.navigate("/windows");
		return this;
	}
	
	public MultipleWindowsPage clickLink(){
		redirectLink.click();
		return this;
	}
	
	public MultipleWindowsNewPage openNewTab(){
		MultipleWindowsNewPage newPage = new MultipleWindowsNewPage(driver, baseUrl);
	
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(0));
	    driver.switchTo().window(tabs2.get(1));
		
		return newPage;
	}
}
