package SelenumCode;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

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

public class CountImagesUsingMouseHover 
{
	private static WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
	}
	
	@Test
	public void logic() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions act = new Actions(driver);
		
		WebElement electronics = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Electronics']")));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", electronics);
		act.moveToElement(electronics).build().perform();
		Thread.sleep(1000);
		
		WebElement cam = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Cameras & Accessories']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", cam);
		act.moveToElement(cam).build().perform();
		cam.click();
		Thread.sleep(1000);
		
		List<WebElement> checkImageCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='s0NCCf']//img")));
		System.out.println("Image Count: "+checkImageCount.size());
	}
	
	@AfterMethod
	public void ifFailed(ITestResult result) throws Exception
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			File takeSS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			File location = new File("C:\\Users\\Mahindarr\\git\\repository\\Practice\\ScreenShots\\"+result.getName()+"_"+time+".png");
			FileUtils.copyFile(takeSS, location);
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







