package framework;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class TestBase {
	//protected FirefoxDriverManager webDriver;
	protected DriverManager driverManager;
	protected WebDriver driver;
	protected String baseUrl;
	
	protected void beforeTest(String type) {
		LoadConfigurations(type);
	}
	
	protected void afterTest() {
		//this.webDriver.quit();
		this.driverManager.stopService();
	}
	
	private void LoadConfigurations(String type) {
		//URL url = ClassLoader.getSystemResource("geckodriver.exe");
		//System.setProperty("webdriver.gecko.driver", "D:\\Eclipse Workspace\\Quintrix-Training\\qapractice3\\target\\test-classes\\geckodriver.exe");//works with "D:\\Eclipse Workspace\\Quintrix-Training\\qapractice3\\target\\test-classes\\geckodriver.exe"
																	//didnt work with urk.getFile();
		
		//this.webDriver = new FirefoxDriver();
		driverManager = DriverManagerFactory.getManager(type);
		driver = driverManager.startService();
		
		HashMap<String, String> configs = null;
		
		try {
			configs = new ConfigurationReader().getPropertiesFromResourceFile("config.properties");
		} catch (IOException e) {
			throw new RuntimeException("Config file does not exist.");
		}

		this.baseUrl = configs.get(ConfigurationParameters.Url);		
	}

}
