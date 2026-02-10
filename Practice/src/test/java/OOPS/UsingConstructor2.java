package OOPS;

public class UsingConstructor2 extends UsingConstructor1 
{
	public UsingConstructor2() {
		System.out.println("child constructor");
	}
	
	public void childMethod()
	{
		System.out.println("Child method");
	}
	
	public static void main(String[] args) 
	{
		UsingConstructor2 obj = new UsingConstructor2();
		obj.parentMethod();
		obj.childMethod();
	}
}
