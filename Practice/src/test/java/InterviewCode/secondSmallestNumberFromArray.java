package InterviewCode;

public class secondSmallestNumberFromArray 
{
	public static void main(String[] args) 
	{
		int a[] = {1,2,3,1,4,5,6,8,9};
		
		int min = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		
		for (int i = 0; i < a.length; i++) 
		{
			if(a[i] < min)
			{
				secondMin = min;
				min = a[i];
			}
			else if(a[i] < secondMin && a[i] != min)
			{
				secondMin = a[i];
			}
		}
		System.out.println(secondMin);
	}
}
