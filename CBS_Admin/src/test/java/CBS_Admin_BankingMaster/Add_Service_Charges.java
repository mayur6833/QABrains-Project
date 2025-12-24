package CBS_Admin_BankingMaster;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import loginAdmin.baseLoginForAllAdminModules;

public class Add_Service_Charges extends baseLoginForAllAdminModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void AddServiceCharges() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/transaction/addService-charge");
		Thread.sleep(2000);
		
		//Service Charge name 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-charge-name"))).sendKeys("Automation Test Charge");
		
		//Service Charge
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("comission"))).sendKeys("100");
		Thread.sleep(2000);
		
		//Active
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='is-active']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='is-active']"))).click();
		Thread.sleep(2000);
		
		//Add
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Add']"))).click();
		Thread.sleep(5000);
	}
}
