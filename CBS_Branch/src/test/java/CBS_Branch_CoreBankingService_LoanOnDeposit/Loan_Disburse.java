package CBS_Branch_CoreBankingService_LoanOnDeposit;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class Loan_Disburse extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void loanDisburse() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation 
		driver.navigate().to("https://demo.techplex.in/transaction/showldd");
		Thread.sleep(2000);
		
		System.out.println("Loan Disburse section are not working");
	}
}
