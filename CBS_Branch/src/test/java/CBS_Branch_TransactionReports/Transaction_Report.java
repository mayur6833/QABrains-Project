package CBS_Branch_TransactionReports;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Pending

public class Transaction_Report extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void transactionReport() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct navigation
		driver.navigate().to("https://demo.techplex.in/transaction/report_tranrep");
		Thread.sleep(2000);
		
		System.out.println("The Transaction Report is Pending");
	}
}
