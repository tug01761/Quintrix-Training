package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.PageObjectBase;
import framework.TableControlExtension;

public class SortableDataTablesPage extends PageObjectBase{

	public SortableDataTablesPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	@FindBy(how=How.ID, using="table1")
	WebElement table1Element;
	
	
	public SortableDataTablesPage navigate() {
		super.navigate("/tables");
		return this;
	}


	public String getAmountDueForUserTableRow1() {
		String text = new TableControlExtension(table1Element, driver).getRow(1).getCell("Due").getText();
		
		return text;
	}
}
