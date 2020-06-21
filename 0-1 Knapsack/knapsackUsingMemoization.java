/*
Problem Statement: Given weights and values of n items, put these items in a knapsack of 
capacity cap to get the maximum total value in the knapsack. In other words, given two 
integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated 
with n items respectively. Also given an integer W which represents knapsack capacity,
find out the maximum value subset of val[] such that sum of the weights of this subset
is smaller than or equal to W. You cannot break an item, either pick the complete item
or don’t pick it (0-1 property).

Approach : Recursion with Memoization

This method is basically an extension to the recursive approach so that we can overcome 
the problem of calculating redundant cases and thus increased complexity. We can solve 
this problem by simply creating a 2-D array that can store a particular state (n, w) if 
we get it the first time. Now if we come across the same state (n, w) again instead of 
calculating it in exponential complexity we can directly return its result stored in the
 table in constant time. This method gives an edge over the recursive approach in this aspect.


*/

class main

 {
      static int sack(int wt[],int val[],int cap,int n,int dp[][])
     {
         if(n==0 || cap==0)
         return 0;
         if(dp[n][cap] != -1)
         return dp[n][cap];
         if(wt[n-1]<=cap)
         dp[n][cap]=Math.max(val[n-1]+sack(wt,val,cap-wt[n-1],n-1,dp),sack(wt,val,cap,n-1,dp));
         else if(wt[n-1]>cap)
         dp[n][cap]=sack(wt,val,cap,n-1,dp);
         return dp[n][cap];
        
     }
	public static void main (String[] args) throws IOException
	 {
	 
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 int t = Integer.parseInt(br.readLine());
	 while(t-- > 0)
	 {
	     int n=Integer.parseInt(br.readLine());
	     int cap=Integer.parseInt(br.readLine());
	     int val[]=new int[n];
	     int wt[]=new int[n];
	        String line[] = br.readLine().split(" ");
	     for(int i=0;i<n;i++)
	     val[i]=Integer.parseInt(line[i]);
	      line = br.readLine().split(" ");
	     for(int i=0;i<n;i++)
	     wt[i] = Integer.parseInt(line[i]);
	     int dp[][]=new int[n+2][cap+2];
	     for (int row[] : dp)
     Arrays.fill(row, -1);
	   
	     System.out.println(sack(wt,val,cap,n,dp));
	 }
	 
	 }
}