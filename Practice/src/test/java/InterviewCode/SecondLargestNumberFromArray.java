package InterviewCode;

public class SecondLargestNumberFromArray 
{
	public static void main(String[] args) 
	{
		int a [] = {1,2,3,4,1,6,7};
		
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		
		for (int i = 0; i < a.length; i++) {
			if(a[i] > max)
			{
				secondMax = max ;
				max = a[i];
			}
			else if (a[i] > secondMax && a[i] != max) 
			{
				secondMax = a[i];
			}
		}
		System.out.println(secondMax);
	}
}
