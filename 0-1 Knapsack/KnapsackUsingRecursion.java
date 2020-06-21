/*
Approach : Use Recursion
A simple solution is to consider all subsets of items and calculate
the total weight and value of all subsets. Consider the only subsets
whose total weight is smaller than W. From all such subsets, pick 
the maximum value subset.

Case 1: The item is included in the optimal subset.
Case 2: The item is not included in the optimal set.
*/

import java.lang.*;
import java.io.*;
class main
 {
      static int sack(int wt[],int val[],int cap,int n)
     {
         if(n==0 || cap==0)//base case
         return 0;
// Return the maximum of two cases: 
        // (1) nth item included 
        // (2) not included 
         if(wt[n-1]<=cap)
         return Math.max(val[n-1]+sack(wt,val,cap-wt[n-1],n-1),sack(wt,val,cap,n-1));
 // If weight of the nth item is 
        // more than Knapsack capacity W, 
        // then this item cannot be included 
        // in the optimal solution 
         else if(wt[n-1]>cap)
         return sack(wt,val,cap,n-1);
         return 0;
     }
	public static void main (String[] args)
	 {
	 
	 Scanner sc=new Scanner(System.in);
	 int t=sc.nextInt();
	 while(t-- > 0)
	 {
	     int n=sc.nextInt();
	     int cap=sc.nextInt();
	     int val[]=new int[n];
	     int wt[]=new int[n];
	     for(int i=0;i<n;i++)
	     val[i]=sc.nextInt();
	     for(int i=0;i<n;i++)
	     wt[i]=sc.nextInt();
	     System.out.println(sack(wt,val,cap,n));
	 }
	 
	 }
}