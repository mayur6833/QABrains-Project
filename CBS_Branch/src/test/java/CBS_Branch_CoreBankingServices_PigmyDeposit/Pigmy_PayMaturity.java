package CBS_Branch_CoreBankingServices_PigmyDeposit;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import CBS_Branch_Transactions.Voucher_Approval;
import LoginBranch.BaseLoginForAllBranchModules;

//Pending
//Voucher not display when going to approve

public class Pigmy_PayMaturity extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	String pigmyAccountNo;
	String MaturityVoucherNo;
	
	//all class Object that will use to run Pigmy_PayMaturity
	Voucher_Approval approve = new Voucher_Approval();
	
	@Test(priority = 1)
	public void pigmyMaturity() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/baccounts/pigmyPayMaturity");
		Thread.sleep(2000);
		
		//Enter Policy Number
		WebElement policyNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("policy-number")));
		policyNo.sendKeys("003001600027");
		System.out.println("-----Add Policy No-----");
		Thread.sleep(10000);
		//policyNo.click();
		pigmyAccountNo = policyNo.getAttribute("value");
		System.out.println("Pigmy :"+ pigmyAccountNo);
		
		//Maturity date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pre-maturity-date"))).click();
		System.out.println("-----Add Maturity date-----");
		Thread.sleep(20000);
		
		//Fetched 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='Fetch Maturity Details']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Transfer To Account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount_transfer_to_acc"))).click();
		System.out.println("-----Select Account-----");
		Thread.sleep(10000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addButton"))).click();
		WebElement copyMaturityVoucherNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/p[2]")));
		MaturityVoucherNo = copyMaturityVoucherNo.getText().replaceAll("Voucher No: ", "").trim();
		System.out.println(MaturityVoucherNo);
		Thread.sleep(2000);
		//ok
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']")));
		
	}
	
	@Test(priority = 2)
	public void accpetMaturityVoucher() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigate
		driver.navigate().to("https://demo.techplex.in/transaction/showpendingvoucher");
		Thread.sleep(2000);
		
		//Automatically fetch Voucher Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("voucher_no"))).sendKeys(MaturityVoucherNo);
		Thread.sleep(2000);
		
		approve.VoucherApprove();
	}
	
	@Test(priority = 3)
	public void checkReport() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));

		//Direct navigation 
		driver.navigate().to("https://demo.techplex.in/baccounts/viewPigmy");
		Thread.sleep(2000);
		
		//MemberID
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acc_no"))).sendKeys(pigmyAccountNo);
		Thread.sleep(2000);
		
		//Search
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
		//OK
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(10000);
	}
}
