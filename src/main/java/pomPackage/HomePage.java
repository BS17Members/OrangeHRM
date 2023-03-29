package pomPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriverWait wait;
	@FindBy(xpath="(//a[contains(@class,\"menu-item\")])[1]")       // Data Members(variables)
	private WebElement Admin;                // ..
	
	@FindBy(xpath="(//a[contains(@class,\"menu-item\")])[2]")        // ..
	private WebElement PIM;                // ..
	
	@FindBy(xpath="(//a[contains(@class,\"menu-item\")])[3]")    // ..
	private WebElement Leave;             // ..
	
	
	@FindBy(xpath="//img[@alt=\"client brand banner\"]")    // ..
	private WebElement Logo;    
	
	
	public HomePage(WebDriver driver)         // Constructor
	{
		PageFactory.initElements(driver, this);  // to avoid StaleElem. Exception
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	
	public boolean verifyAdminOption() throws InterruptedException    // Method
	{
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//a[contains(@class,\"menu-item\")])[1]")));
		boolean result= Admin.isDisplayed();
		return result;
	}
	
	public boolean verifyPIMOption()     // ..
	{
		boolean result= PIM.isDisplayed();
		return result;
	}
	
	public boolean verifyLeaveOption()        // ..
	{
		boolean result= Leave.isDisplayed();
		return result;
	}

	public boolean checkVisiblityOfLogo()
	{
		boolean result = Logo.isDisplayed();
		return result;
	}
	
	
	
}
