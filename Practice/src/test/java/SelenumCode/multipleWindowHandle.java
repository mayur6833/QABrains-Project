package SelenumCode;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
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
		
		WebElement windowbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("windowButton")));
		windowbtn.click();
		
		Set<String> allWindow = driver.getWindowHandles();
		
		Iterator<String> getSpecificWindow = allWindow.iterator();
		String window1 = getSpecificWindow.next();
		String window2 = getSpecificWindow.next();
		
		//first window(main)
		driver.switchTo().window(window1);
		Thread.sleep(3000);
		//second window
		driver.switchTo().window(window2);
		Thread.sleep(3000);
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
