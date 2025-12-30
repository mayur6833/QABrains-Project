package LoginBranch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLoginForAllBranchModules
{
	public static WebDriver driver;
	protected WebDriverWait wait;
	protected Logger log = LogManager.getLogger(this.getClass());
	
	
	@BeforeSuite (alwaysRun = true)
	public void login() throws Exception
	{
		//Date driven test
		FileInputStream fis = new FileInputStream("C:\\Users\\Mahindarr\\eclipse-workspace\\CBS\\CBS_Branch\\configBranch.properties");
		Properties pro1 = new Properties();
		pro1.load(fis);
		log.info("Suit SetUp Completed");

		//setUp
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get(pro1.getProperty("URL"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email Address']"))).sendKeys(pro1.getProperty("USERNAME"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordField"))).sendKeys(pro1.getProperty("PASSWORD"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitBtn"))).click();
	}
	
	@AfterMethod(alwaysRun = true)
	public void takeScreenshotOnFailTestCase(ITestResult result) throws IOException
	{
		if(!result.isSuccess())
		{
			try {
				File FailSS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
				File location = new File("C:\\Users\\Mahindarr\\eclipse-workspace\\CBS\\CBS_Branch\\Screenshots\\" + result.getName()+"_"+timeStamp +".png");
				FileUtils.copyFile(FailSS, location);
				
			} catch (Exception e) 
			{
				log.error("Unable to take Screenshot: "+ e.getMessage());
			}
		}
	}

	@AfterSuite (alwaysRun = true)
	public void exit()
	{
		if(driver != null)
		{
			driver.close();
		}
		log.info("Suit is Sucessfully Ended..!");
	}
}
