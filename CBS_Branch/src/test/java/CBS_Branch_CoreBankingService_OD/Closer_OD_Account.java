package CBS_Branch_CoreBankingService_OD;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import PropertiesCodeForBranch.BranchCode;
import io.github.bonigarcia.wdm.WebDriverManager;

//Pending

public class Closer_OD_Account 
{
	WebDriver driver;
	WebDriverWait wait;
	
	public void setup() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Taking from branch property code
		BranchCode login = new BranchCode(driver);
		login.LoginBranch();
	}
	
	@Test(priority = 1)
	public void ClosureODAccount() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation
		driver.navigate().to("");
		Thread.sleep(2000);
		
		System.out.println("Closure OD Account section are pending");
	}
	
	@AfterClass
	public void exit() throws Exception
	{
		Thread.sleep(5000);
		if(driver != null)
		{
			driver.close();
		}
	}
}
