package CBS_Branch_CoreBankingServices_PigmyDeposit;

import java.lang.Math;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class calculations 
{
	DecimalFormat df = new DecimalFormat("###0.00");
	
	public void DailyRdCalculation() 
	{
		// --- Input Variables (Matching User's Format) ---
		double dailyDeposit = 500;
		double annualRate = 7.1;
		int tenureInYears = 1;
		int compoundingPeriodsPerYear = 4; // Quarterly

		// --- Standard Calculations ---
		int totalDays = tenureInYears * 365;
		double totalPrincipal = dailyDeposit * totalDays; // Invested Amount
	        
		// Use DecimalFormat for output formatting (matches df.format)
	        
		// --- Precise Daily RD Calculation (Replaces the simple Math.pow line) ---
	        
		final double rateDecimal = annualRate / 100.0;
		final double ratePerPeriod = rateDecimal / compoundingPeriodsPerYear; 
		final double daysPerYear = 365.0; 
		final double daysPerCompoundingPeriod = daysPerYear / compoundingPeriodsPerYear;

		BigDecimal investedAmountBd = BigDecimal.ZERO;
		BigDecimal maturityAmountBd = BigDecimal.ZERO;
	        
		// Loop to calculate the future value of *each* daily installment
		for (int day = 1; day <= totalDays; day++) 
		{        
			// Accumulate Invested Principal (for verification)
			investedAmountBd = investedAmountBd.add(BigDecimal.valueOf(dailyDeposit));
			
			// Remaining term in days for this specific deposit
			int remainingDays = totalDays - day + 1;
	            
			// Number of compounding periods remaining (exponent for the formula)
			double power = remainingDays / daysPerCompoundingPeriod;

			// Calculate Future Value for this installment: A = P * (1 + r/n)^power
			double futureValue = dailyDeposit * Math.pow(1 + ratePerPeriod, power);
	            
			// Sum up all future values
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
	}
	
	
	public static void main(String[] args) 
	{
		calculations one = new calculations();
		one.DailyRdCalculation();
		System.out.println();
	}
}