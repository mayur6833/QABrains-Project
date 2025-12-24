package CBS_Branch_CreditServiceCenter;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class Add_Credit_Service_Center_And_View_Credit_Request extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void Add_Credit_Service_Center_Navigation() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//ClickOnCreditServiceCenter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='menu-title font-medium'][normalize-space()='Credit Service Center']"))).click();
		Thread.sleep(2000);	
		
		//ClickOnAddCreditServiceCenter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Add Credit Service Center']"))).click();
		Thread.sleep(2000);	

	}

	@Test(priority = 2)
	public void Add_Credit_Service_Center_Actions() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//TransactionDate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transactionDate"))).click();
		Thread.sleep(2000);
		
		//ChooseService
		WebElement chooseServiceCenter = driver.findElement(By.id("serviceCenter"));
		Select selectServiceCenter = new Select(chooseServiceCenter);
		List<WebElement> centers = selectServiceCenter.getOptions();
		String SC = "Techplex Service Center";
		for (int i = 0; i < centers.size(); i++) 
		{
			if(centers.get(i).getText().equalsIgnoreCase(SC))
			{
				centers.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//ContactName
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contactName"))).click();
		Thread.sleep(2000);
		
		//MobileNumber
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobileNo"))).click();
		Thread.sleep(2000);
		
		//ServiceCenterLimit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount_limit"))).click();
		Thread.sleep(2000);
		
		//AvailableBalance
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("balance"))).click();
		Thread.sleep(2000);
		
		//EnterAmount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount"))).sendKeys("1000");
		Thread.sleep(2000);
		
		//ModeOfPayment
		WebElement modeOfPayment = driver.findElement(By.id("paymentMode"));
		Select selectModeOfPayment = new Select(modeOfPayment);
		List<WebElement> paymentOptions = selectModeOfPayment.getOptions();
		String MOP = "Cheque";
		for (int i = 0; i < paymentOptions.size(); i++) 
		{
			if(paymentOptions.get(i).getText().equalsIgnoreCase(MOP))
			{
				paymentOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//BankName
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bankNameCheque"))).sendKeys("ICICI Bank");
		Thread.sleep(2000);
		
		//RegistrationNumber
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registrationNo"))).sendKeys("8678");
		Thread.sleep(2000);
		
		//RegistrationDate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registrationDate"))).sendKeys("26052025");
		Thread.sleep(2000);
		
		//Remark
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remarks"))).sendKeys("DONE");
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	
	@Test(priority = 3)
	public void view_Credit_Request() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//ClickOnViewCreditRequest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='View Credit Request']"))).click();
		Thread.sleep(2000);
		
		//Date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='datee']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-label='May 27, 2025']"))).click();
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
}
