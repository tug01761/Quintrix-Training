package framework;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class TestBase {
	protected FirefoxDriver webDriver;
	protected String baseUrl;
	
	protected void beforeTest() {
		LoadConfigurations();
	}
	
	protected void afterTest() {
		this.webDriver.quit();
	}
	
	private void LoadConfigurations() {
		URL url = ClassLoader.getSystemResource("geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "D:\\Eclipse Workspace\\Quintrix-Training\\qapractice3\\target\\test-classes\\geckodriver.exe");//works with "D:\\Eclipse Workspace\\Quintrix-Training\\qapractice3\\target\\test-classes\\geckodriver.exe"
																	//didnt work with urk.getFile();
		
		this.webDriver = new FirefoxDriver();
		
		HashMap<String, String> configs = null;
		
		try {
			configs = new ConfigurationReader().getPropertiesFromResourceFile("config.properties");
		} catch (IOException e) {
			throw new RuntimeException("Config file does not exist.");
		}

		this.baseUrl = configs.get(ConfigurationParameters.Url);		
	}

}
