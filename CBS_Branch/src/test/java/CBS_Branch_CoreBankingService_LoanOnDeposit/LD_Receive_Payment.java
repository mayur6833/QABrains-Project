package CBS_Branch_CoreBankingService_LoanOnDeposit;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class LD_Receive_Payment extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void LDReceivePayment() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/baccounts/ld_receive_pay");
		Thread.sleep(2000);
		
		System.out.println("LD Receive Payment Section Are pending");
	}	
}
