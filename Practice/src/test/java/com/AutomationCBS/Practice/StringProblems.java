package com.AutomationCBS.Practice;

import java.util.Arrays;
import java.util.Iterator;

public class StringProblems 
{
	public void reverseString()
	{
		String s1 ="HelLO";
		
		String s2 ="";
		for (int i = s1.length()-1; i >= 0 ; i--) 
		{
			s2+=s1.charAt(i);
		}
		System.out.println(s2);
	}
	
	public static void stringPalindrome()
	{
		String s1 = "abc1cba";
		
		String s2 = "";
		
		for (int i = s1.length()-1; i >=0 ; i--) 
		{
			s2+=s1.charAt(i);
		}
		if(s2.equals(s1))
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("Not Palindrome");
		}
	}
	
	public static void countWordsInString()
	{
		String s1 ="Automated By Java Language !!";
		String sa [] = s1.trim().split(" ");
		System.out.println("Count = "+sa.length);
		
	}
	
	public static void stringAnagram()
	{
		String s1 ="listen";
		String s2 ="silent";
		
		//convert to array
		char[] sa1 = s1.toCharArray();
		char[] sa2 = s2.toCharArray();
		
		//Sort the array sa1
		for (int i = 0; i < sa1.length; i++) 
		{
			for (int j = i+1; j < sa1.length; j++) 
			{
				if(sa1[i]>sa1[j])
				{
					char temp = sa1[i];
					sa1[i] = sa1[j];
					sa1[j] = temp;
				}
			}
			//System.out.print(sa1[i]);
		}
		
		//Sort the array sa2
		for (int i = 0; i < sa2.length; i++) 
		{
			for (int j = i+1; j < sa2.length; j++) 
			{
				if(sa2[i]>sa2[j])
				{
					char temp = sa2[i];
					sa2[i] = sa2[j];
					sa2[j] = temp;
				}
			}
			//System.out.print(sa2[i]);
		}
		if(Arrays.equals(sa1, sa2))
		{
			System.out.println("String in Anagram");
		}
		else
		{
			System.out.println("Not Anagram");
		}
	}
	
	public static void containOnlyDigit()
	{
		String s1 ="123jytfg832";
		
		int cnt =0;
		char[] sa=s1.toCharArray();
		
		for (int i = 0; i < sa.length; i++) 
		{
			if(sa[i] >= '0' && sa[i] <= '9')
			{
				cnt++;
			}
		}
		if(cnt == s1.length())
		{
			System.out.println("Contains only digits");
		}
		else
		{
			System.out.println("Not contains only digits");
		}
	}
	
	public static void vowelsAndConsonents()
	{
		String s1 = "Automation";
		
		int vowelCnt = 0;
		int consonentCnt = 0;
		
		char sa[] = s1.toCharArray();
	
		
		for (int i = 0; i < sa.length; i++) 
		{
			char ch = sa[i];
			if(ch == 'a' || ch =='e' || ch =='i' || ch =='o' || ch =='u' || ch =='A' || ch =='E' || ch =='I' || ch =='O' || ch =='U')
			{
				vowelCnt++;
			}
			else if((ch >='A' && ch <='Z') || (ch >='a' && ch<='z'))
			{
				consonentCnt++;
			}
		}
		System.out.println(vowelCnt);
		System.out.println(consonentCnt);			
	}
	
//	public static void countOfEachCharater()
//	{
//		String s1 ="aabbccydy";
//		char ch[]=s1.toCharArray();
//		
//		for (int i = 0; i < ch.length; i++) {
//			
//		}
//	}
	
	public static void replaceCharacterInString()
	{
		String s1 = "Hello Hello";
		
		String s2 ="";
		
		char ch1 = 'H';
		char ch2 = 'b';
		
		for (int i = 0; i < s1.length(); i++) 
		{
			if(s1.charAt(i) == ch1 )
			{
				s2+= ch2;
			}
			else
			{
				s2+=s1.charAt(i);
			}
		}
		System.out.println(s2);
		
	}
	
	public static void stringRemoveChar2()
	{
		String s1 = "mayur123@gmail.com";
		String s2 ="";
		char ch = '@';
		
		for (int i = 0; i < s1.length(); i++) 
		{
			if(s1.charAt(i)== ch)
			{
				break;
			}
			else
			{
				s2+=s1.charAt(i);
			}
		}
		System.out.print(s2);
	}
	
	public static void removeNumbersFromString()
	{
		String s ="787657uu4";
		String s1 = s.toLowerCase();
		String s2 = "";
		int cnt=0;
		
		for (int i = 0; i < s1.length(); i++) 
		{
			if(s1.charAt(i)>='a' && s1.charAt(i)<='z')
			{
				s2+=s1.charAt(i);
				 cnt++;
			}
		}
		if(cnt != 0)
		{
			System.out.println(s2);
		}
		else
		{
			System.out.println("only numbers are present");
		}
	}
	
	public static void CountLettersDigitSpecialCharacter()
	{
		String s1 ="27&*^%^0dh76skzjhk";
		int cnt1=0;
		int cnt2=0;
		int cnt3=0;
		
		for (int i = 0; i < s1.length(); i++) 
		{
			if(s1.charAt(i)>='0' && s1.charAt(i)<='9')
			{
				cnt1++;
			}
			else if(s1.charAt(i)>='a' && s1.charAt(i)<='z')
			{
				cnt2++;
			}
			else
			{
				cnt3++;
			}
		}
		System.out.println("Count Of Digits :- "+cnt1);
		System.out.println("Count of Alphabets :- "+cnt2);
		System.out.println("Count of Special Characters :- "+cnt3);
	}
	
	public static void stringContainsOnlyLetters()
	{
		String s ="^$#^$#";
		String s1 = s.toLowerCase();
		int cnt1=0;
		int cnt2 =0;
		
		for (int i = 0; i < s1.length(); i++) 
		{
			if(s1.charAt(i)>='a' && s1.charAt(i)<='z')
			{
				cnt1++;
			}
			else if(s1.charAt(i)>='0' && s1.charAt(i)<='9')
			{
				cnt2++;
			}
		}
		if(cnt1 > 0 && cnt2 ==0 )
		{
			System.out.println("String Contains only Letters");
		}
		else if(cnt2 > 0 && cnt1 == 0)
		{
			System.out.println("String contain only Numbers");
		}
		else if(cnt1 > 0 && cnt2 > 0)
		{
			System.out.println("String contains both alphabets and numbers");
		}
		else
		{
			System.out.println("String contains Special characters");
		}
	}
	
	public void reverseNumber()
	{
		int a = 987654321;
		String sa = String.valueOf(a);
		String sb = "";
		for (int i = sa.length()-1; i >=0 ; i--) 
		{
			sb+=sa.charAt(i);
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) 
	{
		StringProblems obj = new StringProblems();
		//obj.reverseString();
		//stringPalindrome();
		//countWordsInString();
		//stringAnagram();
		//containOnlyDigit();
		//vowelsAndConsonents();
		//countOfEachCharater();
		//replaceCharacterInString();
		//stringRemoveChar2();
		//removeNumbersFromString();
		//CountLettersDigitSpecialCharacter();
		//stringContainsOnlyLetters();
		obj.reverseNumber();
		
		String s1 = "abc";
		
		String s2 = "";
		
		for (int i = s1.length()-1; i >=0 ; i--) 
		{
			s2 += s1.charAt(i);
		}
		if(s2.equals(s1))
		{
			System.out.println("yes");
		}
		else
		{
			System.out.println("no");
		}
	}
}
