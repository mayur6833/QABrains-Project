package CBS_Branch_CoreBankingService_SharePayment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PropertiesCodeForBranch.BranchCode;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Share_Ledger 
{
	WebDriver driver;
	WebDriverWait wait;
	
	//Reuse mode: when driver is passed from another class
	public Share_Ledger(WebDriver driver) 
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	// runs only when executed independently
	public Share_Ledger() {}
	
	@BeforeClass
	public void setup() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Taking from branch property code
		BranchCode login = new BranchCode(driver);
		login.LoginBranch();
	}
	
	@Test(priority = 1)
	public void shareLedger() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/share_ledger");
		Thread.sleep(2000);
		
		//Account NO
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acc_no"))).click();
		System.out.println("-----Add Account NO-----");
		Thread.sleep(10000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchButton"))).click();
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
