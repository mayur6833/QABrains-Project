package CBS_Branch_Loan_LoanReports;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Not Working

public class Loan_Balance extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;	
	
	@Test(priority = 1)
	public void LoanBalance() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/branch-loan/loanbalance");
		Thread.sleep(2000);
		
		System.out.println("Loan Balance module are not working");
	}
	
}
