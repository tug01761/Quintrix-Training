package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class ChallengingDOMPage extends PageObjectBase {

	public ChallengingDOMPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	@FindBy(className="button.success")
	WebElement bazButton;

	
	public ChallengingDOMPage navigate() {
		super.navigate("/challenging_dom");
		return this;
	}
	
	public ChallengingDOMPage clickButton() {
		bazButton.click();
		return this;
	}
	
	public Boolean isCanvasExist() {
		Boolean exist = false;
		
		int canvasHeight = 200;
		
		WebElement canvas = driver.findElement(By.id("canvas"));
		if (Integer.parseInt(canvas.getAttribute("height")) == canvasHeight)
		{
			exist = true;
		}
		return exist;
	}
}
