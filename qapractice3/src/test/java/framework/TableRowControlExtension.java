package framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableRowControlExtension {

	private WebElement selectedRow;
	private WebDriver driver;
	List<WebElement> columnHeaders;
	WebElement selectedCell;

	public TableRowControlExtension(WebElement selectedRow, WebDriver driver, List<WebElement> columnHeaders) {
		this.selectedRow = selectedRow;
		this.driver = driver;
		this.columnHeaders = columnHeaders;

	}


	public TableCellControlExtension getCell(String columnHeader) {
		List<WebElement> rowElements = this.selectedRow.findElements(By.cssSelector("td"));

		for (int i = 0; i < rowElements.size(); i++) 
		{
			if(columnHeader.contains(columnHeaders.get(i).getText()))
			{
				selectedCell = rowElements.get(i);
			}
		}
		

		return new TableCellControlExtension(selectedCell, driver);
	}

}
