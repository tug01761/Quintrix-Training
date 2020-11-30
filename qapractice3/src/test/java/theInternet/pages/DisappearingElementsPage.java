package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class DisappearingElementsPage extends PageObjectBase{

	public DisappearingElementsPage(WebDriver driver, String url) {
		super(driver, url);
	}

	@FindBy(className="example")
	WebElement options;

	public DisappearingElementsPage navigate() {
		super.navigate("/disappearing_elements");
		return this;
	}

	public String refreshPage() {
		String hiddenElement = null;
		Boolean found = false;

		

		while(found == false)
		{
			String pageSource = driver.getPageSource();
			if(pageSource.contains("Gallery"))
			{
				hiddenElement = "Gallery";
				found = true;
			}
			else
			{
				driver.navigate().refresh();
			}
		}
		

		return hiddenElement;
	}


}
