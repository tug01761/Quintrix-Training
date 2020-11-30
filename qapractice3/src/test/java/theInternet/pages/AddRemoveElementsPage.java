package theInternet.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class AddRemoveElementsPage extends PageObjectBase {

	public AddRemoveElementsPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	@FindBy(css="button[onclick]")
	WebElement addElementButton;
	
	public AddRemoveElementsPage navigate() {
		super.navigate("/add_remove_elements/");
		return this;
	}
	
	public AddRemoveElementsPage addElements(int count)
	{
		for(int i = 0; i < count; i++)
		{
			addElementButton.click();
		}
		return this;
	}
	
	public AddRemoveElementsPage removeElements(int count) {
		for(int i = 0; i < count; i++)
		{
			WebElement deleteButton = driver.findElement(By.className("added-manually"));
			deleteButton.click();
		}
		return this;
	}
	
	public int getTotalDelete() {
		WebElement deleteButtons = driver.findElement(By.id("elements"));
		
		return Integer.parseInt(deleteButtons.getAttribute("childElementCount"));
	}



}
