package InterviewCode;

public class largestestNumberFromArray 
{
	public static void main(String[] args) 
	{
		int a [] = {2,3,1,4,5,1,2,3,4};
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < a.length; i++) {
			if(a[i] > max)
			{
				max =  a[i];
			}
		}
		System.out.println(max);
	}
}
