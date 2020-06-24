/*
Minimum sum partition

Given an array, the task is to divide it into two sets S1 and S2 
such that the absolute difference between their sums is minimum.

Input:
The first line contains an integer 'T' denoting the total number of 
test cases. In each test cases, the first line contains an integer
 'N' denoting the size of array. The second line contains N space-
separated integers A1, A2, ..., AN denoting the elements of the array.


Output:
In each seperate line print minimum absolute difference.


Constraints:
1<=T<=200
1<=N<=50
1<=A[i]<=200
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class Main
 {
	public static void main (String[] args)
	 {
	 Scanner sc=new Scanner(System.in);
	 int t=sc.nextInt();
	 while(t-->0)
	 {
	     int n=sc.nextInt();
	     int arr[]=new int[n];
	     int sum=0;
	     for(int i=0;i<n;i++)
	     {
	         arr[i]=sc.nextInt();
	         sum+=arr[i];
	     }
	     int ans[]=new int[sum];
	     ans=subset(arr,sum);
	     int min=Integer.MAX_VALUE;
	     for(int i=0;i<ans.length;i++)
	     min=Math.min(min,(sum-2*ans[i]));
	     
	     System.out.println(min);
	     
	     
	 }
	 }
	 static int[] subset(int arr[],int sum)
	 {
	     int n=arr.length;
	     boolean dp[][]=new boolean[n+1][sum+1];
	     for(int i=0;i<=n;i++)
	     dp[i][0]=true;
	     for(int i=1;i<=sum;i++)
	     dp[0][i]=false;
	     
	     // subset sum concept
	    for(int i=1;i<=n;i++)
	    {
	        for(int j=1;j<=sum;j++)
	        {
	            if(arr[i-1]<=j)
	            dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
	            else
	            dp[i][j]=dp[i-1][j];
	        }
	    }
	    
	    //storing last dp column whose value is true till sum/2
	    int index[]=new int[sum];
	    int p=0;
	    for(int i=0;i<=sum/2;i++)
	    {
	        if(dp[n][i]==true)
	            index[p++]=i;
	    }
	    return index;
	 }
}
