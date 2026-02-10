package SelenumCode;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropCode 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoqa.com/droppable");
	}
	
	@Test(priority = 1)
	public void droppable() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		WebElement drag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));
//		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", drag);
		
		WebElement drop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("droppable")));
//		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", drop);
		
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void draggable() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.navigate().to("https://demoqa.com/dragabble");
		
		WebElement dragMe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dragBox")));
//		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", dragMe);
		
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.dragAndDropBy(dragMe, 50, 100).build().perform();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void ifFail(ITestResult result) throws Exception
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			File takeSS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File location = new File("C:\\Users\\Mahindarr\\git\\repository\\Practice\\ScreenShots\\"+result.getName()+".png");
			FileUtils.copyFile(takeSS, location);
		}
		else
		{
			System.out.println("Test Case is pass");
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
