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

public class multipleTabHandle 
{
	WebDriver driver;
	
	@BeforeClass
	public void login()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/browser-windows");
	}
	
	@Test
	public void tabHandle() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		WebElement ClickOnTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabButton")));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", ClickOnTab);
		ClickOnTab.click();
		Thread.sleep(2000);
		
		Set<String> alltabs = driver.getWindowHandles();
		
		Iterator<String> specificTab = alltabs.iterator();
		String tab1 = specificTab.next();
		String tab2 = specificTab.next();
		Thread.sleep(2000);
		
		//Main Tab
		driver.switchTo().window(tab1);	
		driver.navigate().to("https://www.google.com/");
		Thread.sleep(3000);
		
		//Sub-Main Tab
		driver.switchTo().window(tab2);
		driver.navigate().to("https://www.flipkart.com/");
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void ifTestCaseFail(ITestResult result) throws Exception
	{
		File takeSS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Location = new File("C:\\Users\\Mahindarr\\git\\repository\\Practice\\ScreenShots\\"+result.getName()+".png");
		FileUtils.copyFile(takeSS, Location);
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
