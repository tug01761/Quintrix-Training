package framework;

public class DriverManagerFactory {

	public static DriverManager getManager(String type) {
		
		DriverManager driverManager = null;
		
		if (type.equalsIgnoreCase("FIREFOX"))
		{
			driverManager = new FirefoxDriverManager();
		}
		
		
		
		return driverManager;
	}
	

}