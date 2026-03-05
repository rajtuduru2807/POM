package listeners;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import reporting.ExtentManager;
import utilities.ScreenshotUtil;

public class TestListener implements ITestListener {

	private static ExtentReports extent = ExtentManager.getInstance();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		test.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getMethod().getMethodName() + "_" + System.currentTimeMillis();
		String path = ScreenshotUtil.captureScreenshot(testName);
		test.get().pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName() + "_" + System.currentTimeMillis();
		String path = ScreenshotUtil.captureScreenshot(testName);
		test.get().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
