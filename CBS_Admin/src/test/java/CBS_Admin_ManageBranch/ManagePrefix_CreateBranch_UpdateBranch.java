package CBS_Admin_ManageBranch;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PropertiesCodeForAdmin.AdminCode;
import io.github.bonigarcia.wdm.WebDriverManager;

//Branch Code = BR-00016 (automation07@gmail.com)
//Branch Code = DEVT-001 (automationbranch@gmail.com)

//Add Prefix
//Create Branch 
//View / Update Branch

public class ManagePrefix_CreateBranch_UpdateBranch 
{
	org.slf4j.Logger logger;
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Taking from Admin property code
		AdminCode login = new AdminCode(driver);
		login.LoginAdmin();
	}
	
	@Test(priority = 1)
	public void addBranchPrefix() throws Exception
	{
		//navigate to Add Branch Prefix
		driver.navigate().to("https://demo.techplex.in/manageBranch/branch_prefix");
		Thread.sleep(2000);
		
		//Add Branch Prefix 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("branch_prefix"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("branch_prefix"))).sendKeys("DEVT");
		Thread.sleep(2000);
		
		//add Employee/Agent Prefix
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emp_agt_prefix"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emp_agt_prefix"))).sendKeys("DEVT");
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit']"))).click();
		Thread.sleep(2000);
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void Create_Branch_Navigation() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
//		//ClickOnManageBranch
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Manage Branch')]"))).click();
//		Thread.sleep(2000);	
//		
//		//ClickOnCreateBranch
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Create Branch']"))).click();
//		Thread.sleep(2000);	
		
		driver.navigate().to("https://demo.techplex.in/manageBranch/create-branch");
		Thread.sleep(2000);	
		
		logger.info("Create_Branch_Navigation() Executed");
	}
	
	@Test(priority = 3)
	public void Create_Branch_Branch_Information() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Branch Name 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("branch-name"))).sendKeys("Branch for Automation Test");
		Thread.sleep(2000);
		
		//State
		WebElement selectState = driver.findElement(By.id("state"));
		Select state = new Select(selectState);
		List<WebElement> stateOptions = state.getOptions();
		String SS="Maharashtra";
		for (int i = 0; i < stateOptions.size(); i++) 
		{
			if(stateOptions.get(i).getText().equalsIgnoreCase(SS))
			{
				stateOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//City
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city"))).sendKeys("Pune");
		Thread.sleep(2000);
		
		//PinCode
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pincode"))).sendKeys("411043");
		Thread.sleep(2000);
		
		//Address
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address"))).sendKeys("Hinjewadi, near Ring road, Pune-411987");
		Thread.sleep(2000);
		
	}
	
	@Test(priority = 4)
	public void Create_Branch_Contact_Information() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//ContactPerson
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contact-name"))).sendKeys("Harry");
		Thread.sleep(2000);
		
		//PhoneNumber
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone"))).sendKeys("0209876599");
		Thread.sleep(2000);
		
		//MobileNo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobile"))).sendKeys("7028500818");
		Thread.sleep(2000);
		
		//EmailAddress
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("branchautomation@gmail.com");
		Thread.sleep(2000);
		
		//ClickOnCreateBranch
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Create Branch']"))).click();
		System.out.println("Copy the branch Code manually");
		Thread.sleep(8000);
		
		//Ok
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 5)
	public void ViewORUpdate_Branch() throws Exception
	{
		//Direct Navigate
		driver.navigate().to("https://demo.techplex.in/viewUpdate-branch");
		Thread.sleep(2000);
		
		System.out.println("ViewORUpdate_Branch() Not working");
	}
	
	@Test(priority = 6)
	public void checkLogIn() throws Exception
	{
		driver.navigate().to("https://demo.techplex.in/");
		Thread.sleep(2000);
		
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("branchautomation@gmail.com");	
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password2"))).sendKeys("branchautomation@gmail.com");		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='loginEmail']//button[@type='submit'][normalize-space()='Login']"))).click();	
		Thread.sleep(2000);
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
