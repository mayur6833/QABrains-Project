package CBS_Branch_CoreBankingService_FD;

import java.text.DecimalFormat;

public class FD_Calculation {

    public static void main(String[] args) 
    {
    	DecimalFormat df = new DecimalFormat("###0.00");
    	
    	// Given inputs
        double principal = 50000;       // Deposit Amount (₹)
        double annualRate = 8.5;        // Rate of Interest (% per annum)
        int compoundingPerYear = 4;     // Quarterly compounding
        double tenureYears = 2;         // Tenure in years

        // Convert rate to decimal
        double r = annualRate / 100;

        // Compound Interest Formula: A = P * (1 + r/n)^(n*t)
        double amount = principal * Math.pow((1 + r / compoundingPerYear), compoundingPerYear * tenureYears);

        // Calculate interest earned
        double interest = amount - principal;

        // Display results
        System.out.println("----- FD Calculation (SBI / Groww Formula) -----");
        System.out.println("Deposit Amount (P): "+df.format(principal));
        System.out.println("Rate of Interest (r): "+df.format(annualRate));
        System.out.println("Tenure (t): "+ df.format(tenureYears));
        System.out.println("------------------------------------------------");
        System.out.println("Total Interest Earned: "+ df.format(interest));
        System.out.println("Maturity Amount (A): "+ df.format(amount));
        System.out.println("------------------------------------------------");
    }
}
