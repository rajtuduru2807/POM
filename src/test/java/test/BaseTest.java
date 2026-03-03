package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverManager;
import utilities.ConfigReader;

public class BaseTest {

	@BeforeMethod
	public void setUp()

	{
		ConfigReader.loadProperties();
		String browser = ConfigReader.getProperty("browser");
		DriverManager.initDriver(browser);
		WebDriver driver = DriverManager.getDriver();
		driver.get(ConfigReader.getProperty("baseurl")); 
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		DriverManager.quitDriver();
	}

}
