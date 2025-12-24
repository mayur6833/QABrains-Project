package CBS_Branch_Transactions;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Pending

public class Loan_EMI_Payment extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void LoanEMIPayment()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		System.out.println("Loan EMI Payment module are Pending");
	}
}
