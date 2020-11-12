package theInternet.pages;

import org.openqa.selenium.WebDriver;

import framework.PageObjectBase;

public class FormAuthenticationSecuredPage extends PageObjectBase{
	
	public FormAuthenticationSecuredPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public String getSecuredPage() {
		String url = driver.getCurrentUrl();
		
		return url;
	}

}
