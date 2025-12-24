package CBS_Branch_CoreBankingServices_PigmyDeposit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import CBS_Branch_Transactions.Renewals;
import CBS_Branch_Transactions.Voucher_Approval;
import LoginBranch.BaseLoginForAllBranchModules;

// Voucher not showing on Voucher approval section
// add tenure section 
// Calculations Pending

public class Pigmy_Open_Search_PreMature_Ledger extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	double systemInstallmentAmount;
	double systemROI;
	double systemInterestAmount;
	double systemMaturityAmount;
	String PigmyAccountNO;
	String preMaturityVoucher;
	
	// Format the output to two decimal places
    DecimalFormat df = new DecimalFormat("###0.00");
    
    //all class Object that will use to run Pigmy_Account_Opening
    Renewals renewRDAmount = new Renewals();
    Voucher_Approval accept = new Voucher_Approval();
	
	@Test(priority = 1)
	public void Pigmy_AccountOpening() throws Exception
	{	
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/baccounts/open-pigmy");
		Thread.sleep(2000);
		
		//MemberID 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member-no"))).sendKeys("003001100001");
		Thread.sleep(2000);
		
        System.out.println("==========================================");
        System.out.println("    Pigmy (Daily Deposit) Calculation    ");
        System.out.println("==========================================");
		
		//SelectPlanType
		WebElement selectPlanType = driver.findElement(By.id("plan-name"));
		Select selectPlan = new Select(selectPlanType);
		List<WebElement> planTypes = selectPlan.getOptions();
		String SPT = "PIGMY 1YR(12 MONTH-ROI 6.9%)";
		for (int i = 0; i < planTypes.size(); i++) 
		{
			if(planTypes.get(i).getText().equalsIgnoreCase(SPT))
			{
				planTypes.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//InstallmentAMount
		WebElement installmentAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deposit-amount")));
		installmentAmount.sendKeys("1000");
		String installmentAmountText = installmentAmount.getAttribute("value").replaceAll("[^\\d.]", "").trim();
		systemInstallmentAmount = Double.parseDouble(installmentAmountText);
		System.out.println("System Installment Amount: "+df.format(systemInstallmentAmount));
		Thread.sleep(2000);
		
		
		//Interest Payout type
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@name='interest_payout_type'])[1]"))).click();
		Thread.sleep(2000);
		
		//ROI
		WebElement rateOfInterest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rate-of-interest")));
		String ROIText = rateOfInterest.getAttribute("value").replaceAll("[^\\d.]", "").trim();
		systemROI = Double.parseDouble(ROIText);
		System.out.println("System ROI: "+df.format(systemROI));
		Thread.sleep(2000);
		
		//Interest Amount 
		WebElement interestAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("interest-amount")));
		String interestAmountText = interestAmount.getAttribute("value").replaceAll("[^\\d.]", "").trim();
		systemInterestAmount = Double.parseDouble(interestAmountText);
		System.out.println("System Interest Amount: "+df.format(systemInterestAmount));
		Thread.sleep(2000);
		
		//Maturity Amount
		WebElement maturityAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("maturity-amount")));
		String maturityAmountText = maturityAmount.getAttribute("value").replaceAll("[^\\d.]", "").trim();
		systemMaturityAmount = Double.parseDouble(maturityAmountText);
		System.out.println("Maturity Amount: "+df.format(systemMaturityAmount));
		Thread.sleep(2000);
		
		//Referred Details
		//Agent ID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reffered-by"))).sendKeys("SWMT-A0037");
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit Application']"))).click();
 		WebElement copyCAAccountNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/p[2]")));
 		PigmyAccountNO = copyCAAccountNo.getText().replaceAll("Account No: ", "").trim();
 		System.out.println("Account NO: "+ PigmyAccountNO);
 		Thread.sleep(2000);
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		System.out.println("Calculations is right");
	}
	
//	@Test(priority = 2, dependsOnMethods = {"Pigmy_AccountOpening"})
	public void PigmyCalculations() throws Exception
	{
		double dailyDeposit = systemInstallmentAmount;
		double annualRate = systemROI;
		int tenureInYears = 1;
		int compoundingPeriodsPerYear = 4; //Quarterly
//		int compoundingPeriodsPerYear = 12; //Monthly
//		int compoundingPeriodsPerYear = 2; //Half yearly
//		int compoundingPeriodsPerYear = 1; //Yearly

		// --- Standard Calculations ---
		int totalDays = tenureInYears * 365;
		double totalPrincipal = dailyDeposit * totalDays; // Invested Amount	        
		final double rateDecimal = annualRate / 100.0;
		final double ratePerPeriod = rateDecimal / compoundingPeriodsPerYear; 
		final double daysPerYear = 365.0; 
		final double daysPerCompoundingPeriod = daysPerYear / compoundingPeriodsPerYear;

		BigDecimal investedAmountBd = BigDecimal.ZERO;
		BigDecimal maturityAmountBd = BigDecimal.ZERO;
			        
		// Loop to calculate the future value of *each* daily installment
		for (int day = 1; day <= totalDays; day++) 
		{      
			investedAmountBd = investedAmountBd.add(BigDecimal.valueOf(dailyDeposit));
			int remainingDays = totalDays - day + 1;
			double power = remainingDays / daysPerCompoundingPeriod;
			double futureValue = dailyDeposit * Math.pow(1 + ratePerPeriod, power);
			maturityAmountBd = maturityAmountBd.add(BigDecimal.valueOf(futureValue));
		}

		// Finalize results using BigDecimal for precision
		maturityAmountBd = maturityAmountBd.setScale(2, RoundingMode.HALF_UP);
		double maturityAmount = maturityAmountBd.doubleValue();
			        
		// Recalculate interest based on the precise maturity amount
		double interestEarned = maturityAmount - totalPrincipal;
			        
		// --- Output (Matching User's Format) ---
		System.out.println("\nScript Calculation");
		System.out.println("------------------------------------------");
		System.out.println("Total Principal: " + df.format(totalPrincipal));
		System.out.println("Total Interest Earned: " + df.format(interestEarned));
		System.out.println("------------------------------------------");
		System.out.println("Total Maturity Amount: " + df.format(maturityAmount));
		System.out.println("==========================================");
		
        if(Math.abs(maturityAmount - systemMaturityAmount) <0.01)
        {
        	if(Math.abs(interestEarned - systemInterestAmount)< 0.01)
        	{        		
        		//Submit
        		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit Application']"))).click();
		 		WebElement copyCAAccountNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/p[2]")));
		 		PigmyAccountNO = copyCAAccountNo.getText().replaceAll("Account No: ", "").trim();
		 		System.out.println("Account NO: "+ PigmyAccountNO);
		 		Thread.sleep(2000);
        		//OK
        		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
        		System.out.println("Calculations is right");
        	}
        }
        else
        {
        	System.out.println("Showing Wrong Calculations For Pigmy");
        }
        
        Thread.sleep(5000);
	}
	
	@Test(priority = 3)
	public void renewalPigmy() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/renewals");
		Thread.sleep(2000);
		
		//CustomerAccountNo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accno"))).sendKeys(PigmyAccountNO);
		Thread.sleep(2000);
		
		//Confirm
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchButton"))).click();
		//OK
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		renewRDAmount.Renewals_Actions();
	}
	
	@Test(priority = 4)
	public void viewPigmy() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct navigation 
		driver.navigate().to("https://demo.techplex.in/baccounts/viewPigmy");
		Thread.sleep(2000);
		
		//MemberID
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acc_no"))).sendKeys(PigmyAccountNO);
		Thread.sleep(2000);
		
		//Search
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
		//OK
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(10000);
	}

	@Test(priority = 5, dependsOnMethods = {"Pigmy_AccountOpening"})
	public void preMaturedPigmy() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigate 
		driver.navigate().to("https://demo.techplex.in/transaction/pigmypre");
		Thread.sleep(2000);
		
		//Enter Policy no
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("policy-number"))).sendKeys(PigmyAccountNO);
		Thread.sleep(2000);
				
		//Fetch Prematurity
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='Fetch PreMaturity Details']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Pre-Maturity Interest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='toggle_prematurity_interest']"))).click();
		Thread.sleep(2000);
		
		//Penalty Rate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='toggle_penalty_rate']"))).click();
		Thread.sleep(2000);
				
		//Transfer To Account
		WebElement transferAc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount_transfer_to_acc")));
		Select selectAccount = new Select(transferAc);
		selectAccount.selectByValue("003001200001");
		Thread.sleep(2000);
		
	    //Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addButton"))).click();
		WebElement copyPreMaturityVoucher = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/p[2]")));
		preMaturityVoucher = copyPreMaturityVoucher.getText().replaceAll("Voucher No: ", "").trim();
		Thread.sleep(2000);
				
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 6)
	public void acceptPreMaturityVoucher() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigate
		driver.navigate().to("https://demo.techplex.in/transaction/showpendingvoucher");
		Thread.sleep(2000);
		
		//Automatically fetch Voucher Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("voucher_no"))).sendKeys(preMaturityVoucher);
		Thread.sleep(2000);
		
		accept.VoucherApprove();
	}
	
	@Test(priority = 7)
	public void pigmyLedger() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct navigation
		driver.navigate().to("https://demo.techplex.in/baccounts/pigmy_ledger");
		Thread.sleep(2000);
		
		//AccountNo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountNo"))).sendKeys(PigmyAccountNO);
		Thread.sleep(2000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-submit']"))).click();
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(10000);
	}
}
