/*
Minimum number of jumps

Given an array of integers where each element represents the max number of steps that can be made 
forward from that element. The task is to find the minimum number of jumps to reach the end of the
 array (starting from the first element). If an element is 0, then cannot move through that element.

Input: 
The first line contains an integer T, depicting total number of test cases.  Then following T lines contains
a number n denoting the size of the array. Next line contains the sequence of integers a1, a2, ..., an.

Output:
For each testcase, in a new line, print the minimum number of jumps. If answer is not possible print "-1"(without quotes).

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 107
0 <= ai <= 107
*/

import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		  int n = Integer.parseInt(br.readLine());
	      String s[] = br.readLine().split(" ");
	      int a[] = new int[n];
	      for(int i=0;i<n;i++)
	        a[i] = Integer.parseInt(s[i]);
	        minJumps(a,n);
		}
		
	}
	static void minJumps(int a[] , int n)
	{
	    int jumps[] = new int[n];
	    jumps[0] = 0;  //As the min jumps needed to get to first index is zero only.
	    //Fill the rest of the array with Integer.MAX_VALUE so we can make math.min comparisions.
	    for(int i=1;i<n;i++)
	        jumps[i] = Integer.MAX_VALUE;
	        
	    for(int i=1;i<n;i++)
	    {
	        for(int j=0;j<i;j++)
	        {   //If we have enough jumps from the position j to reach i. 
	            if(j+a[j]>=i)    
	            { //Take the min of current stored value & jumps req to 
	              //reach i from j by getting jumps req to reach j plus 1.
	              //(Plus 1 because since we have enough jumps to reach 1 from j we 
	              //simply add 1 by taking the jumps required to reach j.)
	                jumps[i] = Math.min(jumps[i],jumps[j]+1);
	            }
	        }
	    }
	    
	    //If first element has zero jumps in store or if the final jumps value 
	    //becomes MAX value because there's an element in between which gives zero
	    //jumps.
	    if(a[0]==0 || jumps[n-1] == Integer.MAX_VALUE ) 
	    System.out.println("-1");
	    
	    else System.out.println(jumps[n-1]);
	}
}