package framework;

public class DriverManagerFactory {

	public static DriverManager getManager(String type) {
		
		DriverManager driverManager = null;
		
		if (type.equalsIgnoreCase("FIREFOX"))
		{
			driverManager = new FirefoxDriverManager();
		}
		else if (type.equalsIgnoreCase("CHROME"))
		{
			driverManager = new ChromeDriverManager();
		}
		
		
		
		return driverManager;
	}
	

}