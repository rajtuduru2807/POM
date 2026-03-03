package factory;
 import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.edge.EdgeDriver;

	public class DriverFactory {

	    public static WebDriver createDriver(String browser) {

	        WebDriver driver = null;

	        switch (browser.toLowerCase()) {

	            case "chrome":
	                driver = new ChromeDriver();
	                break;

	            case "firefox":
	                driver = new FirefoxDriver();
	                break;

	            case "edge":
	                driver = new EdgeDriver();
	                break;

	            default:
	                throw new IllegalArgumentException("Browser not supported: " + browser);
	        }
	        driver.manage().window().maximize();
	        return driver;
	    }
	}

