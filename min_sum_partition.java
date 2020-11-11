
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static int findMinRec(int arr[], int n) 
    { 
        // Calculate sum of all elements 
        int sum = 0;  
        for (int i = 0; i < n; i++) 
            sum += arr[i]; 
      
        // Create an array to store  
        // results of subproblems 
        boolean dp[][] = new boolean[n + 1][sum + 1]; 
      
        // Initialize first column as true.  
        // 0 sum is possible  with all elements. 
        for (int i = 0; i <= n; i++) 
            dp[i][0] = true; 
      
        // Initialize top row, except dp[0][0],  
        // as false. With 0 elements, no other  
        // sum except 0 is possible 
        for (int i = 1; i <= sum; i++) 
            dp[0][i] = false; 
      
        // Fill the partition table  
        // in bottom up manner 
        for (int i = 1; i <= n; i++) 
        { 
            for (int j = 1; j <= sum; j++) 
            { 
                // If i'th element is excluded 
                dp[i][j] = dp[i - 1][j]; 
      
                // If i'th element is included 
                if (arr[i - 1] <= j) 
                    dp[i][j] =dp[i][j] || dp[i - 1][j - arr[i - 1]]; 
            } 
        } 
      
        // Initialize difference of two sums.  
        int diff = Integer.MAX_VALUE; 
          
        // Find the largest j such that dp[n][j] 
        // is true where j loops from sum/2 t0 0 
        for (int j = sum / 2; j >= 0; j--) 
        { 
            // Find the  
            if (dp[n][j] == true) 
            { 
                diff = sum - 2 * j; 
                break; 
            } 
        } 
        return diff; 
    } 
  
	public static void main (String[] args) {
		//code
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int arr[]=new int[n];
		  //  int sum=0;
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextInt();
		        //sum+=arr[i];
		    }
		    
		    System.out.println(findMinRec(arr, n));
		    
		    
		}
	}
}


/*output:For Input:
4
1 6 5 11
your output is: 
1
*/
