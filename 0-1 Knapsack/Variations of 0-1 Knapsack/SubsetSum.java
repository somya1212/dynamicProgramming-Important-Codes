/*
Problem Statement : Given a set of numbers, check whether it can be partitioned into two subsets such that the sum of elements 
                    in both subsets is same or not.

You don't need to read input or print output, taking inputs and printing is done by the driver code. Your task is to complete the 
findPartition() function which takes an array a[] and N as input parameter and return true if the given set can be partitioned into 
two subsets such that the sum of elements in both subsets is equal, else return false.

Time Complexity: O(N*N)
Auxiliary Space: O(N)
*/


class Solution {
    public boolean subsetsum(int[] a, int sum, int n) {
        // code here
        boolean dp[][] = new boolean[a.length+1][sum+1];
        for(int i=0;i<=a.length;i++){
            for(int j=0;j<=sum;j++){
                if(i==0)
                    dp[i][j] = false;
                if(j==0)
                    dp[i][j] = true;
            }
        }
        for(int i=1;i<a.length+1;i++){
            for(int j=1;j<sum+1;j++){
                if(a[i-1]<=j)
                    dp[i][j]=dp[i-1][j-a[i-1]] || dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[a.length][sum];
    }
    public boolean findPartition(int[] a, int n) {
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += a[i];
        }
        if(sum%2!=0)
            return false;
        else
            return subsetsum(a,sum/2,n);
    }
}
