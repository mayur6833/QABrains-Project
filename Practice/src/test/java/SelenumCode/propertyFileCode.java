package SelenumCode;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class propertyFileCode 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.facebook.com/r.php?entry_point=login");
	}
	
	@Test
	public void signUp() throws Exception
	{
		//Property FileLogic
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Mahindarr\\git\\repository\\Practice\\testdata.properties");
		Properties pro = new Properties();
		pro.load(fis);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//FirstName
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname"))).sendKeys(pro.getProperty("testdata1"));
		Thread.sleep(1000);
		
		//Surname
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastname"))).sendKeys(pro.getProperty("testdata2"));
		Thread.sleep(1000);
		
		//mail
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("reg_email__"))).sendKeys(pro.getProperty("testdata3"));
		Thread.sleep(1000);
		
		//Password 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("reg_passwd__"))).sendKeys(pro.getProperty("testdata4"));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'New password')]"))).sendKeys(password);
		Thread.sleep(1000);
	}
	
	@AfterMethod
	public void ifFailed(ITestResult result) throws Exception 
	{
		File takeSS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File location = new File("C:\\Users\\Mahindarr\\git\\repository\\Practice\\ScreenShots\\"+result.getName()+"_"+".png");
		FileUtils.copyFile(takeSS, location);
	}
	
	@AfterClass
	public void tearDown()
	{
		if(driver != null)
		{
			driver.close();
		}
	}
	
}
