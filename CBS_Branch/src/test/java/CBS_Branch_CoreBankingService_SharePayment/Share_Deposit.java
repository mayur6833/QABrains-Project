package CBS_Branch_CoreBankingService_SharePayment;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import CBS_Branch_Transactions.Voucher_Approval;
import LoginBranch.BaseLoginForAllBranchModules;

//For Ordinary Member
//add Change Member ID accordingly

public class Share_Deposit extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	Voucher_Approval VA = new Voucher_Approval();
	View_ShareReport SR = new View_ShareReport();
	
	@Test(priority = 1)
	public void shareDeposit() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/share_deposit");
		Thread.sleep(2000);
		
		//member ID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member_id"))).click();
		System.out.println("----------Add Member ID Manually----------");
		Thread.sleep(10000);
		
		//Member Type
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member_type"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Mode OF Payment
		WebElement modeOfPayment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payment_mode")));
		Select selectMode = new Select(modeOfPayment);
		List<WebElement> modes = selectMode.getOptions();
		String MOP = "Cash";
		for (int i = 0; i < modes.size(); i++) 
		{
			if(modes.get(i).getText().equalsIgnoreCase(MOP))
			{
				modes.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Submit Payment
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='addButton']"))).click();
		System.out.println("----------Copy Voucher Number----------");
		Thread.sleep(10000);	
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void checkVoucher() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		VA.VoucherApprove();
	}
	
	@Test(priority = 3)
	public void viewShareReport() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		SR.viewShareReport();
	}
}
