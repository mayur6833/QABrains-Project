package InterviewCode;

public class IntegerPalindrome 
{
	public static void main(String[] args) {
		int a= 12321;
		
		String sa= String.valueOf(a);
		
		//System.out.println(sa);
		String sb ="";
		
		for (int i = sa.length()-1; i >= 0; i--) 
		{
			sb+=sa.charAt(i);
		}
		if(sb.equals(sa))
		{
			System.out.println("Number is Palindrome");
		}
		else
		{
			System.out.println("Number is not palindrome");
		}
	}
	
}
