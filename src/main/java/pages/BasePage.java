package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverManager;

public class BasePage {
	
	protected WebDriver driver;
	 protected WebDriverWait wait;
	 
	 
	 public BasePage(WebDriver driver) {
	        this.driver = DriverManager.getDriver();
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }

}
