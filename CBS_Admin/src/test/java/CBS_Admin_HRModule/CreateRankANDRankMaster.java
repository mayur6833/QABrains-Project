package CBS_Admin_HRModule;

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

//Clear the data from backend and then run Script

public class CreateRankANDRankMaster 
{
	WebDriver driver;
	WebDriverWait wait;
	
	//Reuse Mode
	public CreateRankANDRankMaster(WebDriver driver) 
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	//Individual Run
	public CreateRankANDRankMaster() {}
	
	@BeforeClass
	public void setup() throws Exception
	{	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Taking from Admin PropertyCode
		AdminCode login = new AdminCode(driver);
		login.LoginAdmin();
	}
	
	@Test(priority = 1)
	public void navigation() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
//		//click On HR-Module
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Hr-Module')]"))).click();
//		Thread.sleep(2000);
//		
//		//clickOn Create Rank
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Create Rank']"))).click();
//		Thread.sleep(2000);
		
		//Direct Navigate
		driver.navigate().to("https://development.techplex.in/settings/rank");
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void createRank() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//RankID
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("display_rank_id"))).sendKeys("101");
//		Thread.sleep(2000);
		
		//Rank Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rank"))).sendKeys("RANK 07");
		Thread.sleep(2000);
		
		//Rank Commission
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("designation"))).sendKeys("12");
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit']"))).click();
		Thread.sleep(2000);
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void rankMaster() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//navigate to Rank Master
		driver.navigate().to("https://development.techplex.in/settings/rankMasterDesignation");
		Thread.sleep(2000);
		
		//Select Rank
		WebElement selectRank = driver.findElement(By.id("rank"));
		Select selectRanks = new Select(selectRank);
		List<WebElement> rank = selectRanks.getOptions();
		String SR ="RANK 07";
		for (int i = 0; i < rank.size(); i++) 
		{
			if(rank.get(i).getText().equalsIgnoreCase(SR))
			{
				rank.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Select Designation
		WebElement selectDesignation = driver.findElement(By.id("role_id"));
		Select selectDesignations = new Select(selectDesignation);
		List<WebElement> designations = selectDesignations.getOptions();
		String SDS="Employee";
		for (int i = 0; i < designations.size(); i++) 
		{
			if(designations.get(i).getText().equalsIgnoreCase(SDS))
			{
				designations.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Designation Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("designation"))).sendKeys("Senior Automation QA");
		Thread.sleep(2000);
		
		//Status
		WebElement status = driver.findElement(By.id("status"));
		Select selectStatus = new Select(status);
		List<WebElement> statusOptions = selectStatus.getOptions();
		String SS="Active";
		for (int i = 0; i < statusOptions.size(); i++) 
		{
			if(statusOptions.get(i).getText().equalsIgnoreCase(SS))
			{
				statusOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description"))).sendKeys("Rank And Designation added By Automation Script");
		Thread.sleep(2000);
		
		//Submit 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(6000);		
	}
	
	@Test(priority = 4)
	public void manipulateRankORDesignation() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Click On Edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Edit']"))).click();
		Thread.sleep(2000);
		
		//Change Designation Type 
		WebElement selectDesignation = driver.findElement(By.id("role_id"));
		Select selectDesignations = new Select(selectDesignation);
		List<WebElement> designations = selectDesignations.getOptions();
		String SDS="Super Admin";
		for (int i = 0; i < designations.size(); i++) 
		{
			if(designations.get(i).getText().equalsIgnoreCase(SDS))
			{
				designations.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Change Designation
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("designation"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("designation"))).sendKeys("Lead Automation QA");
		Thread.sleep(2000);
		
		//Submit 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(6000);
		
		//Delete
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Delete']"))).click();
		Thread.sleep(2000);
		
		//yes Delete Button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Yes, delete it!']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(6000);	
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
