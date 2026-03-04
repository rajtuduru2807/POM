package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		if(extent==null)
		{
//			 ExtentSparkReporter spark = new ExtentSparkReporter(
//	                    System.getProperty("user.dir") +"/test-output/ExtentReport.html");
		
//		extent = new ExtentReports();
//        extent.attachReporter(spark);
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        spark.config().setOfflineMode(true);
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Framework", "Singleton POM");
        extent.setSystemInfo("Tester", "Rajkiran");
	}
		return extent;	
	}
	 
}
