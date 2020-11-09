package framework;

import org.openqa.selenium.WebElement;

public class Input {
	WebElement mappedElement;
	
	public Input(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}
	
	public void setInteger(int expectedInput) {
		mappedElement.sendKeys(String.valueOf(expectedInput));
		int value = Integer.parseInt(mappedElement.getAttribute("value"));
		if(value != expectedInput) {
			throw new RuntimeException("value was not set");
		}
	}
	
	

}
