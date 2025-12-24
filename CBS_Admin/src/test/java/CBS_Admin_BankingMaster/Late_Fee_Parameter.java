package CBS_Admin_BankingMaster;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import loginAdmin.baseLoginForAllAdminModules;

//Script done (Dev Pending)

public class Late_Fee_Parameter extends baseLoginForAllAdminModules
{
	WebDriverWait wait;
	
	@BeforeTest
	public void LateFeeParameterNavigation()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/transaction/lateFee-parameter");
	}
	
	@Test(priority = 1)
	public void LateFeeParameterDaily() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Premium Type
		WebElement premium = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("premiumType")));
		Select selectPremium = new Select(premium);
		selectPremium.selectByValue("daily");
		Thread.sleep(2000);
		
		//Late fees
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lateFee"))).sendKeys("100");
		Thread.sleep(1000);
		
		//Grace Period
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gracePeriod"))).sendKeys("5");
		Thread.sleep(1000);
		
		//Update Settings
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Update Settings']"))).click();
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void LateFeeParameterMonthly() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Premium Type
		WebElement premium = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("premiumType")));
		Select selectPremium = new Select(premium);
		selectPremium.selectByValue("monthly");
		Thread.sleep(2000);
		
		//Late fees
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lateFee"))).sendKeys("500");
		Thread.sleep(1000);
		
		//Grace Period
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gracePeriod"))).sendKeys("10");
		Thread.sleep(1000);
		
		//Update Settings
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Update Settings']"))).click();
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void LateFeeParameterYearly() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Premium Type
		WebElement premium = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("premiumType")));
		Select selectPremium = new Select(premium);
		selectPremium.selectByValue("yearly");
		Thread.sleep(2000);
		
		//Late fees
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lateFee"))).sendKeys("1000");
		Thread.sleep(1000);
		
		//Grace Period
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gracePeriod"))).sendKeys("15");
		Thread.sleep(1000);
		
		//Update Settings
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Update Settings']"))).click();
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
}
