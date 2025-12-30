package InterviewCode;

import java.util.UUID;

public class GenerateRandomAlphanumericString 
{
	public static void main(String[] args) 
	{
		String random = UUID.randomUUID().toString();
		System.out.println(random);
		random = random.replace("-", "");
		System.out.println(random);
		String sub = random.substring(0, 6);
		System.out.println(sub);
	}
}
