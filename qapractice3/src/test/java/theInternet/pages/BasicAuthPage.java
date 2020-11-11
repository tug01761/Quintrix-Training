package theInternet.pages;

import org.openqa.selenium.WebDriver;

import framework.PageObjectBase;

public class BasicAuthPage extends PageObjectBase {
	
	public BasicAuthPage(WebDriver driver, String url) {
		super(driver, url);
	}

	public BasicAuthPage navigate() {
		String pageUrl = new String("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.navigate().to(pageUrl);	
		
		return this;
	}
	
	public String getPageSource() {
		
		String pageSource = driver.getPageSource();
		
		return pageSource;
	}
}
