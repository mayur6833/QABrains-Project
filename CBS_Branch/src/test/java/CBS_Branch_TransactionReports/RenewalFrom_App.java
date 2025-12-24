package CBS_Branch_TransactionReports;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class RenewalFrom_App extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void renewalFromApp() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/transaction/renewal_tranrep");
		Thread.sleep(2000);
		
		System.out.println("The Renewal From App Module are Pending");
	}
}
