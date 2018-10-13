package com.shenxinfu.bishi;

import java.util.Scanner;

public class Main1 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
		String s = in.nextLine();
		String[] pattern = new String[n];
		for(int i=0;i<n;i++)
		{
			pattern[i] = in.nextLine();
		}
		int m = in.nextInt();
		String ss = in.nextLine();
		String[] data = new String[m];
		for(int i=0;i<m;i++)
		{
			data[i] = in.nextLine();
		}
		
		A: for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(pipei(pattern[j], data[i]))
				{
					System.out.println("YES");
					continue A;
				}
			}
			System.out.println("NO");
			
		}
	}
	
	public static boolean pipei(String s1,String s2)
	{
		int index = 0;
		for(int i=0;i<s2.length();i++)
		{
			
			if(s1.charAt(index) == s2.charAt(i))
			{
				//System.out.println(s1.charAt(index));
				index++;
				if(index == s1.length())
					return true;
			}
			else
			{
				//System.out.println(index);
				int len = s2.length();
				for(int j=0;j<s1.length()-index;j++)
				{
					//System.out.println("hou     "+s1.charAt(s1.length()-j-1));
					if(s2.charAt(len-1-j) != s1.charAt(s1.length()-j-1))
					{
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

}
