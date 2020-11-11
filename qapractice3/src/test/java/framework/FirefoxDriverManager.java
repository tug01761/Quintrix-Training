package framework;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {
	
	private FirefoxDriver firefoxDriver;
	
	@Override
	public WebDriver startService() {
		if (firefoxDriver == null)
		{
			try {
			URL url = ClassLoader.getSystemResource("geckodriver.exe");
			Paths.get(url.toURI()).toString();
            System.setProperty("webdriver.gecko.driver", Paths.get(url.toURI()).toString());
			}
            catch (URISyntaxException e) {
            	e.printStackTrace();
            }
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
