package pomPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mainUtility.ElementWait;

public class LogInPage
{
	WebDriver driver;
	//WebDriverWait wait;
	
	@FindBy(xpath="//input[@name=\"username\"]")       // Data Members(variables)
	private WebElement Username;                // ..
	
	@FindBy(xpath="//input[@name=\"password\"]")        // ..
	private WebElement Password;                // ..
	
	@FindBy(xpath="//button[contains(.,'Login')]")    // ..
	private WebElement LogInButton;             // ..
	
	
	public LogInPage(WebDriver driver)         // Constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);  // to avoid StaleElem. Exception
		//wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	
	public void sendUsername(String Uname) throws InterruptedException    // Method
	{
		 Thread.sleep(3000);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@name='username']")));
	
		ElementWait.waitForElement("//input[@name='username']", 20, driver);
		Username.sendKeys(Uname);
	}
	
	public void sendPassword(String Pwd)     // ..
	{
		
		
		Password.sendKeys(Pwd);
	}
	
	public void clickOnLoginButton()        // ..
	{
		
	
		LogInButton.click();
		
		
	}
	

}
