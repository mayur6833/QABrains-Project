package InterviewCode;

public class sumOfNum 
{
	public static void method1()
	{
		int a = 12345;
		String s1 = String.valueOf(a);
		char sa [] = s1.toCharArray();
		
		int sum = 0;
		for (int i = 0; i < sa.length; i++) {
			sum= sum+sa[i]- '0';
		}
		System.out.println(sum);
	}
	
	public static void method2()
	{
		int num= 12345;
		int sum=0;
		
		while(num > 0)
		{
			int temp = num%10;
			sum+=temp;
			num/=10;
		}
		System.out.println(sum);
	}
	public static void main(String[] args) 
	{
		method1();
		method2();
	}
}
