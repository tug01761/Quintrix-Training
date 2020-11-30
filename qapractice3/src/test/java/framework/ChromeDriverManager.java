package framework;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager{

	private ChromeDriver chromeDriver;

	@Override
	public WebDriver startService() {
		if (chromeDriver == null)
		{
			try {
				URL url = ClassLoader.getSystemResource("chromedriver.exe");
				Paths.get(url.toURI()).toString();
				System.setProperty("webdriver.chrome.driver", Paths.get(url.toURI()).toString());
			}
			catch (URISyntaxException e) {
				e.printStackTrace();
			}
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
