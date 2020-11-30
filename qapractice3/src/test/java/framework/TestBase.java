package framework;

import org.openqa.selenium.WebDriver;

public abstract class TestBase {
	protected DriverManager driverManager;
	protected WebDriver driver;
	protected String baseUrl;
	
	protected void beforeTest() {
		LoadConfigurations();
	}
	
	protected void afterTest() {
		this.driverManager.stopService();
	}
	
	protected void LoadConfigurations() {
		
			
	}
	

}
