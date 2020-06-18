/*
Problem Statement :
Given two strings ‘s1’ and ‘s2’, find the length of the longest common substring.
Input : X = “abcdxyz”, y = “xyzabcd”
Output : 4
The longest common substring is “abcd” and is of length 4.

Approach: It is almost same as lcs. The only thing we need
to change is when the common subsequence is discontinous, change
the length to zero.
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class main
 {
	public static void main (String[] args)
	 {
	 
	 Scanner sc=new Scanner(System.in);
	 int test=sc.nextInt();
	 while(test-- > 0)
	 {
	     int n=sc.nextInt();
	     int m=sc.nextInt();
	     String s1=sc.next();
	     String s2=sc.next();
	     char x[]=s1.toCharArray();
	     char y[]=s2.toCharArray();
	     int t[][]=new int[n+1][m+1];
	     int r=0;
	     for(int i=0;i<n+1;i++)
	     {
	         for(int j=0;j<m+1;j++)
	         {
	             if(i==0 || j==0)
	             t[i][j]=0;
	             else if(x[i-1]==y[j-1])
	             {
	             t[i][j]=1+t[i-1][j-1];
	             r=Math.max(r,t[i][j]);//Updating max value of length.
	             }
	             else
	             t[i][j]=0;//change length to zero
	         }
	     }
	     System.out.println(r);
	 }
	 }
}