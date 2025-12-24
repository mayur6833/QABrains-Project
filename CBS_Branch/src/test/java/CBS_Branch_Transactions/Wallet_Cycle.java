package CBS_Branch_Transactions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import LoginBranch.BaseLoginForAllBranchModules;

// Re-charge -> Approve -> Report
//   DONE      Pending    Pending
public class Wallet_Cycle extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	double walletAvailableBalanceBeforeAdd;
	int walletNewDepositBalance;
	double walletAvailableBalanceAfterAdd;
	
	@Test(priority = 1)
	public void rechargeStaffEWallet() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/addstaffewallet");
		Thread.sleep(2000);
		
		//Enter Agent No ( SWMT-A0037 )
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("agent_no"))).click();
		System.out.println("----------Add Agent ID----------");
		Thread.sleep(10000);
		
		//Find
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("find_agent"))).click();
		Thread.sleep(2000);
		
		//Wallet Available Balance 
		WebElement availableBalanceBeforeAdd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("balance")));
		String AvailableBalanceBeforeAdd = availableBalanceBeforeAdd.getAttribute("value").replaceAll("[^\\d.]", "").trim();
		walletAvailableBalanceBeforeAdd = Math.round(Double.parseDouble(AvailableBalanceBeforeAdd)* 100.0) / 100.0;
		System.out.println("Balance Before Deposit = " +walletAvailableBalanceBeforeAdd);
		
		//Transaction Type 
		WebElement transationType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deposit_type")));
		Select selectTransactionType = new Select(transationType);
		List<WebElement> types = selectTransactionType.getOptions();
		String TT = "Deposit";
		for (int i = 0; i < types.size(); i++) 
		{
			if(types.get(i).getText().equalsIgnoreCase(TT))
			{
				types.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Mode Of Payment
		WebElement modeOfPayment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payment_mode")));
		Select selectModeOfPayment = new Select(modeOfPayment);
		List<WebElement> types1 = selectModeOfPayment.getOptions();
		String MOP = "Cash";
		for (int i = 0; i < types1.size(); i++) 
		{
			if(types1.get(i).getText().equalsIgnoreCase(MOP))
			{
				types1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Table
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='denomination_100']"))).sendKeys("1");
	    Thread.sleep(2000);
	    
	    //Enter Amount
	    WebElement addAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount")));
	    String balanceAdded = addAmount.getAttribute("value").replaceAll("[^\\d.]", "").trim();
	    walletNewDepositBalance = Math.round(Integer.parseInt(balanceAdded));
	    System.out.println("New Deposit amount = "+walletNewDepositBalance);
	    
	    //Remark
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remarks"))).sendKeys("Done By Automation Testing");
	    Thread.sleep(2000);
	    
	    //Submit
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit']"))).click();
	    System.out.println("----------Copy Voucher No Manually----------");
	    Thread.sleep(10000);
	    
	    //OK
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
	    Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void VoucherApprove() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigate
		driver.navigate().to("https://demo.techplex.in/transaction/showpendingvoucher");
		Thread.sleep(2000);
		
		//addVoucherNumberManualy
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("voucher_no"))).click();
		System.out.println("-------Add Voucher number manually-------");
		Thread.sleep(10000);
		
		//SearchTransaction
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search Transaction']"))).click();
		Thread.sleep(2000);
		
		//Click on Approve voucher
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Approve Voucher']"))).click();
		Thread.sleep(10000);
		
		//ApproveTransaction
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Approve Transaction']"))).click();
		Thread.sleep(2000);
		
		//YesApprove
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Yes, Approve']"))).click();
		Thread.sleep(2000);
		
		//ClickOnOK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void checkWallet() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/addstaffewallet");
		Thread.sleep(2000);
		
		//Enter Agent No ( SWMT-A0037 )
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("agent_no"))).click();
		System.out.println("----------Add Agent ID----------");
		Thread.sleep(10000);
		
		//Find
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("find_agent"))).click();
		Thread.sleep(2000);
		
		//Wallet Available Balance 
		WebElement availableAfterBeforeAdd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("balance")));
		String AvailableAfterBeforeAdd = availableAfterBeforeAdd.getAttribute("value").replaceAll("[^\\d.]", "").trim();
		walletAvailableBalanceAfterAdd = Math.round(Double.parseDouble(AvailableAfterBeforeAdd)* 100.0) / 100.0;
		System.out.println("Balance Before Deposit = " +walletAvailableBalanceAfterAdd);
		
		Thread.sleep(10000);
	}
	
	@Test(priority = 4)
	public void walletApprove() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigate
		driver.navigate().to("https://demo.techplex.in/transaction/voucher_approve");
		Thread.sleep(2000);
		
		System.out.println("----------Wallet Approve Module are Pending----------");
	}
	
	@Test(priority = 5)
	public void walletReport() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigate
		driver.navigate().to("https://demo.techplex.in/transaction/e_wallet_report");
		Thread.sleep(2000);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		System.out.println("----------E-Wallet report Module are Pending----------");
		
	}
}
