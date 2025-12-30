package InterviewCode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromArray
{
	public static void main(String[] args) 
	{
		int a[] = {1,3,2,5,7,5,4,};
		
		Set<Integer> array = new HashSet<>();
		for (int i = 0; i < a.length; i++) 
		{
			array.add(a[i]);
		}
		System.out.println(array);
	}
}
