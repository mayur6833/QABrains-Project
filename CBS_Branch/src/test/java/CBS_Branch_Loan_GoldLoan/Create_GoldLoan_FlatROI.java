package CBS_Branch_Loan_GoldLoan;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class Create_GoldLoan_FlatROI extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void createGoldLoan_FlatROI() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigate
		driver.navigate().to("https://demo.techplex.in/branch-loan/showgoldloanapply");
		Thread.sleep(2000);

		//MemberID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='member_id']"))).click();
		System.out.println("----------Add Member ID Manually----------");
		Thread.sleep(10000);
		
		//Select Payment Basis
		WebElement paymentBasis1 = driver.findElement(By.id("payment_basis"));
		Select selectPaymentBasis1 = new Select(paymentBasis1);
		List<WebElement> payment1 = selectPaymentBasis1.getOptions();
		String PB1 = "Interest";
		for (int i = 0; i < payment1.size(); i++) 
		{
			if(payment1.get(i).getText().equalsIgnoreCase(PB1))
			{
				payment1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);

		//ROI set based on Scheme
		//Select Scheme
		WebElement scheme = driver.findElement(By.id("scheme"));
		Select selectScheme = new Select(scheme);
		List<WebElement> schemes = selectScheme.getOptions();
		String SS = "New Gold Scheme";
		for (int i = 0; i < schemes.size(); i++) 
		{
			if(schemes.get(i).getText().equalsIgnoreCase(SS))
			{
				schemes.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//tenure 
		WebElement Tenure = driver.findElement(By.id("tenure"));
		Tenure.click();
		Thread.sleep(2000);
		String tenureText = Tenure.getAttribute("value");
		tenureText = tenureText.replaceAll("[^\\d.]"," ");
		System.out.println("Loan Tenure = "+ tenureText);
		Thread.sleep(2000);
		
		//Interest Rate
		WebElement interestRate = driver.findElement(By.xpath("//input[@id='interest_rate']"));
		interestRate.click();
		String interestRateText = interestRate.getAttribute("value");
		interestRateText = interestRateText.replaceAll("[^\\d.]", " ");
		System.out.println("Interest Rate = "+interestRateText);
		Thread.sleep(2000);
		
		//frequency
		WebElement frequency = driver.findElement(By.id("installment_frequency"));
		Select selectFrequency = new Select(frequency);
		List<WebElement> frequencyOptions = selectFrequency.getOptions();
		String SF = "Monthly";
		for (int i = 0; i < frequencyOptions.size(); i++) 
		{
			if(frequencyOptions.get(i).getText().equalsIgnoreCase(SF))
			{
				frequencyOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Loan Date
		//Auto Fetch
		
		//Loan Amount;
		WebElement loanAmount = driver.findElement(By.id("loan_amount"));
		loanAmount.sendKeys("300000");
		String loanAmountText = loanAmount.getAttribute("value");
		loanAmountText = loanAmountText.replaceAll("[^\\d.]"," ");
		System.out.println("Loan Amount = "+loanAmountText);
		Thread.sleep(2000);
		
		//Interest Type
		WebElement interestType = driver.findElement(By.id("interest_type"));
		Select selectInterestType = new Select(interestType);
		List<WebElement> interestTypes = selectInterestType.getOptions();
		String IT = "Flat";
		for (int i = 0; i < interestTypes.size(); i++) 
		{
			if(interestTypes.get(i).getText().equalsIgnoreCase(IT))
			{
				interestTypes.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
	    //ShowEMI
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("calculate_emi_btn"))).click();
	    Thread.sleep(2000);
      
        //clickOnOK
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
        Thread.sleep(3000);
        
        //getTextThatSystemGenratedEMI
        WebElement SystemEMI = driver.findElement(By.id("calculate_emi_btn"));
        String ShowEMIText = SystemEMI.getText();
        ShowEMIText = ShowEMIText.replaceAll("[^\\d.]"," ").trim();
        double systememiValue = Double.parseDouble(ShowEMIText);
        System.out.println("System Generated EMI For Flat ROI = "+ShowEMIText);
        
        //Calculations for Flat ROI
        double LoanAmount = Double.parseDouble(loanAmountText);
        double LoanTenure = Double.parseDouble(tenureText);
        double loanROI = Double.parseDouble(interestRateText);
        
        double tenureYears = LoanTenure / 12.0;
		double totalInterest = (LoanAmount * loanROI * tenureYears) / 100;
		double totalPayment = LoanAmount + totalInterest;
		double flatEMIForGOLDLoan = totalPayment / LoanTenure;
	    System.out.printf("Flat Actual ROI EMI FOR Gold Loan: %.2f%n", flatEMIForGOLDLoan);
	    
	    if(Math.abs(systememiValue - flatEMIForGOLDLoan) < 0.01)
	    {
	    	//Submit
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit']"))).click();
	        Thread.sleep(4000);
	        //OK
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();	
		    Thread.sleep(2000);
	    }
	    else
	    {
	    	System.out.println("Wrong EMI Calculations for Flat Interest Rate ");
	    }		
	}
}
