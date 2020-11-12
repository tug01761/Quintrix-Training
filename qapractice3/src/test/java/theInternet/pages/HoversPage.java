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

	@FindBy(className="figure")
	WebElement hoverObject;
	//@FindBy(xpath="//img[@alt='User Avatar'])[2]")


	//@FindBy(xpath="//a[@href='/users/1']")
	//WebElement redirectLink;

	public HoversPage navigate() {
		super.navigate("/hovers");
		return this;
	}

	public HoversPage hoverObject() {
		Actions action = new Actions(driver);

		action.moveToElement(hoverObject);
		String redirectLink = driver.findElement(By.xpath("//div[@class='figcaption']/a")).getAttribute("href");
		System.out.println(redirectLink);
		//action.moveToElement(redirectLink);
		//action.click();
		//action.perform();

		return this;
	}

	public String getResult() {
		String url = driver.getCurrentUrl();

		return url;
	}

}
