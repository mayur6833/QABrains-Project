package CBS_Branch_CoreBankingService_MIS;

import java.text.DecimalFormat;

public class MIS_Calculation 
{
	DecimalFormat df = new DecimalFormat("###0.00");
	
	public void simpleInterest()
	{	
		 // Given values
        double depositAmount = 100000;  // Principal amount
        double roi = 7.9;       // Annual rate of interest (7%)
        int tenure = 2;          // Time in years

        // Calculate Simple Interest (SI)
        double SI = (depositAmount * roi * tenure) / 100;

        // Monthly interest (divide total interest by number of months in 2 years)
        double monthlyIncome = SI / (12 * tenure);

        // Output the result with 2 decimal points
        System.out.println("----Simple Interest----");
        System.out.println("Total Simple Interest Earned = "+ df.format(SI));
        System.out.println("Total Monthly Income = "+ df.format(monthlyIncome));
	}
	
	public void CompoundInterest() 
	{
	        // Given values
	        double P = 100000;  // Principal amount
	        double rPercent = 7.00; // Annual rate of interest (7%)
	        int n = 12;          // Compounding frequency (monthly)
//	        int n = 1;          // Compounding frequency (yearly)
//	        int n = 4;          // Compounding frequency (quarterly)
	        int t = 2;           // Time in years

	        // Convert the percentage rate to decimal (7% = 7/100 = 0.07)
	        double r = rPercent / 100;

	        // Compound Interest formula to calculate the total amount (A)
	        double A = P * Math.pow((1 + r / n), n * t);

	        // Calculate total interest earned
	        double totalInterest = A - P;

	        // Monthly income (divide total interest by number of months)
	        double monthlyIncome = totalInterest / (n * t);

	        // Output the result
	        System.out.println();
	        System.out.println("----Compound Interest----");
	        System.out.printf("Annual Interest Rate: %.2f%n", rPercent); // Display the rate as 7%
	        System.out.printf("Total Amount (A):  %.2f%n", A);
	        System.out.printf("Total Interest Earned: %.2f%n", totalInterest);
	        System.out.printf("Monthly Income: %.2f%n", monthlyIncome);
	}

	
	public static void main(String[] args) 
	{
		MIS_Calculation obj = new MIS_Calculation();
		obj.simpleInterest();
		obj.CompoundInterest();
	}
}
