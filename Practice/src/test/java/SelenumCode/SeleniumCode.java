package SelenumCode;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class SeleniumCode 
{
	WebDriver driver;
	WebDriverWait wait;
	
	public void seleniumCode1()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://example.com/login");
		 
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//username
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ID"))).sendKeys("admin");
		//Password
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ID"))).sendKeys("admin123");
		//ClikOnLogin
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginButton"))).click();
		
		//wait until dashboard visible
		WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")));
		
		Assert.assertTrue(dashboard.isDisplayed());
	}
}
