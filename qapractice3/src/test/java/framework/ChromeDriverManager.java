package framework;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager{
	
private ChromeDriver chromeDriver;
	
	@Override
	public WebDriver startService() {
		if (chromeDriver == null)
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Eclipse Workspace\\Quintrix-Training\\qapractice3\\target\\test-classes\\chromedriver.exe");
			//URL url = ClassLoader.getSystemResource("chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", url.getFile());
			chromeDriver = new ChromeDriver();
		}
		return chromeDriver;
	}
	
	@Override
	public void stopService() {
		if (chromeDriver != null)
		{
			chromeDriver.quit();
		}
	}

	@Override
	public void createDriver() {
		
	}

}
