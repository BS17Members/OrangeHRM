package testPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pomPackage.HomePage;
import pomPackage.LogInPage;

public class TestClass {


	public static void main(String[] args) throws InterruptedException {


		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver.exe");
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(option); // 

		driver.get("https://www.facebook.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		LogInPage login = new LogInPage(driver);				
		//2. Test Case 2
		login.sendUsername("bSpotter");
		login.sendPassword("bg#1");
		login.clickOnLoginButton();



		//1. Test Case 1

		login.sendUsername("BugSpotter");
		login.sendPassword("Bg@1234");
		login.clickOnLoginButton();

		//3. Test Case 3
		HomePage homepage = new HomePage(driver);
		homepage.verifyAdminOption();
		homepage.verifyLeaveOption();
		homepage.verifyLeaveOption();


	}
}
