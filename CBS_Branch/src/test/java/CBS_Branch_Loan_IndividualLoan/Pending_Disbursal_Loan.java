package CBS_Branch_Loan_IndividualLoan;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Pending

public class Pending_Disbursal_Loan extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void pendingDisbursalLoan()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation 
		driver.navigate().to("https://demo.techplex.in/admin-loan/pending_paym_loan");
		
		System.out.println("Pending Disbursal Loan Module are pending");
	}
}
