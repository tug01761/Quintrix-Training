package theInternet.pages;

import org.openqa.selenium.WebDriver;

import framework.PageObjectBase;

public class JQueryUIMenusResultPage extends PageObjectBase{
	
	public JQueryUIMenusResultPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public String getURL() {
		String url = driver.getCurrentUrl();
		
		return url;
	}

}
