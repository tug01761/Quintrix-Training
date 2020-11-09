import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TheInternet {
	WebDriver driver;
	
	
  @Test
  public void canLaunchFirefoxDriver() {
	  //Arrange
	  String url = "http://the-internet.herokuapp.com/";

	  //Act
	  driver.navigate().to(url);
	  String currentURL = driver.getCurrentUrl();

	  //Assert
	  Assert.assertEquals(currentURL, url);
  }
  
  @Test
  public void canNavigateToIndexPage() {
	  //Arrange
	  String url = "http://the-internet.herokuapp.com/";
	  String expectedPageTitle = "The Internet";

	  //Act
	  String actualPageTitle = new IndexPage(driver, url)
			  					  .navigate()
			  					  .getTitle();
	  
	  //Assert
	  Assert.assertEquals(actualPageTitle, expectedPageTitle);
  }
  
  @Test
  public void tc8canSelectDropdownListItem() {
	  //Arrange
	  String url = "http://the-internet.herokuapp.com/";
	  String expectedSelection = "Option 2";

	  //Act
	  String selectedOption = new DropdownPage(driver, url)
			  					  .navigate()
			  					  .select(expectedSelection)
			  					  .getOption();
	  
	  //Assert
	  Assert.assertEquals(selectedOption, expectedSelection);
  }
  

  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\mikel\\OneDrive\\Desktop\\geckodriver.exe");
	  driver = new FirefoxDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
