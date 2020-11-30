import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SeleniumTest {
	WebDriver driver;
	
	
  @Test
  public void canLaunchFirefoxDriver() {
	  //Arrange
	  String url = "https://www.google.com/";

	  //Act
	  driver.navigate().to(url);
	  String currentURL = driver.getCurrentUrl();

	  //Assert
	  Assert.assertEquals(currentURL, url);
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
