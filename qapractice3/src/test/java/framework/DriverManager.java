package framework;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	
	protected WebDriver driver;
	
	public abstract WebDriver startService();
	
	protected abstract void stopService();
	
	protected abstract void createDriver();
	
	public void quitDriver() {
		if (driver != null) {
			driver.close();
			driver = null;
		}
	}
	
	public WebDriver getDriver() {
		if (driver == null)
		{
			startService();
		}
		return driver;
	}

}
