package InterviewCode;

public class smallestNumberFromArray 
{
	public static void main(String[] args) 
	{
		int a[]= {3,2,5,7,5,4};
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if(a[i] < min)
			{
				min = a[i];
			}
		}
		System.out.println(min);
	}
}
