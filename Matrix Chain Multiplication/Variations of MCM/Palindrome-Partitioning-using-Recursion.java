/*
Given a string, a partitioning of the string is a palindrome 
partitioning if every sub-string of the partition is a palindrome.
 For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”. Determine the fewest cuts needed for palindrome
 partitioning of a given string. For example, minimum 3 cuts are 
needed for “ababbbabbababa”. The three cuts are “a|babbbab|b|ababa”.


Example:
Input:
2
ababbbabbababa
aaabba

Output:
3
1
Approach:
The approach will be to implement MCM using recursion as it is.
Only the base condition will change.
We will need to check if the given string is a palindrome
already.Then, we need to return zero, as no further partitions will
be possible.
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
	 while(test-->0)
	 {
	     String s=sc.next();
	     int n=s.length();
	     System.out.println(solve(s,0,n-1));
	 }
	 }
	 public static boolean palindrome(String s,int i,int j)
	 {
	     while (i <= j)//check palindrome
 {
			if (s.charAt(i++) != s.charAt(j--)) {
				return false;
			}
		}
		return true;
	  }
	  public static int solve(String s,int i,int j)
	  {
	      if(i==j||palindrome(s,i,j))//base condition
	      return 0;
	      int ans=Integer.MAX_VALUE;
	      for(int k=i;k<=j-1;k++)
	      {
	          int temp=solve(s,i,k)+solve(s,k+1,j)+1;
	          if(temp<ans)
	          ans=temp;
	      }
	      return ans;
	  }
}