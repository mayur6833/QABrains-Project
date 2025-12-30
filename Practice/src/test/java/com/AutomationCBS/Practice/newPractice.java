package com.AutomationCBS.Practice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class newPractice 
{
	public void calculator()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Add First Value");
		double num1 = sc.nextDouble();
		System.out.println("Add Calculation method");
		System.out.println("+,-,*,/");
		char opeartor = sc.next().charAt(0);
		System.out.println("Add Second value");
		double num2 = sc.nextDouble();
		
		if(opeartor == '+')
		{
			System.out.println("\n Addition is = " +(num1+num2));
		}
		else if (opeartor == '-') 
		{
			System.out.println("\n substraction is = "+(num1 - num2));
		} 
		else if (opeartor == '*') 
		{
			System.out.println("\n multiplication is = "+(int)(num1 * num2)); //type casting (double to int)
		}
		else if(opeartor == '/')
		{
			System.out.println("\n divide is = " +(num1 / num2));
		}
		else {
			System.out.println("\nUser correct operator");
		}
		
	}
	
	public void method2()
	{
		int a=10;
		int b = 5;
		System.out.println(a*b/a-b);
		System.err.println((a*b) / (a-b));
	}
	
	public void loop()
	{
		int s1 = 2;
		
		//for Loop
//		for (int i = s1; i < 11; i++) {
//			System.out.println(i*2);
//		}
		
		//while Loop
//		int i = 0;
//		while(i < 3)
//		{
//			System.out.println(s1);
//			i++;
//		}
		
		//DoWhile loop
//		int i= 1;
//		do 
//		{
//			System.out.println(i*3);
//			i++;
//		} 
//		while (i <= 10);
		
		//sum of n numbers using loop
		
//		int sum = 0;
//		int i=0;
//		while(i<=5)
//		{
//			sum+=i;
//			i++;
//		}
//		System.out.println(sum);
		
//		for(i=0;i<=5;i++)
//		{
//			sum+=i;
//		}
//		System.out.println(sum);
		
//		int i=0;
//		do
//		{
//			sum+=i;
//			i++;
//		}
//		while(i<=5);
//		System.out.println(sum);

		//Using Scanner
		Scanner sc = new Scanner(System.in);
		System.out.println("Add range for addition");
		int num = sc.nextInt();
		
		//ForLoop
//		int sum = 0;
//		for (int i = 0; i <= num; i++) 
//		{
//			sum+=i;
//		}
//		System.out.println(sum);
		
		//WhileLoop
//		int sum=0;
//		int i=0;
//		while(i<= num)
//		{
//			sum+=i;
//			i++;
//		}
//		System.out.println(sum);
		
		//doWhileLoop
//		int sum=0;
//		int i=0;
//		do
//		{
//			System.out.print(i+ " + ");
//			sum+=i;
//			i++;
//		}
//		while(i<=num);
//		System.out.println("\n" +sum);		
		
	}
	
	public void avgArray()
	{
		int a[]=new int[4];
		a[0]=23;
		a[1]=22;
		a[2]=3;
		a[3]=11;
		
		//Sort
		for (int i = 0; i < a.length; i++) 
		{
			for (int j = i+1; j < a.length; j++) 
			{
				if(a[i]>a[j])
				{
					int temp=a[i];
					a[i]=a[j];
					a[j] = temp;
				}
			}
			System.out.println(Arrays.toString(a));
			break;
		}
		
		//sum
		int sum=0;
		for (int i = 0; i < a.length; i++) 
		{
			sum+=a[i];
		}
		System.out.println("Sum Of Array :- " +sum);
		
		//Avg
		double avg= sum/a.length;
		System.out.println("Avg Of Array :- " +avg);
	}
	
	public void secondQuestion()
	{
		String s1 = "I am AutoMation Tester";
		System.out.println(s1.toLowerCase());
	}
	
	public void palindromeString()
	{
		String s1 = "abcdcba";
		
		String s2 ="";
		
		for(int i = s1.length()-1 ; i>= 0 ; i--)
		{
			s2+=s1.charAt(i);
		}
		//System.out.println(s2);
		if(s2.equals(s1))
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("not palindrome");
		}
	}
	
	public static int returnSum(int num1,int num2)
	{
		
		return num1 + num2;
	}
	
	public void factorial()
	{
		//whileLoop
		int num = 4;
		int fact = 1;
		while(num > 0)
		{
			fact*=num;
			num--;
		}
		System.out.println(fact);	
		
		//forloop
//		int num = 4;
//		int fact=1;
//		for (int i = num; i > 0; i--) 
//		{
//			fact*= i;
//		}
//		System.out.println(fact);
	}
	
	public void sumOfOddNumbers()
	{
		int limitRange = 20;
		int sum =0;
		int sum1=0;
		
		for (int i = 1; i <= limitRange ; i++) 
		{
			if(i%2 != 0)
			{
				sum+=i;
			}
			else if (i%2==0) 
			{
				sum1+=i;
			}
		}
		System.out.println("ODD Number = "+sum);
		System.out.println("EVEN Number = "+sum1);
	}
	
	public void greaterNumber()
	{
		int num1 = 100;
		int num2 = 22;
		
		if(num1 > num2)
		{
			System.out.println(num1);
		}
		else if(num2 > num1)
		{
			System.out.println(num2);
		}
	}
	
	public void infiniteLoop()
	{
		do {
			System.out.println("Infinite Loop");
		} while (true);
	}
	
	public void takeCount()
	{
		int positivecnt=0;
		int negativecnt=0;
		int zerocnt=0;
		for (int i = -10; i <= 20; i++) 
		{
			if(i > 0)
			{
				//System.out.println("Positive Count = "+negativecnt+" "+i+" ");
				positivecnt++;
			}
			else if(i < 0)
			{
				//System.out.println("Negative Count = "+negativecnt+" "+i+" ");
				negativecnt++;
			}
			else
			{
				//System.out.println("Zero Count = "+negativecnt+" "+i+" ");
				zerocnt++;
			}
		}
		System.out.println(positivecnt);
		System.out.println(negativecnt);
		System.out.println(zerocnt);
	}
	
	public void arrayInput()
	{
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int numbers []= new int[size];
		
		for (int i = 0; i < numbers.length; i++) 
		{
			numbers[i] = sc.nextInt();
		}
		
		for (int i = 0; i < numbers.length; i++) 
		{
			Arrays.sort(numbers);
			System.out.println(numbers[i]);
		}
	}
	
	public void findSpecificNumber()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Add Size of Array :- ");
		int size = sc.nextInt();
		int numbers []= new int[size];
		
		System.out.println("Add Numbers in Array");
		for (int i = 0; i < numbers.length; i++) 
		{
			
			numbers[i] = sc.nextInt();
		}
		
		//print Array
		for (int i = 0; i < numbers.length; i++) 
		{
			System.out.print(Arrays.toString(numbers));
			break;
		}
		System.out.println();
		
		//find number
		System.out.println("Add Specific number to find :- ");
		int a = sc.nextInt();
		int cnt=0;
		
		for (int i = 0; i < numbers.length; i++) 
		{
			if(numbers[i]==a)
			{
				System.out.println("Index :- "+i);
				cnt++;
			}
		}
		if(cnt ==0)
		{
			System.out.println("Number not found");
		}
	}
	
	public void TwoDArray()
	{
		int a[][]= 
			{
				{1,2,3},
				{4,5,6}
			};
		
		for (int i = 0; i < a.length; i++) 
		{
			for (int j = 0; j < a[i].length; j++) 
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void searchNumberFromTwoDArray()
	{
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Add Rows");
//		int rows = sc.nextInt();
//		System.out.println("Add Col");
//		int col = sc.nextInt();
//		
//		int a[][]= new int[rows][col];
//		
//		//input
//		for (int i = 0; i < rows; i++) {
//			for (int j = 0; j < col; j++) 
//			{
//				a[i][j]= sc.nextInt();
//			}
//		}
		
//		//output
//		for (int i = 0; i < rows; i++) 
//		{
//			for (int j = 0; j < col ; j++) 
//			{
//				System.out.print(a[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		System.out.println();

		//Find Specific Number
		Scanner sc = new Scanner(System.in);
		System.out.println("Add number to find");
		int findnumber = sc.nextInt();
		int cnt=0;
		int a[][]= 
			{
				{1,2,3},
				{1,2,3}
			};
		 
		for (int i = 0; i < a.length; i++) 
		{
			for (int j = 0; j < a[i].length; j++) 
			{
				if(a[i][j]==findnumber)
				{
					System.out.println("( "+i+" , "+j+" )");
					cnt++;
				}
			}
		}
		if(cnt==0)
		{
			System.out.println("Number is Not present in array");
		}
	
	}
	
	
	public static void main(String[] args) 
	{
		newPractice obj = new newPractice();
		//obj.calculator();
		//obj.method2();
		//obj.loop();
		//obj.avgArray();
		//obj.secondQuestion();
		//obj.palindromeString();
//		Scanner sc1 = new Scanner(System.in);
//		int num1 = sc1.nextInt();
//		int num2 = sc1.nextInt();
//		sc1.close();
//		System.out.println(returnSum(num1, num2));
		//obj.factorial();
		//obj.sumOfOddNumbers();
		//obj.greaterNumber();
		//obj.infiniteLoop();
		//obj.takeCount();
		//obj.arrayInput();
		//obj.findSpecificNumber();
		obj.TwoDArray();
		obj.searchNumberFromTwoDArray();
		
		
	}
}
