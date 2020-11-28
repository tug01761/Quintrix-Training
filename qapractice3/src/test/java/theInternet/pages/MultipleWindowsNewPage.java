package theInternet.pages;

import org.openqa.selenium.WebDriver;

import framework.PageObjectBase;

public class MultipleWindowsNewPage extends PageObjectBase {

	public MultipleWindowsNewPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public String getNewWindowUrl() {
		String url = driver.getCurrentUrl();
		
		return url;
	}
}
