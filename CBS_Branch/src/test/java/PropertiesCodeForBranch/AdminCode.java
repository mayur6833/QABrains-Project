package PropertiesCodeForBranch;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCode 
{
	WebDriver driver;
	WebDriverWait wait;
	Properties pro1;
	
	public AdminCode(WebDriver webDriver) throws Exception
	{
		driver = webDriver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		FileInputStream file = new FileInputStream("C:\\Users\\Mahindarr\\eclipse-workspace\\CBS\\CBS_Branch\\configAdmin.properties");
		pro1 = new Properties();
		pro1.load(file);	
	}
	
	public void LoginAdmin() throws Exception
	{
		driver.get(pro1.getProperty("URL"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email Address']"))).sendKeys(pro1.getProperty("USERNAME"));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordField"))).sendKeys(pro1.getProperty("PASSWORD"));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitBtn"))).click();
		Thread.sleep(2000);
	}
}
