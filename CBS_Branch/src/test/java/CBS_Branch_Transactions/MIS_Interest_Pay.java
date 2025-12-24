package CBS_Branch_Transactions;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//pending

public class MIS_Interest_Pay extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void MISInterestPay()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		System.out.println("MIS Interest Pay Module are pending");
	}

}
