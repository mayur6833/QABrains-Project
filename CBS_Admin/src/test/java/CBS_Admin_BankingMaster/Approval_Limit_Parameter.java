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

public class Approval_Limit_Parameter extends baseLoginForAllAdminModules
{
	WebDriverWait wait;
	
	@BeforeTest
	public void approveParameterNavigation()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.navigate().to("https://demo.techplex.in/transaction/approvalLimit-parameter");
	}
	
	@Test(priority = 1)
	public void DepositApprovalParameter() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Type Of Transaction
		WebElement typeOfTransaction = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transactionType")));
		Select selectType = new Select(typeOfTransaction);
		selectType.selectByValue("deposit");
		Thread.sleep(2000);
		
		//Branch Name 
		WebElement Branch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("branchName")));
		Select selectBranch = new Select(Branch);
		selectBranch.selectByValue("SWMT-001");
		Thread.sleep(2000);
		
		//UserName
		WebElement Username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
		Select selectUserName = new Select(Username);
		selectUserName.selectByValue("544");
		Thread.sleep(2000);
		
		//Limit Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("limitAmount"))).sendKeys("10000");
		Thread.sleep(2000);
		
		// Save Parameter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save Parameters']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void PaymentApprovalParameter() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Type Of Transaction
		WebElement typeOfTransaction = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transactionType")));
		Select selectType = new Select(typeOfTransaction);
		selectType.selectByValue("payment");
		Thread.sleep(2000);
		
		//Branch Name 
		WebElement Branch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("branchName")));
		Select selectBranch = new Select(Branch);
		selectBranch.selectByValue("SWMT-001");
		Thread.sleep(2000);
		
		//UserName
		WebElement Username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
		Select selectUserName = new Select(Username);
		selectUserName.selectByValue("544");
		Thread.sleep(2000);
		
		//Limit Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("limitAmount"))).sendKeys("10000");
		Thread.sleep(2000);
		
		// Save Parameter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save Parameters']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void TransferApprovalParameter() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Type Of Transaction
		WebElement typeOfTransaction = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transactionType")));
		Select selectType = new Select(typeOfTransaction);
		selectType.selectByValue("transfer");
		Thread.sleep(2000);
		
		//Branch Name 
		WebElement Branch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("branchName")));
		Select selectBranch = new Select(Branch);
		selectBranch.selectByValue("SWMT-001");
		Thread.sleep(2000);
		
		//UserName
		WebElement Username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
		Select selectUserName = new Select(Username);
		selectUserName.selectByValue("544");
		Thread.sleep(2000);
		
		//Limit Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("limitAmount"))).sendKeys("10000");
		Thread.sleep(2000);
		
		// Save Parameter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save Parameters']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
}
