package CBS_Branch_Transactions;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class EWallet_Report extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void walletapprove() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigate
		driver.navigate().to("https://demo.techplex.in/transaction/e_wallet_report");
		Thread.sleep(2000);
		
		System.out.println("----------E-Wallet report Module are Pending----------");
	}
}
