package framework;

import java.io.IOException;
import java.util.HashMap;

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
	
	private void LoadConfigurations() {
		
		
		HashMap<String, String> configs = null;
		
		try {
			configs = new ConfigurationReader().getPropertiesFromResourceFile("config.properties");
		} catch (IOException e) {
			throw new RuntimeException("Config file does not exist.");
		}
		
		driverManager = DriverManagerFactory.getManager(configs.get(ConfigurationParameters.Firefox));
		driver = driverManager.startService();

		this.baseUrl = configs.get(ConfigurationParameters.Url);		
	}

}
