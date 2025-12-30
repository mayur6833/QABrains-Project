
package InterviewCode;


public class ReverseString {

	public static void main(String[] args) 
	{
		String S1 = "Java";
		String S2 = "";
		
		for (int i = S1.length()-1; i >= 0; i--) 
		{
			S2+=S1.charAt(i);
		}
		System.out.println(S2);

	}

}
