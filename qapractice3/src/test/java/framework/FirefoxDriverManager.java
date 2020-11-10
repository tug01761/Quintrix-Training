package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {
	
	private FirefoxDriver firefoxDriver;
	
	@Override
	public WebDriver startService() {
		if (firefoxDriver == null)
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Eclipse Workspace\\Quintrix-Training\\qapractice3\\target\\test-classes\\geckodriver.exe");
			firefoxDriver = new FirefoxDriver();
		}
		return firefoxDriver;
	}
	
	@Override
	public void stopService() {
		if (firefoxDriver != null)
		{
			firefoxDriver.quit();
		}
	}

	@Override
	public void createDriver() {
		
	}
}
