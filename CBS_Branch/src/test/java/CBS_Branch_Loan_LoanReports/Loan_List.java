package CBS_Branch_Loan_LoanReports;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class Loan_List extends BaseLoginForAllBranchModules
{
	WebDriver driver;
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void loanList()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/branch-loan/loanList");
		
		System.out.println("Loan List module are pending");
	}
}
