package testPackage;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomPackage.HomePage;
import pomPackage.LogInPage;
import testUtlity.ReadFiles;
import testUtlity.StaticBrowser;

public class TestClassTNG extends BaseClass {

	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before Class of Class1");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method of Class1");
	}
	
	@Test
	public void VerifyDashboardElemenents() throws InterruptedException, EncryptedDocumentException, IOException
	{
		logger = report.createTest("Verify Dashboard Elements");
		SoftAssert s = new SoftAssert();
		
		LogInPage login = new LogInPage(driver);				
		//2. Test Case 2
		login.sendUsername(ReadFiles.fetchDataFromExcel(1, 0));
		login.sendPassword(ReadFiles.fetchDataFromExcel(1, 1));
		login.clickOnLoginButton();
		Thread.sleep(1000);
		String ExpectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard";
		String ActualURL= driver.getCurrentUrl();
		
		Assert.assertEquals(ActualURL,ExpectedURL); //fail
	
		HomePage home = new HomePage(driver);
		boolean result1 = home.verifyAdminOption();
		s.assertTrue(result1, "Admin option is present");  
		
		System.out.println("Admin option is present");
		
		boolean result2 = home.verifyPIMOption();
		s.assertTrue(result2, "PIM option is present");   
		//s.assertFalse(result2, "PIM option is not present");
		
		boolean result3 = home.verifyLeaveOption();
		s.assertTrue(result3, "Leave option is present"); 
		
		s.assertAll();
		
//		if (ExpectedURL.equals(ActualURL))
//		{
//			System.out.println("Test Pass");
//		}
//		else 
//		{
//			System.out.println("Test Failed");
//		}
		
//		boolean result = admin.isDisplayed();
		//Hard Assert
		
//		Assert.assertNotEquals(null, null);
//		Assert.assertTrue(result);  //True--> pass
//		Assert.assertFalse(result);   //True --> fail
//		Assert.fail();//fail
//		
//		//SoftAssert
//		SoftAssert s = new SoftAssert();
//		s.assertEquals(result, result);
//		s.assertNotEquals(result, result);
//		s.assertTrue(result);
//		s.assertFalse(result);
//		
//		s.assertAll();
		
//	Assert.fail();
		
	}
	
	@Test
	public void verifyAdmin()
	{
		logger = report.createTest("Verify Admin Tab");

		System.out.println("This is admin test");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class of Class1");
	}
	
	
	
}
