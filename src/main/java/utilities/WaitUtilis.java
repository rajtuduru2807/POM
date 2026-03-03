package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverManager;

public class WaitUtilis {

	 private static WebDriverWait getWait(WaitType waitType) {
	        return new WebDriverWait(
	                DriverManager.getDriver(),
	                Duration.ofSeconds(waitType.getTime())
	        );
	    }

	 public static WebElement waitForVisibility(By locator, WaitType waitType) {
	        return getWait(waitType)
	                .until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }
	 public static void waitAndClick(WebElement locator, WaitType waitType) {
	        WebElement element = getWait(waitType)
	                .until(ExpectedConditions.elementToBeClickable(locator));
	        element.click();
	    }
	  // Scroll element into view (center)
	    public static void scrollToElement(WebElement element) {
	    	JavascriptExecutor js = (JavascriptExecutor)DriverManager.getDriver();
	        js.executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest'});",
	            element
	        );
	    }

}
