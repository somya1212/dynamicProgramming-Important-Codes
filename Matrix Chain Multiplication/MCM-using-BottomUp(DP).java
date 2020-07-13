/*

Matrix Chain Multiplication

Input:
The first line of the input contains an integer T, denoting the number of test cases. Then T test case follows. 
The first line of each test case contains an integer N, denoting the number of elements in the array.
Then next line contains N space separated integers denoting the values of the element in the array.

Output:
For each test case the print the minimum number of operations needed to multiply the chain.

Constraints:
1<=T<=100
2<=N<=100
1<=A[]<=500

Example:
Input:
2
5
1 2 3 4 5
3
3 3 3
Output:
38
27      */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
	public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-- > 0){
            int n = scan.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            int cost = findCost(arr);
            System.out.println(cost);
        }
	}
	
	public static int findCost(int []arr){
	    int [][]dp = new int[arr.length][arr.length];
	    int q = 0;
	    for(int l=2;l<arr.length;l++){
	        for(int i=0;i<arr.length-l;i++){
	            int j = i+l;
	            dp[i][j] = Integer.MAX_VALUE;
	            for(int k=i+1;k<j;k++){
	                q = dp[i][k] + dp[k][j] + arr[i]*arr[j]*arr[k];
	                if(q < dp[i][j])
	                    dp[i][j] = q;
	            }
	        }
	    }
	    return dp[0][arr.length-1];
	} 
}