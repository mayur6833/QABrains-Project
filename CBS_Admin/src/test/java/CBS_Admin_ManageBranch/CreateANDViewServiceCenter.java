package CBS_Admin_ManageBranch;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

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

import PropertiesCodeForAdmin.AdminCode;
import io.github.bonigarcia.wdm.WebDriverManager;

// Service Center Name & Mail ID change on every run
// Not Able to login Service Center

public class CreateANDViewServiceCenter 
{
	WebDriver driver;
	WebDriverWait wait;
	String ServiceCenterMailID;
	
	
	@BeforeClass(alwaysRun = true)
	public void setup() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        //Taking From Property Code
        AdminCode LoginBranch = new AdminCode(driver);
        LoginBranch.LoginAdmin();
	}
	
	@Test(priority = 1)
	public void createServiceCenter() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//ok
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Direct Navigate 
		driver.navigate().to("https://demo.techplex.in/createService-center");
		Thread.sleep(2000);
		
		//branch
		WebElement branch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("branch")));
		Select selectBranch = new Select(branch);
		List<WebElement> branchOptions = selectBranch.getOptions();
		String SB="TECHPLEX";
		for (int i = 0; i < branchOptions.size(); i++) 
		{
			if(branchOptions.get(i).getText().equalsIgnoreCase(SB))
			{
				branchOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Service Center Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).click();
		System.out.println("----------Add Center Name Manually----------");
		Thread.sleep(10000);
		
		//State
		WebElement state = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("state")));
		Select selectState = new Select(state);
		List<WebElement> stateOptions = selectState.getOptions();
		String SS = "Maharashtra";
		for (int i = 0; i < stateOptions.size(); i++) 
		{
			if(stateOptions.get(i).getText().equalsIgnoreCase(SS))
			{
				stateOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Contact Information
		//Contact Person Name 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contact_name"))).sendKeys("Ravi");
		Thread.sleep(2000);
		
		//Mobile Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobile_no"))).sendKeys("8877665544");
		Thread.sleep(2000);
		
		//Phone Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone"))).sendKeys("0208877665");
		Thread.sleep(2000);
		
		//email
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).click();
		System.out.println("----------Add Mail ID Manually----------");
		Thread.sleep(10000);
		ServiceCenterMailID = driver.findElement(By.id("email")).getAttribute("value");
		System.out.println(ServiceCenterMailID);
		
		//Pin Code 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pincode"))).sendKeys("411043");
		Thread.sleep(2000);
		
		//Complete Address
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address"))).sendKeys("Hinjewadi, Ring road, Pune-411043");
		Thread.sleep(2000);
		
		//CreateServiceCenter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Create Service Center']"))).click();
		Thread.sleep(5000);
		
		//ok
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void viewServiceCenter() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//directNavigation
		driver.navigate().to("https://demo.techplex.in/viewService-center");
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Branch
		WebElement branch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("branch")));
		Select selectBranch = new Select(branch);
		List<WebElement> branchOptions = selectBranch.getOptions();
		String SB="TECHPLEX";
		for (int i = 0; i < branchOptions.size(); i++) 
		{
			if(branchOptions.get(i).getText().equalsIgnoreCase(SB))
			{
				branchOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(10000);
	}
	
	@Test(priority = 3)
	public void checkLogIn() throws Exception
	{
		//Clear cache
		driver.manage().deleteAllCookies();
		
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		FileInputStream file2 = new FileInputStream("C:\\Users\\Shree\\eclipse-workspace\\CBS_Branch\\configAdmin.properties");
		Properties pro2 = new Properties();
		pro2.load(file2);
		String adminLogin = pro2.getProperty("URL");
		driver.navigate().to(adminLogin);
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email Address']"))).sendKeys(ServiceCenterMailID);	
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordField"))).sendKeys(ServiceCenterMailID);		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitBtn"))).click();	
		Thread.sleep(5000);
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
