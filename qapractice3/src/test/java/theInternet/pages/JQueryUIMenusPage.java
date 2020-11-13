package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class JQueryUIMenusPage extends PageObjectBase{

	public JQueryUIMenusPage(WebDriver driver, String url) {
		super(driver, url);
	}

	@FindBy(id="ui-id-2")
	WebElement UIMenus;
	

	public JQueryUIMenusPage navigateToPage() {
		super.navigate("/jqueryui/menu#");
		return this;
	}

	public JQueryUIMenusResultPage navigateThroughUIMenus() {
		JQueryUIMenusResultPage resultPage = new JQueryUIMenusResultPage(driver, baseUrl);
		Actions action = new Actions(driver);
		Action mouseOverMenu;
		
		mouseOverMenu = action.moveToElement(UIMenus).build();
		mouseOverMenu.perform();
		
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-5")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-id-5")));
		
		WebElement redirectLink = driver.findElement(By.id("ui-id-5"));
		
		redirectLink.click();
		
		
		return resultPage;
	}

}
