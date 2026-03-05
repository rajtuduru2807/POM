package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverManager;

public class ScreenshotUtil {

	public static String captureScreenshot(String testName) {
		WebDriver driver = DriverManager.getDriver();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/test-output/screenshots/" + testName + ".png";
		try {
			Files.createDirectories(Paths.get(System.getProperty("user.dir") + "/test-output/screenshots/"));
			Files.copy(src.toPath(), Paths.get(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;

	}
}
