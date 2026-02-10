package SelenumCode;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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
import org.testng.internal.annotations.ITest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover 
{
	WebDriver driver;
	WebDriverWait wait;
	Actions act1;
	
	@BeforeClass
	public void loginSetUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.flipkart.com/");
	}
	
	@Test
	public void mouseHoverCode() throws Exception, IOException , RuntimeException
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		//Fashion
		WebElement fashion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Fashion']")));
		act1 = new Actions(driver);
		act1.moveToElement(fashion).build().perform();
		Thread.sleep(1000);
		
		try {
			//Electronics
			WebElement electronicsItemList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Electronic']")));
			act1 = new Actions(driver);
			act1.moveToElement(electronicsItemList).build().perform();
			Thread.sleep(1000);
			
		} catch (Exception e) {
			System.out.println("Not Working"+e.getMessage());
		}
		
		
		
		throw new NoSuchElementException("Just checking throw");
	}
	
	@AfterMethod
	public void takeSSIfTestFail(ITestResult result) throws Exception
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			File fis = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File Location = new File("C:\\Users\\Mahindarr\\git\\repository\\Practice\\ScreenShots\\"+result.getName()+".png");
			FileUtils.copyFile(fis, Location);
		}
	}
	
	
	@AfterClass
	public void exit()
	{
		if(driver != null)
		{
			driver.close();
		}
	}

}
