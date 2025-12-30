package com.AutomationCBS.Practice;

import java.util.Arrays;

public class ArraysProblems 
{

	public void maxElementArray()
	{
		int a[]= {2,43,21,5,7,22,1,99};
		int max =0;
		for (int i = 0; i < a.length; i++) 
		{
			if(a[i]>max)
			{
				max=a[i];
			}
		}
		System.out.println(max);
		
//		for (int i = 0; i < a.length; i++) 
//		{
//			Arrays.sort(a);
//			System.out.println(a[0]);
//			break;
//		}
	}
	
	public void minElementArray()
	{
		int a[]= {2,3,6,21,5,11,3};
		
		int min = a[0];
		
		for (int i = 1; i < a.length; i++) 
		{
			if(a[i] < min)
			{
				min = a[i];
			}
		}
		
		System.out.println(min);
	}
	
	public void printElementAtEvenIndex()
	{
		int a[]= {10, 20, 30, 40, 50, 60};
		
		for (int i = 0; i < a.length; i++) 
		{
			if(i%2==0)
			{
				System.out.print(a[i]+" ");
			}
		}
	}
	
	public void numberExitInArray() 
	{
		int a[] = {1, 3, 5, 7, 9};
		int search = 3;
		
		int cnt=0;
		for (int i = 0; i < a.length; i++) 
		{
			if(a[i]==search)
			{
				cnt++;
			}
		}
		
		if(cnt!=0)
		{
			System.out.print(search +" is present in array");
		}
		else
		{
			System.out.println(search +" is not present in array");
		}
	}
	
	public void reverseFirstToLastArray()
	{
		int a[] = {3,4,5,62,1};
		
	
		for (int i = 0; i < a.length; i++) 
		{
			int temp = a[0];
			a[0]=a[a.length-1];
			a[a.length-1] = temp;
			
			System.out.print(a[i]+" ");
		}
		
	}
	
	public void sortArray()
	{
		int a[]= {1,3,4,6,2};
		
		for (int i = 0; i < a.length; i++) 
		{
			for (int j = i+1; j < a.length; j++) 
			{
				if(a[i]>a[j])
				{
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
			System.out.print(a[i]+" ");
		}
	}
	
	public void bubbleSort()
	{
		int a[] = {2,4,3,1,8,6,9};
		
		for (int i = 0; i < a.length-1; i++) 
		{
			for (int j = 0; j < a.length-i-1 ; j++) 
			{
				if(a[j] > a[j+1])
				{
					int temp =a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		
		for (int i = 0; i < a.length; i++) 
		{
			System.out.print(a[i]+" ");
		}
	}
	
	public static void main(String[] args) 
	{
		ArraysProblems obj = new ArraysProblems();
		//obj.maxElementArray();
		//obj.minElementArray();
		//obj.printElementAtEvenIndex();
		//obj.numberExitInArray();
		//obj.reverseFirstToLastArray();
		//obj.sortArray();
		obj.bubbleSort();
	}

}
