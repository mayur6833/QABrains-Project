package InterviewCode;

public class LowerToUpper {

	public static void main(String[] args) {
		String s1 = "AbCd";
		String s2 = "";
		
		for (int i = 0; i < s1.length(); i++) {
			char ch = s1.charAt(i);
			if(Character.isUpperCase(ch))
			{
				s2+=Character.toLowerCase(ch);
			}
			else
			{
				s2+=Character.toUpperCase(ch);
			}
		}
		System.out.println(s2);
	}
}
