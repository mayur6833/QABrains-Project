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

//For Share Holder 
//add Change Member ID accordingly

public class share_Payment extends BaseLoginForAllBranchModules
{	
	WebDriverWait wait;
	
	Voucher_Approval vou = new Voucher_Approval();
	View_ShareReport SR = new View_ShareReport();
	
	@Test(priority = 1)
	public void shareDepositNavigation() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigate
		driver.navigate().to("https://demo.techplex.in/transaction/share-payment");
		Thread.sleep(2000);
		
		//member ID  //003001100061
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member_id"))).click();
		System.out.println("----------Add Member ID Manually----------");
		Thread.sleep(10000);
		
		//Member Type
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member_type"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Number Of Shares
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("number_of_shares"))).sendKeys("10");
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
		
		//Submit Payment()
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='addButton']"))).click();
//		WebElement copyVoucherNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
//		String VoucherNo = copyVoucherNo.getText().replaceAll("", "").trim();
//		System.out.println(VoucherNo);
		Thread.sleep(10000);	
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void checkVoucher() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		vou.VoucherApproveforTransactionModule();
		vou.VoucherApprove();
	}
	
	@Test(priority = 3)
	public void viewShareReport() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		SR.viewShareReport();
	}
}
