/*Problem Statement : 
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example :
Input:nums = [1,1,1], k = 2
Output: 2

Constraints:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		    int arr[]=new int[n];
		    for(int i=0;i<n;i++)
		        arr[i]=sc.nextInt();
		     int sum=sc.nextInt(); 
		     int dp[][]=new int[n+1][sum+1];
		     for(int r=0;r<=n;r++)
		       for(int c=0;c<=sum;c++)
		         dp[r][c]=-1;
		     System.out.print(subsetSum(n-1,sum,arr,dp));
		     System.out.println();
		}
	}
	static int subsetSum(int index,int sum,int arr[],int dp[][]){ 
	      if(index==0){
	          if(arr[0]==sum)
	            dp[0][sum]=1;
	          else
	            dp[0][sum]=0;
	        return(dp[0][sum]);
	      }
	     if(dp[index][sum]!=-1)
	        return(dp[index][sum]);
	     if(arr[index]>sum)
	         dp[index][sum]= subsetSum(index-1,sum,arr,dp);
	     else{
	       if(arr[index]==sum)
	         dp[index][sum]=1+subsetSum(index-1,sum,arr,dp);
	       else
	          dp[index][sum]= subsetSum(index-1,sum-arr[index],arr,dp)+ subsetSum(index-1,sum,arr,dp);
	     }
	     return(dp[index][sum]);
	}
}