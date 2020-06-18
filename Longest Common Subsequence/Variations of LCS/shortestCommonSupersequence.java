/*
Problem Statement :
Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences

Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
Output:  "AGXGTXAYB"

Approach:
- Worst case for supersequence : (s1 + s2)
- Optimization : The characters which occurs in both the strings
is taken only once in the concatenated string.

When we merge the above strings, we get "AGGXTXAYB".
The characters which we were common in both the strings,
we selected them only once. Here, in this case, its "GTAB".
So, basically "GTAB" is nothing but the Longest Common Subsequence 
of both strings, that LCS of strings is removed after concantenation.

Therefore, length of the shortest common supersequence will be
(length of s1 + length of s2) - LCS of s1 and s2.



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
	     String s1=sc.next();
	     String s2=sc.next();
	     char x[]=s1.toCharArray();
	     char y[]=s2.toCharArray();
	     int n=x.length;
	     int m=y.length;
	     int t[][]=new int[n+1][m+1];
	     for(int i=0;i<n+1;i++)
	     {
	         for(int j=0;j<m+1;j++)
	         {
	             if(i==0 || j==0)
	             t[i][j]=0;
	             else if(x[i-1]==y[j-1])
	             t[i][j]=1+t[i-1][j-1];
	             else
	             t[i][j]=Math.max(t[i][j-1],t[i-1][j]);//find lcs
	             
	         }
	     }
	     System.out.println(m+n-(t[n][m]));//length of strings - lcs of strings
	 }
	 }
}