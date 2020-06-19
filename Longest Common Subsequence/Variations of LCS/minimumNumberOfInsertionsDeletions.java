/*
Problem Statement :
Given two strings ‘s1’ and ‘s2’ of size m and n respectively.
 The task is to remove/delete and insert minimum number of characters from/in s1 so as to transform 
it into s2. It could be possible that the same character needs to be removed/deleted from one point 
of str1 and inserted to some another point.


Input : s1 = "heap", s2 = "pea" 
Output : Minimum Deletion = 2 and
         Minimum Insertion = 1

Approach :
We see that in the above example "ea" doesn't change that is, it is the lcs of s1 and s2.
So, basically we are deleting characters from s1 and s2 which are not the lcs of s1 and s2.
Therefore, No. of deletions = length of s1 - lcs of s1 and s2.
Similarly, No.of insertions =length of s2 - lcs of s1 and s2.

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
	     for(int i=0;i<n+1;i++)
	     {
	         for(int j=0;j<m+1;j++)
	         {
	             if(i==0 || j==0)
	             t[i][j]=0;
	             else if(x[i-1]==y[j-1])
	             t[i][j]=1+t[i-1][j-1];
	             else
	             t[i][j]=Math.max(t[i][j-1],t[i-1][j]);
	             
	         }
	     }
	     System.out.println((n-(t[n][m]))+m-t[n][m]);
	 }
	 }
}