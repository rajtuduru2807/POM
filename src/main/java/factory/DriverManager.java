package factory;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	
	private static  ThreadLocal<WebDriver>driver=new ThreadLocal<>();
	
	 // Private constructor → prevents object creation
    private DriverManager() {}

    public static void initDriver(String browser)
    {
    	if(driver.get()==null)
    	{
    		driver.set(DriverFactory.createDriver(browser));
    	}
    }
    public static WebDriver getDriver() {
        return driver.get();
    }
    
    public static void quitDriver() {
        driver.get().quit();
        driver.remove();
    }
}
