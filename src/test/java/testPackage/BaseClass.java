package testPackage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import testUtlity.Screenshot;
import testUtlity.StaticBrowser;

public class BaseClass {
	static WebDriver driver;
	static ExtentTest logger;
	static ExtentReports report;
	static ExtentHtmlReporter extent;
	@Parameters({"browser"})
	@BeforeTest
	public void beforetest(String browser)
	{  
		report = new ExtentReports();
		extent = new ExtentHtmlReporter("test-output"+File.separator+"Reports"+File.separator+System.currentTimeMillis()+".html");
		report.attachReporter(extent);
		
		driver= StaticBrowser.launchBrowser(browser, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", 10);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if (result.getStatus()==ITestResult.FAILURE)
		{
			String path=Screenshot.capturePageScreenshot(driver);
			logger.fail("Test Case is failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
		}
		report.flush();
	}
	
	@AfterTest
	public void aftertest()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
}
