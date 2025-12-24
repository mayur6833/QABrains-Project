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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PropertiesCodeForAdmin.AdminCode;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateANDViewServiceCenterUser 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass(alwaysRun = true)
	public void setup() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Taking from admin property code
		AdminCode login = new AdminCode(driver);
		login.LoginAdmin();
	}
	
	@Test(priority = 1)
	public void AddServiceCenterUser() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigate
		driver.navigate().to("https://development.techplex.in/createServiceCenter-user");
		Thread.sleep(2000);
		
		//Branch
		WebElement branch = driver.findElement(By.id("branch"));
		Select selectBranch = new Select(branch);
		List<WebElement> branchOption = selectBranch.getOptions();
		String SB ="Branch for Automation Test";
		for (int i = 0; i < branchOption.size(); i++) 
		{
			if(branchOption.get(i).getText().equalsIgnoreCase(SB))
			{
				branchOption.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Service Center
		WebElement serviceCenter = driver.findElement(By.id("service_center"));
		Select selectServiceCenter= new Select(serviceCenter);
		List<WebElement> serviceCenterOption = selectServiceCenter.getOptions();
		String SS ="New Automation Service Center (SVC-100)";
		for (int i = 0; i < serviceCenterOption.size(); i++) 
		{
			if(serviceCenterOption.get(i).getText().equalsIgnoreCase(SS))
			{
				serviceCenterOption.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Account Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("code"))).sendKeys("000000000001");
		Thread.sleep(2000);
		
		//Transaction Limit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount_limit"))).sendKeys("5000000");
		Thread.sleep(2000);
		
		//State
		WebElement state = driver.findElement(By.id("state"));
		Select selectState = new Select(state);
		List<WebElement> stateOptions = selectState.getOptions();
		String Ss = "Maharashtra";
		for (int i = 0; i < stateOptions.size(); i++) 
		{
			if(stateOptions.get(i).getText().equalsIgnoreCase(Ss))
			{
				stateOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Contact Information
		//Contact person Name 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contact_name"))).sendKeys("Mayur");
		Thread.sleep(2000);
		
		//Mobile Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobile_no"))).sendKeys("8787878787");
		Thread.sleep(2000);
		
		//Phone Number 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone"))).sendKeys("0209876578");
		Thread.sleep(2000);
		
		//Email
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("branchautomationservicecenteruser@gmal.com");
		Thread.sleep(2000);
		
		//Pin Code
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pincode"))).sendKeys("411043");
		Thread.sleep(2000);
		
		//Complete Address
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address"))).sendKeys("Hinjewadi, Ring road, Pune-411043");
		Thread.sleep(2000);
		
		//Create Service Center User
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-submit']"))).click();
		Thread.sleep(2000);
		
		//ok
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
	}
	
	@Test(priority = 2)
	public void viewServiceCenterUser() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigate
		driver.navigate().to("https://development.techplex.in/viewServiceCenter-user");
		Thread.sleep(2000);
		
		//Branch
		WebElement branch = driver.findElement(By.id("branch"));
		Select selectBranch = new Select(branch);
		List<WebElement> branchOption = selectBranch.getOptions();
		String SB ="Branch for Automation Test";
		for (int i = 0; i < branchOption.size(); i++) 
		{
			if(branchOption.get(i).getText().equalsIgnoreCase(SB))
			{
				branchOption.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Service Center
		WebElement serviceCenter = driver.findElement(By.id("service_center"));
		Select selectServiceCenter= new Select(serviceCenter);
		List<WebElement> serviceCenterOption = selectServiceCenter.getOptions();
		String SS ="New Automation Service Center (SVC-100)";
		for (int i = 0; i < serviceCenterOption.size(); i++) 
		{
			if(serviceCenterOption.get(i).getText().equalsIgnoreCase(SS))
			{
				serviceCenterOption.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
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
