package CBS_Branch_CoreBankingService_RD;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Done
//Change plan Accordingly

public class RD_Calculator extends BaseLoginForAllBranchModules
{
	WebDriver driver;
	WebDriverWait wait;
	int installmentAmount;
	double systemROI;
	double systemInterest;
	double SystemMaturity;
	
	DecimalFormat df = new DecimalFormat("###0.00");
	
	@Test(priority = 1)
	public void RD_Calculator_Actions() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigation 
		driver.navigate().to("https://demo.techplex.in/rdCalculator");
		Thread.sleep(2000);
		
		//SelectPlan
		WebElement selectPlan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select-plan")));
		Select plans = new Select(selectPlan);
		List<WebElement> planOptions= plans.getOptions();
		String SP = "RD 2YR(24 MONTH-ROI 8%)";
		for (int i = 0; i < planOptions.size(); i++) 
		{
			if(planOptions.get(i).getText().equalsIgnoreCase(SP))
			{
				planOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);		
		
		//Installment frequency
		WebElement installmentFrequency = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("premium")));
		Select selectFrequency = new Select(installmentFrequency);
		List<WebElement> frequency = selectFrequency.getOptions();
		String SF = "Monthly";
		for (int i = 0; i < frequency.size(); i++) 
		{
			if(frequency.get(i).getText().equalsIgnoreCase(SF))
			{
				frequency.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//TypeOfCustomer
		WebElement typeOfCustomer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='customer-type']")));
		Select selectTOC = new Select(typeOfCustomer);
		List<WebElement> types = selectTOC.getOptions();
		String TOC = "Normal";
		for (int i = 0; i < types.size(); i++) 
		{
			if(types.get(i).getText().equalsIgnoreCase(TOC))
			{
				types.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		System.err.println("-----------------System Calculation------------------");
		//Application Generated ROI    
        WebElement SystemROI = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roiinterest")));
        String SystemROIText = SystemROI.getAttribute("value").replaceAll("[^\\d.]","").trim();
        systemROI = Math.round(Double.parseDouble(SystemROIText)*100.0)/100.0;
        System.out.println("System ROI: "+df.format(systemROI));
        Thread.sleep(2000);
        
		//DepositAmount
        WebElement installment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deposit-amount")));
        installment.sendKeys("10000");
        Thread.sleep(2000);
        String installmenttext = installment.getAttribute("value").replaceAll("[^\\d.]", "").trim();
        installmentAmount = Integer.parseInt(installmenttext);
        System.out.println("System Installment Amount: "+df.format(installmentAmount));
        Thread.sleep(2000);
		
		//ClickOnCalculateRD
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Calculate RD']"))).click();
		Thread.sleep(2000);
		
		//Interest Amount
		WebElement interestAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='calculation-results']//div[4]")));
		String interestAmountText = interestAmount.getText().replaceAll("[^\\d.]", "").trim();
		systemInterest = Math.round(Double.parseDouble(interestAmountText) * 100.0)/100.0;
		System.out.println("System Interest Amount: "+df.format(systemInterest));
		Thread.sleep(2000);
		
        //Maturity Amount 
        WebElement maturityAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='calculation-results']//div[5]")));
        String systemMaturityAmount = maturityAmount.getText().replaceAll("[^\\d.]"," ").trim();
        SystemMaturity = Math.round(Double.parseDouble(systemMaturityAmount)*100.00)/100.00;
        System.out.println("System Maturity Amount: "+df.format(SystemMaturity));  
        Thread.sleep(2000);
        
	}
	
	@Test(priority = 2)
	public void Calculations() throws Exception
	{
		System.out.println("====================================================");
		
        double P = installmentAmount;      // Monthly deposit
        double annualRate = systemROI;  // Annual interest rate (%)
        int N = 4;             // Compounding frequency (Quarterly)
//      int N = 2;             // Compounding frequency (half yearly)
//      int N = 12;            // Compounding frequency (monthly)
//      int N = 1;             // Compounding frequency (yearly)
        		
        double years = 2;      // Tenure in years

        // Convert rate to decimal
        double R = annualRate / 100;

        // Common factor
        double quarterlyRate = R / N;
        double termFactor = Math.pow(1 + quarterlyRate, N / 12.0);

        // Using the closed-form geometric series formula
        double numerator = Math.pow(termFactor, years * 12 + 1) - termFactor;
        double denominator = termFactor - 1;

        double maturityAmount = P * (numerator / denominator);
        double totalInvested = P * years * 12;
        double interestEarned = maturityAmount - totalInvested;

        System.out.println("-----------------Script Calculation------------------");
        System.out.println("Total Amount Invested: "+ df.format(totalInvested));
        System.out.println("Total Interest Earned: "+ df.format(interestEarned));
        System.out.println("Maturity Amount : "+ df.format(maturityAmount));
        System.out.println("-----------------------------------------------------");
	    
	    if(Math.abs(maturityAmount - SystemMaturity) < 0.01)
	     {
	    	if(Math.abs(interestEarned - systemInterest) < 0.01)
	    	{
	    		System.out.println("RD Calculations is right");
	    	}
	     }
	     else
	     {
	    	 System.out.println("RD calculations is wrong");
	     }
	}
}