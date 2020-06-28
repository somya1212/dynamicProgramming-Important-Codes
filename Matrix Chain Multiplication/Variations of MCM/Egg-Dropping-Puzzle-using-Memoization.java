/*
Suppose you have E eggs and you want to determine from which floor
 in a F-floor building you can drop an egg such that it doesn't break.
 You have to determine the minimum number of attempts you need in order
 find the critical floor in the worst case while using the best strategy.
There are few rules given below. 

An egg that survives a fall can be used again.
A broken egg must be discarded.
The effect of a fall is the same for all eggs.
If the egg doesn't break at a certain floor, it will not break at any floor
below.
If the eggs breaks at a certain floor, it will break at any floor above.

Example:
Input:
2
2 10
3 5

Output:
4
3
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
	     int e=sc.nextInt();
	     int f=sc.nextInt();
	     int t[][]=new int[e+1][f+1];//lookup table
	     for(int row[]:t)
            Arrays.fill(row,-1);//Intialize elements by -1
	     System.out.println(solve(e,f,t));
	 }
	 }
	 public static int solve(int e,int f,int t[][])
	 {
	     if(f==0 || f==1)
	     return f;
	     if(e==1)
	     return f;
	      if(t[e][f]!=-1)//if already present don't call the recursive function
	     return t[e][f];
	     else
	     {
	     int min=Integer.MAX_VALUE;
	     for(int k=1;k<=f;k++)
	     {
	         int temp=1+Math.max(solve(e-1,k-1,t),solve(e,f-k,t));
	         min=Math.min(min,temp);
	         t[e][f]=min;
	     }
	     }
	     return t[e][f];
	 }
}