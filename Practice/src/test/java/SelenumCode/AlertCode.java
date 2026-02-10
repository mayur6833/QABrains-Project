
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertCode 
{
	WebDriver driver;
	
	@BeforeClass
	public void login()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/alerts");
	}
	
	@Test
	public void Alert() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		//Click Button to see alert
		WebElement alert1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alertButton")));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", alert1);
		alert1.click();
		wait.until(ExpectedConditions.alertIsPresent()).accept();
		Thread.sleep(2000);
		
		//On button click, alert will appear after 5 seconds
		WebElement alert2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timerAlertButton")));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", alert2);
		alert2.click();
		wait.until(ExpectedConditions.alertIsPresent()).accept();
		Thread.sleep(2000);
		
		//On button click, confirm box will appear
		WebElement alert3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmButton")));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", alert3);
		alert3.click();
	    wait.until(ExpectedConditions.alertIsPresent()).dismiss();
		Thread.sleep(2000);
		
		//On button click, prompt box will appear
		WebElement alert4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timerAlertButton")));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", alert4);
		alert4.click();
		org.openqa.selenium.Alert promptAlert = wait.until(ExpectedConditions.alertIsPresent());
		promptAlert.sendKeys("Alert Handle");
		promptAlert.accept();
	}
	
	@AfterMethod
	public void ifTestCaseFail(ITestResult result) throws Exception
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			File TakeSS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File location = new File("C:\\Users\\Mahindarr\\git\\repository\\Practice\\ScreenShots\\"+result.getName()+".png");
			FileUtils.copyFile(TakeSS, location);
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
