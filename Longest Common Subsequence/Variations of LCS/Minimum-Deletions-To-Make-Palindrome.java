/*
Problem Statement :
Given a string of size ‘n’. The task is to remove 
or delete minimum number of characters from the string
so that the resultant string is palindrome.
Input : aebcbda
Output : 2
Remove characters 'e' and 'd'
Resultant string will be 'abcba'
which is a palindromic string

Approach: It will be same as that of longest palindromic subsequence(lps).
We will take the reverse of the string and then find the lps of
both strings.
And then, to find the number of deletions we will subtract the lps from
the length of string.
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	
	 Scanner sc=new Scanner(System.in);
	 int test=sc.nextInt();
	 while(test-- > 0)
	 {
	     String s=sc.next();
	     StringBuilder sb=new StringBuilder();
        sb.append(s);
        sb=sb.reverse();//reverse the string
        char x[]=s.toCharArray();
        char[] y = new char[sb.length()]; 
        sb.getChars(0, sb.length(), y, 0); 
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
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);//find lps
            }
        }
        System.out.println(n-t[n][m]);//length-lps
	 }
	 }
}