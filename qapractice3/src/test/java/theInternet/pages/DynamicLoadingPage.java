package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class DynamicLoadingPage extends PageObjectBase{

	public DynamicLoadingPage(WebDriver driver, String url) {
		super(driver, url);
	}

	@FindBy(linkText="Example 1: Element on page that is hidden")
	WebElement hyperlinkText;


	public DynamicLoadingPage navigate() {
		super.navigate("/dynamic_loading");
		return this;
	}

	public DynamicLoadingElementPage clickOnLink() {
		DynamicLoadingElementPage elementPage = new DynamicLoadingElementPage(driver, baseUrl);
		
		hyperlinkText.click();
		return elementPage;
	}
}
