package InterviewCode;

public class factorialNo {

	public static void main(String[] args) {
		
		int num =4;
		int fact =1;
		while(num > 0)
		{
			fact*=num;
			num--;
		}
		System.out.println(fact);
	}
}
