package InterviewCode;

public class MaxFrequencyOfCharacter 
{
	public static void maxFrequency()
	{
		String s1 = "udttqqiiiqqq";
		
		String s2= "";
		for (int i = 0; i < s1.length(); i++) 
		{
			int cnt1 = 0;
			for (int j = 0; j < i; j++) 
			{
				if(s1.charAt(i)==s1.charAt(j))
				{
					cnt1++;
				}
			}
			if(cnt1 == 0)
			{
				s2+=s1.charAt(i);
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < s2.length(); i++) 
		{
			int cnt2 = 0;
			for (int j = 0; j < s1.length(); j++) 
			{
				if(s2.charAt(i) == s1.charAt(j))
				{
					cnt2++;
				}
			}
			if(cnt2 > max)
			{
				max = cnt2;
			}
		}
		
		for (int i = 0; i < s2.length(); i++) 
		{
			int cnt3 = 0;
			for (int j = 0; j < s1.length(); j++) 
			{
				if(s2.charAt(i) == s1.charAt(j))
				{
					cnt3++;
				}
			}
			if(cnt3 >= max)
			{
				System.out.println(s2.charAt(i)+" "+max);
			}
		}
		
	}
	public static void main(String[] args) 
	{
		maxFrequency();
	}

}
