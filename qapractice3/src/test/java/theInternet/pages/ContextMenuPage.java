package theInternet.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class ContextMenuPage extends PageObjectBase{

	public ContextMenuPage(WebDriver driver, String url) {
		super(driver, url);
	}
			
	Actions actions = new Actions(driver);
	
	@FindBy(id="hot-spot")
	WebElement selectedArea;

	public ContextMenuPage navigate() {
		super.navigate("/context_menu");
		return this;

	}
	
	public ContextMenuPage doRightClick() {

		actions.contextClick(selectedArea).perform();
		return this;
	}

	public String getAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String alertText = alert.getText();
		
		alert.accept();

		return alertText;
	}
}
