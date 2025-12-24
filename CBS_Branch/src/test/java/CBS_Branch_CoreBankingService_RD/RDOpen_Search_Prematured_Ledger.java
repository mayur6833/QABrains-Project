package CBS_Branch_CoreBankingService_RD;


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

//DONE
// Create Account (Calculation -> Renewal )
// Search
// PreMatured (Accept Voucher)
// Ledger

public class RDOpen_Search_Prematured_Ledger extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	double installmentAmount;
	double appRateOfInterest;
	double appTotalInterest;
	double apptotalMaturity;
	String RDAccountNO;
	String RDPreMaturedVoucherNo;
	
	//Convert to decimal
	DecimalFormat df = new DecimalFormat("###0.00");
	
	Renewals renewAmount = new Renewals();
	Voucher_Approval acceptVoucher = new Voucher_Approval();
	
	
	@Test(priority = 1)
	public void RDOpening() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/baccounts/open-rd");
		Thread.sleep(2000);
		
		//Member No
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member-no"))).sendKeys("003001100001");
		Thread.sleep(2000);
		
		System.out.println("=========================================");
		System.out.println("     Recurring Deposit (RD) Calculation   ");
		System.out.println("=========================================\n");
		System.out.println("-------------System Calculation------------");
		
		//PlanType
		WebElement planType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan-name")));
		Select selectPlan=new Select(planType);
		List<WebElement> selectPlanType = selectPlan.getOptions();
		String plans = "RD 2YR(24 MONTH-ROI 8%)";
		for (int i = 0; i < selectPlanType.size(); i++) 
		{
			if(selectPlanType.get(i).getText().equalsIgnoreCase(plans))
			{
				selectPlanType.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		
		//InstallmentAmount
		WebElement installment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deposit-amount")));
		installment.sendKeys("1000");
		String appInstallmentAmount = installment.getAttribute("value").replaceAll("[^\\d.]", "").trim();
		installmentAmount = Integer.parseInt(appInstallmentAmount);
		System.out.println("System Installment Amount = "+installmentAmount);
		Thread.sleep(3000);
		
		//Installment Mode
		WebElement premium = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("premium")));
		Select selectPremium = new Select(premium);
		List<WebElement> Premium1= selectPremium.getOptions();
		String s ="Monthly"; //Monthly
		for (int i = 0; i < Premium1.size(); i++) 
		{
			if(Premium1.get(i).getText().equalsIgnoreCase(s))
			{
				Premium1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);	
		
		//Rate OF Interest
		WebElement rateOfInterest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rate-of-interest")));
		String appROI = rateOfInterest.getAttribute("value").replaceAll("[^\\d.]", "").trim();
		appRateOfInterest = Math.round(Double.parseDouble(appROI)*100.0)/100.0;
		System.out.println("System ROI: "+ df.format(appRateOfInterest));
		Thread.sleep(2000);
		
		//Interest Amount 
		WebElement InterestAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("interest-amount")));
		String appInterestAmount = InterestAmount.getAttribute("value").replaceAll("[^\\d.]", "").trim();
		appTotalInterest = Math.round(Double.parseDouble(appInterestAmount)*100.0)/100.0;
		System.out.printf("System Total Interest Amount: %.2f%n", appTotalInterest);
		Thread.sleep(2000);
		
		//Maturity Amount
		WebElement maturityAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("maturity-amount")));
		String appMaturityAmount = maturityAmount.getAttribute("value").replaceAll("[^\\d.]", "").trim();
		apptotalMaturity = Math.round(Double.parseDouble(appMaturityAmount)*100.00)/100.00;
		System.out.printf("System Total Maturity Amount: %.2f%n", apptotalMaturity);
		Thread.sleep(2000);
		
		//ReferredBy
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reffered-by"))).sendKeys("SWMT-A0037");
		Thread.sleep(2000);
	}
		
	@Test(priority = 2, dependsOnMethods = {"RDOpening"})
	public void Calculations() throws Exception
	{
		System.out.println("-------------Script Calculation------------");
		
        double depositAmount = installmentAmount;      // Monthly deposit
        double annualRate = appRateOfInterest;  // Annual interest rate (%)
        double tenure = 2;      // Tenure in years
        int compoundingPeriod = 4;   // Compounded Quarterly
//      int compoundingPeriod = 1;   // Compounded yearly  
//      int compoundingPeriod = 2;   // Compounded half yearly
//      int compoundingPeriod = 4;   // Compounded Quarterly
//      int compoundingPeriod = 12;  // Compounded Monthly
//      int compoundingPeriod = 365; // Compounded Daily

        // Convert rate to decimal
        double R = annualRate / 100;

        // Common factor
        double quarterlyRate = R / compoundingPeriod;
        double termFactor = Math.pow(1 + quarterlyRate, compoundingPeriod / 12.0);

        // Using the closed-form geometric series formula
        double numerator = Math.pow(termFactor, tenure * 12 + 1) - termFactor;
        double denominator = termFactor - 1;

        double maturityAmount = depositAmount * (numerator / denominator);
        double totalInvested = depositAmount * tenure * 12;
        double interestEarned = maturityAmount - totalInvested;

        System.out.println("-----------------------------------------------------");
        System.out.println("Total Amount Invested: " +df.format(totalInvested));
        System.out.println("Total Interest Earned: "+ df.format(interestEarned));
        System.out.println("Maturity Amount: "+df.format(maturityAmount));
        System.out.println("-----------------------------------------------------");
	    
	    if(Math.abs(maturityAmount - apptotalMaturity) < 0.01)
	     {
	    	if(Math.abs(interestEarned - appTotalInterest) < 0.01)
	    	{
	    		System.out.println("RD Calculation is Right");
	    		//submit
		 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Open Account']"))).click();
		 		WebElement copyRDAccountNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/p[2]")));
		 		RDAccountNO = copyRDAccountNo.getText().replaceAll("Account No: ", "").trim();
		 		System.out.println("Account NO: "+ RDAccountNO);
		 		Thread.sleep(2000);
		 
		 		//OK
		 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		 		Thread.sleep(2000);	
	    	}
	     }
	     else
	     {
	    	 System.out.println("RD calculations is wrong");
	     }
	}
	
	@Test(priority = 3, dependsOnMethods = {"RDOpening"})
	public void renewalRD() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/renewals");
		Thread.sleep(2000);
		
		//CustomerAccountNo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accno"))).sendKeys(RDAccountNO);
		Thread.sleep(2000);
		
		//Confirm
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchButton"))).click();
		//OK
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		renewAmount.Renewals_Actions();
	}
	
	@Test(priority = 4, dependsOnMethods = {"RDOpening"})
	public void ViewRD() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct navigation
		driver.navigate().to("https://demo.techplex.in/baccounts/view_rdreports");
		Thread.sleep(2000);
		
		//Search Type
		WebElement searchType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_type")));
		Select selectSearchType = new Select(searchType);
		selectSearchType.selectByValue("account_no");
		Thread.sleep(2000);
		
		//Enter Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-content"))).sendKeys(RDAccountNO);
		Thread.sleep(2000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-submit']"))).click();
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(7000);	
	}
	
	@Test(priority = 5, dependsOnMethods = {"RDOpening"})
	public void preMaturedRD() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/rdpre");
		Thread.sleep(2000);
				
		//Enter Policy Number 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("policy-number"))).sendKeys(RDAccountNO);
		Thread.sleep(2000);
				
		//Fetch Prematurity
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='Fetch PreMaturity Details']"))).click();		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
				
		//Transfer To Account
		WebElement transferAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount_transfer_to_acc")));
		Select selectAccount = new Select(transferAccount);
		selectAccount.selectByValue("003001200001");
		Thread.sleep(2000);
				
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addButton"))).click();
		WebElement copyRDPreVoucher = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='swal2-html-container'])[1]")));
		RDPreMaturedVoucherNo = copyRDPreVoucher.getText().replaceAll("Voucher generated successfully. Awaiting approval. Voucher No: ", "").trim();
		System.out.println("RD PreMatured Voucher No: "+RDPreMaturedVoucherNo);
		Thread.sleep(2000);
				
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
	    Thread.sleep(2000);
	}
	
	@Test(priority = 6, dependsOnMethods = {"preMaturedRD"} )
	public void PreMaturedVoucherApprove() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigate
		driver.navigate().to("https://demo.techplex.in/transaction/showpendingvoucher");
		Thread.sleep(2000);
		
		//Automatically fetch Voucher Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("voucher_no"))).sendKeys(RDPreMaturedVoucherNo);
		Thread.sleep(2000);
		
		acceptVoucher.VoucherApprove();
	}
	
	@Test(priority = 7, dependsOnMethods = {"RDOpening"})
	public void RDAccountledger() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/rd_ledger");
		Thread.sleep(2000);
		
		//Account no
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acc_no"))).sendKeys(RDAccountNO);
		Thread.sleep(2000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchButton"))).click();
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("//button[normalize-space()='OK']"))).click();
		Thread.sleep(7000);
	}
	
//	@AfterMethod
//    public void takeScreenshotifFail(ITestResult result) throws IOException 
//	{
//		if(ITestResult.FAILURE == result.getStatus())
//		{
//			File failSS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			File location = new File("C:\\Users\\Mahindarr\\eclipse-workspace\\CBS\\CBS_Branch\\Screenshots\\" + result.getName() +".png");
//			FileUtils.copyFile(failSS, location);
//		}
//    }
} 
