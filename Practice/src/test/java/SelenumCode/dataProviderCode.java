package SelenumCode;

import java.io.File;
import java.time.Duration;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dataProviderCode 
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
	
	@Test (dataProvider = "signUpData", priority = 1)
	public void SignUp(String firstName, String Surname, String mailID, String password) throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
//		//Create New Account
//		WebElement newAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Create new account']")));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", newAccount);
//		newAccount.click();
		
		//FirstName
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname"))).sendKeys(firstName);
		Thread.sleep(1000);
		
		//Surname
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastname"))).sendKeys(Surname);
		Thread.sleep(1000);
		
		//mail
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("reg_email__"))).sendKeys(mailID);
		Thread.sleep(1000);
		
		//Password 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("reg_passwd__"))).sendKeys(password);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'New password')]"))).sendKeys(password);
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastname"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("reg_email__"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("reg_passwd__"))).clear();

	}
	
	@DataProvider
	public Object[][] signUpData()
	{
		return new Object[][] {
			{"Mahendra", "Yadav", "mahendra1@test.com", "Pass@123"},
            {"Ravi", "Kumar", "ravi@test.com", "Test@456"},
            {"Anita", "Sharma", "anita@test.com", "Demo@789"}
		};
	}
	
	@AfterMethod
	public void ifFailed(ITestResult result) throws Exception
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			File takeSS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File location = new File("C:\\Users\\Mahindarr\\git\\repository\\Practice\\ScreenShots\\"+result.getName()+"_"+".png");
			FileUtils.copyFile(takeSS, location);
		}
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
