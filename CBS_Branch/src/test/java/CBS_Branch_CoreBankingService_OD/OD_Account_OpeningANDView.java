package CBS_Branch_CoreBankingService_OD;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PropertiesCodeForBranch.BranchCode;
import io.github.bonigarcia.wdm.WebDriverManager;

//Pending

public class OD_Account_OpeningANDView 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception 
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
	public void OD_Opening() throws Exception
	{
		//Direct Navigation 
		driver.navigate().to("https://demo.techplex.in/baccounts/overdraft_opening");
		Thread.sleep(2000);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//AccountType
		WebElement accountType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_type")));
		Select selectAccount = new Select(accountType);
		List<WebElement> accounts = selectAccount.getOptions();
		String AT = "Type 1";
		for (int i = 0; i < accounts.size(); i++) 
		{
			if(accounts.get(i).getText().equalsIgnoreCase(AT))
			{
				accounts.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Account Category
		WebElement accountCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_category")));
		Select category = new Select(accountCategory);
		List<WebElement> categorys = category.getOptions();
		String SC = "Individual";
		for (int i = 0; i < categorys.size(); i++) 
		{
			if(categorys.get(i).getText().equalsIgnoreCase(SC))
			{
				categorys.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//memberID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("depositor_memberid"))).click();
		System.out.println("----------Add Member ID Manually----------");
		Thread.sleep(2000);
		
		//ReferredDetails
		//AgentID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reffered-by"))).sendKeys("SWMT-A0026");
		Thread.sleep(2000);
		
		//Overdraft Details
		//is Overdraft
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='is_overdraft']"))).click();
		Thread.sleep(2000);
		
		//Overdraft Limit Account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("overdraft_limit_amount"))).sendKeys("200000");
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(""))).click();
		System.out.println("----------Copy Account Number----------");
		Thread.sleep(10000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);	
			
	}
	
	@Test(priority = 3)
	public void viewAccount() throws Exception
	{
		//navigate to Search 
		driver.navigate().to("https://demo.techplex.in/od_viewacc");
		Thread.sleep(2000);
		
		//searchType
		WebElement searchType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_type")));
		Select selectSearch = new Select(searchType);
		List<WebElement> types = selectSearch.getOptions();
		String SST = "Account No.";
		for (int i = 0; i < types.size(); i++) 
		{
			if(types.get(i).getText().equalsIgnoreCase(SST))
			{
				types.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
				
		//searchContent
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_content"))).click();
		System.out.println("----------Add Account No----------");
		Thread.sleep(10000);
				
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='Submit']"))).click();
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
