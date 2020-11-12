package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class DragAndDropPage extends PageObjectBase{
	
	public DragAndDropPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	@FindBy(css="button[onclick]")
	WebElement addElementButton;
	
	public DragAndDropPage navigate() {
		super.navigate("/drag_and_drop");
		return this;
	}
	
	public DragAndDropPage dragAndDrop() {
		
		return this;
	}
	
	public String getResult() {
		
		return "a";
	}


}
