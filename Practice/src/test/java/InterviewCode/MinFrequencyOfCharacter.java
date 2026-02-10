package InterviewCode;


public class MinFrequencyOfCharacter 
{
	public void minFeq()
	{
		String s1 = "udggbbaadass";
		
		String s2 = "";
		
		for (int i = 0; i < s1.length(); i++) 
		{
			int cnt1 = 0;
			for (int j = 0; j < i; j++) 
			{
				if(s1.charAt(i) == s1.charAt(j))
				{
					cnt1++;
				}
			}
			if(cnt1 == 0)
			{
				s2+=s1.charAt(i);
			}
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < s2.length(); i++) 
		{
			int cnt2 = 0;
			for (int j = 0; j < s1.length(); j++) 
			{
				if(s2.charAt(i) ==  s1.charAt(j))
				{
					cnt2++;
				}
			}
			if(cnt2 < min)
			{
				min = cnt2;
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
			if(cnt3 <= min)
			{
				System.out.println(s2.charAt(i)+" "+min);
			}
		}
	}
	
	public static void main(String[] args) 
	{
		MinFrequencyOfCharacter obj = new MinFrequencyOfCharacter();
		obj.minFeq();
	}
}
