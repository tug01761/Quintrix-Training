package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class RedirectLinkPage extends PageObjectBase{
	
	public RedirectLinkPage(WebDriver driver, String url) {
		super(driver, url);
	}

	@FindBy(id="redirect")
	WebElement redirectHyperLink;

	public RedirectLinkPage navigate() {
		super.navigate("/redirector");
		return this;
	}
	
	public RedirectLinkPage redirect() {
		redirectHyperLink.click();
		return this;
	}
	
	public String getPage() {
		String url = driver.getCurrentUrl();
		
		return url;
	}

}
