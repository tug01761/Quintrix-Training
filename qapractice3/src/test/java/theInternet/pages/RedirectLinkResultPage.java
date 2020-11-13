package theInternet.pages;

import org.openqa.selenium.WebDriver;

import framework.PageObjectBase;

public class RedirectLinkResultPage extends PageObjectBase{
	
	public RedirectLinkResultPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public String getPageURL() {
		String url = driver.getCurrentUrl();
		
		return url;
	}

}
