package CBS_Admin_HRModule;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PropertiesCodeForAdmin.AdminCode;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateViewEmployee 
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
		
		//Taking from Admin Property code
		AdminCode login = new AdminCode(driver);
		login.LoginAdmin();
	}
	
	@Test(priority = 1)
	public void CreateViewEmployee_Navigation() throws Exception
	{
//		//scrollDown
//		WebElement scrolldown1 = driver.findElement(By.xpath("//span[contains(text(),'Terminal Management')]"));
//		Actions act1= new Actions(driver);
//		act1.moveToElement(scrolldown1).build().perform();
//		Thread.sleep(2000);
//		
//		//ClickOnHRModule
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Hr-Module')]"))).click();
//		Thread.sleep(2000);	
//		
//		//scrollDown
//		WebElement scrolldown2 = driver.findElement(By.xpath("//span[normalize-space()='View Monthly Attendance']"));
//		Actions act2 = new Actions(driver);
//		act2.moveToElement(scrolldown2).build().perform();
//		Thread.sleep(2000);
//		
//		//ClickOnFundDeposit 
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Create/View Employee']"))).click();
//		Thread.sleep(2000);	
		
		driver.navigate().to("https://app.sonamuralamps.com/settings/create_employee");
		Thread.sleep(2000);
		
		logger.info("CreateViewEmployee_Navigation() Executed");
	}	
	
	@Test(priority = 2)
	public void CreateEmployee() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Designation
		WebElement designation = driver.findElement(By.xpath("//select[@name='designation']"));
		Select selectRole = new Select(designation);
		List<WebElement> roleOptions = selectRole.getOptions();
		String DIS = "Senior Tester Sonam";
		for (int i = 0; i < roleOptions.size(); i++) 
		{
			if(roleOptions.get(i).getText().equalsIgnoreCase(DIS))
			{
				roleOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Branch
		WebElement branch = driver.findElement(By.xpath("//select[@name='branch_code']"));
		Select selectBranch = new Select(branch);
		List<WebElement> branchOptions = selectBranch.getOptions();
		String BR = "Sonam New Company";
		for (int i = 0; i < branchOptions.size(); i++) 
		{
			if(branchOptions.get(i).getText().equalsIgnoreCase(BR))
			{
				branchOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//State
		WebElement state = driver.findElement(By.xpath("//select[@name='state']"));
		Select selectState = new Select(state);
		List<WebElement> stateOptions = selectState.getOptions();
		String ST = "Maharashtra";
		for (int i = 0; i < stateOptions.size(); i++) 
		{
			if(stateOptions.get(i).getText().equalsIgnoreCase(ST))
			{
				stateOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//contact Name 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Contact Name']"))).sendKeys("John");
		Thread.sleep(2000);
		
		//MobileNo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Mobile No']"))).sendKeys("8787878787");
		Thread.sleep(2000);
		
		//PinCode
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Pincode']"))).sendKeys("411009");
		Thread.sleep(2000);
		
		//Phone No
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Phone No']"))).sendKeys("020987654");
		Thread.sleep(2000);
		
		//email
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Email']"))).sendKeys("seniortestersonam1@gmail.com");
		Thread.sleep(2000);
		
		//Address
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Address']"))).sendKeys("Hinjewdi, Pune");
		Thread.sleep(2000);
		
		//Username
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Username']"))).sendKeys("seniortestersonam1@gmail.com");
		Thread.sleep(2000);
		
		//Password
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("seniortestersonam1@gmail.com");
		Thread.sleep(2000);
		
		//ConfirmPassword
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("conf_password"))).sendKeys("seniortestersonam1@gmail.com");
		Thread.sleep(2000);
		
		//CreateEmployee
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btnsubmit']"))).click();
		Thread.sleep(2000);
		
		//Ok
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void CheckLoginEmployee() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.get("https://app.sonamuralamps.com/login");
//		driver.navigate().to("");
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("seniortestersonam1@gmail.com");
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password2"))).sendKeys("seniortestersonam1@gmail.com");
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
