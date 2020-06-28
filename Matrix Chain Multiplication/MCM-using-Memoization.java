/*

MCM using Memoization

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
	     int a[]=new int[n];
	     for(int i=0;i<n;i++)
	     
	     a[i]=sc.nextInt();
// lookup table to store the solution to already computed
// sub-problems
	     int t[][]=new int[n+1][n+1];
	     for(int row[]:t)
            Arrays.fill(row,-1);//Intialize elements by -1
	     
	     System.out.println(solve(a,1,n-1,t));
	 }
	 }
	 public static int solve(int a[],int i,int j,int t[][])
	 {
	     if(i==j)
	     return 0;
	      int min=Integer.MAX_VALUE;
	     if(t[i][j]!=-1)
	     return t[i][j];
	    else
	    {
	     for(int k=i;k<=j-1;k++)
	     {
	         int temp=solve(a,i,k,t)+solve(a,k+1,j,t)+(a[i-1]*a[k]*a[j]);
	         if(temp<min)
	         min=temp;
	         t[i][j]=min;
	     }
	    }
	     return t[i][j];
	 }
}