package CBS_Branch_Transactions;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//pending

public class Wallet_Approve extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void walletapprove()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		System.out.println("----------Wallet Approve Module are Pending----------");
	}
}
