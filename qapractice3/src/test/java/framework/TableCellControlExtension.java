package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableCellControlExtension {

	private WebElement selectedCell;
	private WebDriver driver;
	
	public TableCellControlExtension(WebElement selectedCell, WebDriver driver) {
		this.selectedCell = selectedCell;
		this.driver = driver;
	}


	public String getText() {
		
		return selectedCell.getText();
	}
}
