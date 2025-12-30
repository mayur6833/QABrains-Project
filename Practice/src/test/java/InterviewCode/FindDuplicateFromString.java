package InterviewCode;

import java.util.HashSet;
import java.util.Set;


public class FindDuplicateFromString 
{
	public static void main(String[] args) 
	{
		String s1 = "Programming";
		
		Set<Character> seen = new HashSet<>();
		Set<Character> duplicates = new HashSet<>();
		
		for (int i = 0; i < s1.length(); i++) 
		{
			char ch = s1.charAt(i);
			
			if(seen.contains(ch))
			{
				duplicates.add(ch);
			}
			else
			{
				seen.add(ch);
			}
		}
		System.out.println("Duplicates characters are : ");
		for(char ch : duplicates)
		{
			System.out.print(ch);
		}	
	}
}
