package testPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pomPackage.HomePage;
import pomPackage.LogInPage;

public class TestClassOfHomePage extends BaseClass{

	static SoftAssert s = new SoftAssert();
	HomePage home; 
		
			@BeforeClass
			public void classSetup()
			{
				home =  new HomePage(driver);
				
			}

	
			@BeforeMethod
			public void testCaseSetup()
			{
				System.out.println("This is the before method of home page test class");
			}
		
			
			@Test
			public void VerifyDashboardElements() throws InterruptedException
			{
				logger = report.createTest("Verify Dashboard Elements on Home Page");
				boolean adminResult = home.verifyAdminOption();
				
				s.assertEquals(adminResult, true);
				
				boolean pimResult = home.verifyPIMOption();
				s.assertEquals(pimResult, true);
				
				boolean leaveResult =home.verifyLeaveOption();
				s.assertEquals(leaveResult, true);
				
				s.assertAll();
			}
			
			@Test
			public void VerifyCompanyLogo()
			{
				logger = report.createTest("Verify the company logo on Home Page");
				boolean logoResult = home.checkVisiblityOfLogo();
			}
			
			@AfterClass
			public void classTeardown()
			{
				home =  null;
								
			}
}

