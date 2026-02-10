package SelenumCode;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
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

public class multipleWindowHandle 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void openUrl()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoqa.com/browser-windows");
		
	}
	
	@Test(priority = 1)
	public void windowHandle() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		WebElement newWindowButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("windowButton")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", newWindowButton);
		newWindowButton.click();
		
		Set<String> window = driver.getWindowHandles();
		
		Iterator<String> it = window.iterator();
		String mainWindow = it.next();
		String secondWindow = it.next();
		
		driver.switchTo().window(mainWindow);
		driver.get("https://www.google.com/");
		Thread.sleep(5000);
		driver.switchTo().window(secondWindow);
		driver.get("https://www.flipkart.com/");
		Thread.sleep(5000);	
	}
	
	@AfterMethod
	public void getScreenshotIfFail(ITestResult result) throws Exception
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File location = new File("C:\\Users\\Mahindarr\\git\\repository\\Practice\\ScreenShots\\"+result.getName()+".png");
			FileUtils.copyFile(screenshot, location);
		}
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
