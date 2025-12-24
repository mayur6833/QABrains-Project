package CBS_Branch_Transactions;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class TodaysEMIPaymentCollection extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void TodaysEMIPayment() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/transaction/depositerecieve");
		Thread.sleep(2000);
		
		System.out.println("-----today EMI Payment Collection module are Pending-----");
	}
}
