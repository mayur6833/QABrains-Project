package OOPS;

public class Abstrations2 extends Abstrations1 
{
	@Override
	void check1() {
		
		int a= 2; int b=3;
		
		a = a+b;
		b = a-b;
		a=a-b;
		System.out.println("Swap No");
		System.out.println(a);
		System.out.println(b);
	}

	@Override
	void check2() {
		
		int a = 2;
		System.out.println("multiplication");
		System.out.println(a*a);
	}
	
	
	public static void main(String[] args) {
		Abstrations2 obj = new Abstrations2();
		obj.check1();
		obj.check2();
	}

	@Override
	public void interfaceMethod() {
		System.out.println("Interface Method Calling");
		
	}

	
}
