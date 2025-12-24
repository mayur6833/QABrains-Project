package CBS_Branch_Loan_GoldLoan;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class GoldLoan_Cycle extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void GoldLoanCycle()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Code
	}
}
