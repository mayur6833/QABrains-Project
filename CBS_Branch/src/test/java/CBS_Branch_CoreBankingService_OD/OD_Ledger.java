package CBS_Branch_CoreBankingService_OD;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import PropertiesCodeForBranch.BranchCode;
import io.github.bonigarcia.wdm.WebDriverManager;

//Pending

public class OD_Ledger 
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
	public void ODLedger() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/od_ledger");
		Thread.sleep(2000);
		
		//Account no 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountNo"))).click();
		System.out.println("-----Add Account no-----");
		Thread.sleep(10000);
		
		//search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-submit']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(10000);
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

