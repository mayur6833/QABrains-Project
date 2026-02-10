package InterviewCode;

public class frequencyOfEachCharacter 
{
	public static void frequency()
	{
		String s1 = "uuddbbba";
		String s2 = "";
		
		for (int i = 0; i < s1.length(); i++) {
			int cnt1=0;
			for (int j = 0; j < i; j++)
			{
				if(s1.charAt(i) == s1.charAt(j))
				{
					cnt1++;
				}
			}
			if(cnt1 ==0)
			{
				s2+=s1.charAt(i);
			}
		}
		
		for (int i = 0; i < s2.length(); i++) {
			int cnt2=0;
			for (int k = 0; k < s1.length(); k++) {
				if(s2.charAt(i)==s1.charAt(k))
				{
					cnt2++;
				}
			}
			System.out.println(s2.charAt(i)+" "+cnt2);
		}
	}
	
	public static void main(String[] args) 
	{
		frequency();
	}
}
