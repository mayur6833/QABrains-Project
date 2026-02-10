package InterviewCode;

public class FactorialOfNumber 
{
	public void method1()
	{
		int num = 4;
		
		int fact =1;
		for (int i = 1; i <= num; i++) 
		{
			fact = fact*i;
		}
		System.out.println(fact);
	}
	
	public void method2()
	{
		int num = 4;
		
		int fact = 1;
		while(num >0)
		{
			fact*=num;
			num--;
		}
		System.out.println(fact);
	}
	
	public static void main(String[] args) 
	{	
		FactorialOfNumber obj = new FactorialOfNumber();
		obj.method1();
		obj.method2();
	}
}
