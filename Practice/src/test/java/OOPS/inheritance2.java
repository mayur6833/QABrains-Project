package OOPS;

public class inheritance2 extends inheritance1
{
	public void method1(int a)
	{
		int b = 1;
		System.out.println(b);
	}
	
	public static void main(String[] args) {
		inheritance2 obj = new inheritance2();
		obj.method1();
		obj.method2();
	}
}
