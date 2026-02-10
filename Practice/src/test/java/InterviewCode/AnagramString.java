package InterviewCode;

import java.util.Arrays;

public class AnagramString 
{
	public static void main(String[] args) 
	{
		String s1 = "listen"; 
		String s2 = "silent";
		
		if(s1.length() != s2.length())
		{
			System.out.println("Not Anagram");
		}
		else {
			char[] sa1 = s1.toCharArray();
			char[] sa2 = s2.toCharArray();
			
			for (int i = 0; i < sa1.length; i++) 
			{
				for (int j = i+1; j < sa1.length; j++) 
				{
					if(sa1[i] > sa1[j])
					{
						char temp = sa1[i];
						sa1[i] = sa1[j];
						sa1[j] = temp;
					}
				}
			}
			//System.out.println(sa1);
			
			for (int i = 0; i < sa2.length; i++) {
				for (int j = i; j < sa2.length; j++) 
				{
					if(sa2[i]> sa2[j])
					{
						char temp1 = sa2[i];
						sa2[i]=sa2[j];
						sa2[j]=temp1;
					}
				}
			}
			if(Arrays.equals(sa1, sa2))
			{
				System.out.println("Anagram");
			}
			else
			{
				System.out.println("not Anagram");
			}
		}
	}
}
