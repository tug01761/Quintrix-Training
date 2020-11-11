package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.CheckboxControlExtension;
import framework.PageObjectBase;

public class CheckboxesPage extends PageObjectBase{

	public CheckboxesPage(WebDriver driver, String url) {
		super(driver, url);
	}

	@FindBy(id="checkboxes")
	WebElement checkboxElement;
	
	public CheckboxesPage navigate() {
		super.navigate("/checkboxes");
		
		return this;
	}

	public CheckboxesPage selectCheckboxes(String[] boxesToCheck, boolean isChecked) {
		new CheckboxControlExtension(checkboxElement, driver).setByLabel(boxesToCheck, isChecked);

		return this;
	}

	public String[] getSelectedCheckboxes() {
		return new CheckboxControlExtension(checkboxElement, driver).getLabelsForChecked();
	}
}
