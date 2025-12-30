package InterviewCode;

public class PrimeNo 
{
	public static void main(String[] args) 
	{
		int a=3;
		
		int cnt=0;
		
		for (int i = 2; i < a ; i++) 
		{
			if(a%i==0)
			{
				cnt++;
			}
		}
		if(cnt==0)
		{
			System.out.println("Prime No");
		}
		else
		{
			System.out.println("Not a Prime no");
		}
	}	
}
