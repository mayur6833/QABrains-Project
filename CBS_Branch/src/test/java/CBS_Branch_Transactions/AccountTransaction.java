package CBS_Branch_Transactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class AccountTransaction extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void AccountTransaction_Navigation() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
//		//ClickOnTransaction
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='menu-title font-medium'][normalize-space()='Transaction']"))).click();
//		Thread.sleep(2000);	
//		//ClickOnAccountTransaction
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Account Transactions']"))).click();
//		Thread.sleep(2000);	
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/transaction/approvetransaction");

//		//Date
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tdate"))).click();
//		Thread.sleep(2000);
//		//month
//		WebElement selectMonth = driver.findElement(By.xpath("//select[@aria-label='Month']"));
//	    Select month = new Select(selectMonth);
//		month.selectByValue("4");
//		Thread.sleep(2000);
//		//year
//		for (int i = 0; i < 1; i++) 
//		{
//			driver.findElement(By.xpath("(//span[@class='arrowDown'])[1]")).click();
//		}
//		Thread.sleep(2000);
//		//SelectDate
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/span[4]"))).click();
		
		//date 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Date"))).click();
		System.out.println("-----------Add date manually----------");
		Thread.sleep(15000);
		
		//ClickOnSearchTransaction
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchButton"))).click();
		Thread.sleep(5000);
		
		//ClickOnOK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void RejectTransaction() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//ClickOnRejectTransaction
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button']"))).click();
		Thread.sleep(2000);
		
		//Date
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Date"))).click();
//		Thread.sleep(2000);
//		//month
//		WebElement selectMonth = driver.findElement(By.xpath("//select[@aria-label='Month']"));
//	    Select month = new Select(selectMonth);
//		month.selectByValue("4");
//		Thread.sleep(2000);
//		//year
//		for (int i = 0; i < 1; i++) 
//		{
//			driver.findElement(By.xpath("(//span[@class='arrowDown'])[1]")).click();
//		}
//		Thread.sleep(2000);
//		//SelectDate
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/span[4]"))).click();
//		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Date"))).click();
		System.out.println("-----------Add date manually----------");
		Thread.sleep(15000);
		
		
		//ClickOnSearchTransaction
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchButton"))).click();
		Thread.sleep(5000);
		
		//ClickOnOK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}	
}
