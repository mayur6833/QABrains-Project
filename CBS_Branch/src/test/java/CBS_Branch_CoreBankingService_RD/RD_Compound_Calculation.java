package CBS_Branch_CoreBankingService_RD;

import java.text.DecimalFormat;


public class RD_Compound_Calculation 
{
	
	public void Calculations()
	{       		        
        double P = 10000;      // Monthly deposit
        double annualRate = 6.9;  // Annual interest rate (%)
        int N = 4;             // Compounding frequency (Quarterly)
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
        
        DecimalFormat df = new DecimalFormat("###0.00");
        
        System.out.println("-----------------------------------------------------");
        System.out.println("Total Amount Invested: "+df.format(totalInvested));
        System.out.println("Total Interest Earned: "+df.format(interestEarned));
        System.out.println("Maturity Amount (A): "+df.format(maturityAmount));
        System.out.println("-----------------------------------------------------");
    }
	
	
	public static void main(String[] args) 
	{
		RD_Compound_Calculation obj = new RD_Compound_Calculation();
		obj.Calculations();
	}
}

