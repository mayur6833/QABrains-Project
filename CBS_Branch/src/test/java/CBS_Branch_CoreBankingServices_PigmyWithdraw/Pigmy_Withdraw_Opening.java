package CBS_Branch_CoreBankingServices_PigmyWithdraw;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class Pigmy_Withdraw_Opening extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void pigmyWithdrawOpen() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
//		//direct navigation 
//		driver.navigate().to("");
//		Thread.sleep(2000);
		
		System.out.println("Pigmy Withdraw Opening Section are not working");
	}
}
