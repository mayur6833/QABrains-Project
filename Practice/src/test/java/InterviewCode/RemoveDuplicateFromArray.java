package InterviewCode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromArray
{
	public static void main(String[] args) 
	{
//		int a[] = {1,3,2,5,7,5,4,};
//		
//		Set<Integer> array = new HashSet<>();
//		for (int i = 0; i < a.length; i++) 
//		{
//			array.add(a[i]);
//		}
//		System.out.println(array);
		
		String s1 = "aabcttds";
		char ch [] = s1.toCharArray();
		
		Set<Character> s11 = new HashSet<Character>();
		for (int i = 0; i < ch.length; i++) 
		{
			s11.add(ch[i]);
		}
		System.out.println(s11);
	}
}
