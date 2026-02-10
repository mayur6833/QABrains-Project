package SelenumCode;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookStoreApplication 
{
	WebDriver driver;
	WebDriverWait wait;
	String username;
	String password;
	
	@BeforeClass
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/login");
	}
	
	@Test(priority = 1)
	public void register() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//new User
		WebElement newUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newUser")));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", newUser);
		newUser.click();
		//firstName
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname"))).sendKeys("John");
		//LastName
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastname"))).sendKeys("Cena");
		//username
		
		WebElement ID = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
		ID.sendKeys("Selenium");
		username = ID.getAttribute("value");
		System.out.println("Username: "+username);
		//Password
		WebElement Pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		Pass.sendKeys("Selenium@123");
		password = Pass.getAttribute("value");
		System.out.println("Password: "+password);
		//CheckBox
		Thread.sleep(5000);
		//register
		
		WebElement registerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("register")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", registerButton);
		registerButton.click();
		Thread.sleep(2000);
		//Alert
		try {
			Alert alertAccept = wait.until(ExpectedConditions.alertIsPresent());
			alertAccept.accept();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Alert is Not working"+ e.getMessage());
		}
		//BackToLogin
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gotologin"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2, dependsOnMethods = {"register"})
	public void logIn() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Login
		WebElement loginID = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", loginID);
		loginID.sendKeys(username);
		
		//Password
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(password);
		
		//login
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login"))).click();
		Thread.sleep(2000);	
	}
	
	@AfterMethod
	public void ifTestCaseFail(ITestResult result) throws Exception
	{
		File takeSS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File location = new File("C:\\Users\\Mahindarr\\git\\repository\\Practice\\ScreenShots\\"+result.getName()+"_"+time+".png");
		FileUtils.copyFile(takeSS, location);
	}
	
	@AfterClass
	public void exit()
	{
		if(driver != null)
		{
			driver.quit();
		}
	}
}
