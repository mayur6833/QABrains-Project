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

public class Service_Deduction extends baseLoginForAllAdminModules
{
	WebDriverWait wait;
	
	@BeforeTest
	public void serviceDeductionNavigation()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/transaction/service-deduction");
	}
	
	@Test(priority = 1)
	public void serviceDeduction_NEFT() throws InterruptedException
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Select Charges
		WebElement Charges = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select-charges")));
		Select selectCharges = new Select(Charges);
		selectCharges.selectByValue("NEFT");
		Thread.sleep(1000);
		
		//Select Slab
		WebElement Slab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("slab-type")));
		Select selectSlab = new Select(Slab);
		selectSlab.selectByValue("with_slab");
		Thread.sleep(1000);
		
		//Min Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("min-amount"))).sendKeys("100000");
		Thread.sleep(1000);
		
		//Max Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("max-amount"))).sendKeys("1000000");
		Thread.sleep(1000);
		
		//GST Applicable
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='gst-applicable']"))).click();
		//IGST Applicable
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='igst-applicable']"))).click();
		Thread.sleep(1000);
		
		//GST
		WebElement GST = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inclusion")));
		Select selectGST = new Select(GST);
		selectGST.selectByValue("including_gst");
		Thread.sleep(2000);
		
		//Service Charges
		WebElement ServiceCharges = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-charges")));
		Select selectServiceCharges = new Select(ServiceCharges);
		selectServiceCharges.selectByValue("Percent");
		Thread.sleep(2000);
		
		//GST %
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-charges-value"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-charges-value"))).sendKeys("4");
		Thread.sleep(1000);
		
		//Service Charges For Customer
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-charges-customer"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-charges-customer"))).sendKeys("2");
		Thread.sleep(1000);
		
		//Service Charges For Service Center
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-charges-center"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-charges-center"))).sendKeys("1");
		Thread.sleep(1000);
		
		//Grace Period 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grace-period"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grace-period"))).sendKeys("30");
		Thread.sleep(1000);
		
		//Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description"))).sendKeys("Testing Through Automation Testing");
		Thread.sleep(2000);
		
		//Active
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='is-active']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='is-active']"))).click();
		Thread.sleep(1000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit']"))).click();
		Thread.sleep(5000);
	}
	
	@Test(priority = 2)
	public void serviceDeduction_IMPS() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Select Charges
		WebElement Charges = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select-charges")));
		Select selectCharges = new Select(Charges);
		selectCharges.selectByValue("IMPS");
		Thread.sleep(1000);
		
		//Select Slab
		WebElement Slab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("slab-type")));
		Select selectSlab = new Select(Slab);
		selectSlab.selectByValue("with_slab");
		Thread.sleep(1000);
		
		//Min Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("min-amount"))).sendKeys("100000");
		Thread.sleep(1000);
		
		//Max Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("max-amount"))).sendKeys("1000000");
		Thread.sleep(1000);
		
		//GST Applicable
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='gst-applicable']"))).click();
		//IGST Applicable
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='igst-applicable']"))).click();
		Thread.sleep(1000);
		
		//GST
		WebElement GST = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inclusion")));
		Select selectGST = new Select(GST);
		selectGST.selectByValue("including_gst");
		Thread.sleep(2000);
		
		//Service Charges
		WebElement ServiceCharges = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-charges")));
		Select selectServiceCharges = new Select(ServiceCharges);
		selectServiceCharges.selectByValue("Percent");
		Thread.sleep(2000);
		
		//GST %
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-charges-value"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-charges-value"))).sendKeys("4");
		Thread.sleep(1000);
		
		//Service Charges For Customer
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-charges-customer"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-charges-customer"))).sendKeys("2");
		Thread.sleep(1000);
		
		//Service Charges For Service Center
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-charges-center"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-charges-center"))).sendKeys("1");
		Thread.sleep(1000);
		
		//Grace Period 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grace-period"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grace-period"))).sendKeys("30");
		Thread.sleep(1000);
		
		//Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description"))).sendKeys("Testing Through Automation Testing");
		Thread.sleep(2000);
		
		//Active
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='is-active']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='is-active']"))).click();
		Thread.sleep(1000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit']"))).click();
		Thread.sleep(5000);
		
	}
	
	@Test(priority = 3)
	public void serviceDeduction_RTGS() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Select Charges
		WebElement Charges = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select-charges")));
		Select selectCharges = new Select(Charges);
		selectCharges.selectByValue("RTGS");
		Thread.sleep(1000);
		
		//Select Slab
		WebElement Slab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("slab-type")));
		Select selectSlab = new Select(Slab);
		selectSlab.selectByValue("with_slab");
		Thread.sleep(1000);
		
		//Min Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("min-amount"))).sendKeys("100000");
		Thread.sleep(1000);
		
		//Max Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("max-amount"))).sendKeys("1000000");
		Thread.sleep(1000);
		
		//GST Applicable
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='gst-applicable']"))).click();
		//IGST Applicable
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='igst-applicable']"))).click();
		Thread.sleep(1000);
		
		//GST
		WebElement GST = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inclusion")));
		Select selectGST = new Select(GST);
		selectGST.selectByValue("including_gst");
		Thread.sleep(2000);
		
		//Service Charges
		WebElement ServiceCharges = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-charges")));
		Select selectServiceCharges = new Select(ServiceCharges);
		selectServiceCharges.selectByValue("Percent");
		Thread.sleep(2000);
		
		//GST %
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-charges-value"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-charges-value"))).sendKeys("4");
		Thread.sleep(1000);
		
		//Service Charges For Customer
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-charges-customer"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-charges-customer"))).sendKeys("2");
		Thread.sleep(1000);
		
		//Service Charges For Service Center
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-charges-center"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-charges-center"))).sendKeys("1");
		Thread.sleep(1000);
		
		//Grace Period 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grace-period"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grace-period"))).sendKeys("30");
		Thread.sleep(1000);
		
		//Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description"))).sendKeys("Testing Through Automation Testing");
		Thread.sleep(2000);
		
		//Active
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='is-active']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='is-active']"))).click();
		Thread.sleep(1000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit']"))).click();
		Thread.sleep(5000);
	}
}
