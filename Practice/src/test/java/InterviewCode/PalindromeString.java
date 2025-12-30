package InterviewCode;

import java.util.Iterator;

public class PalindromeString 
{
	public static void main(String[] args) 
	{
		String s1 = "ABCBA";
		String s2 = "";
		
		for (int i = s1.length()-1; i >= 0; i--) 
		{
			s2+=s1.charAt(i);
		}
		if(s2.equals(s1))
		{
			System.out.println("String is palindrome");
		}
		else
		{
			System.out.println("Not Palindrome");
		}
		
	}
}
