package loginAdmin;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseLoginForAllAdminModules 
{
	public static WebDriver driver;
	
	@BeforeSuite
	public void setup() throws Exception
	{
		//data driven method
		FileInputStream fis = new FileInputStream("C:\\Users\\Shree\\eclipse-workspace\\CBS_Admin\\configAdmin.properties");
		Properties pro2 = new Properties();
		pro2.load(fis);
		
		//setup
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(pro2.getProperty("URL"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email Address']"))).sendKeys(pro2.getProperty("USERNAME"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordField"))).sendKeys(pro2.getProperty("PASSWORD"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitBtn"))).click();	
	}
	
	@AfterClass
	public void takeScreenShotForFailTestCase(ITestResult result) throws Exception
	{
		try 
		{
			File takeSS = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File location = new File("C:\\Users\\Mahindarr\\eclipse-workspace\\CBS\\CBS_Admin\\FailTestCaseScreenshots\\" +result.getName()+".png");
			FileUtils.copyFile(takeSS, location);
			
		} catch (Exception e) 
		{
			System.out.println("Unable to take Screenshot because "+e.getMessage());
		}
	}
	
	@AfterSuite
	public void exit()
	{
		if(driver != null)
		{
			driver.quit();
		}
	}
}
