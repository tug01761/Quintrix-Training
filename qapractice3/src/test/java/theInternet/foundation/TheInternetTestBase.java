package theInternet.foundation;

import java.io.IOException;
import java.util.HashMap;

import framework.ConfigurationParameters;
import framework.ConfigurationReader;
import framework.DriverManagerFactory;
import framework.TestBase;

public class TheInternetTestBase extends TestBase{

	@Override
	protected void LoadConfigurations() {


		HashMap<String, String> configs = null;

		try {
			configs = new ConfigurationReader().getPropertiesFromResourceFile("config.properties");
		} catch (IOException e) {
			throw new RuntimeException("Config file does not exist.");
		}

		driverManager = DriverManagerFactory.getManager(configs.get(ConfigurationParameters.Firefox));
		driver = driverManager.startService();

		this.baseUrl = configs.get(ConfigurationParameters.UrlTheInternet);		
	}
}
