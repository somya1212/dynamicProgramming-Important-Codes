/*

Brackets in Matrix Chain Multiplication 

Given a sequence of matrices, find the most efficient way to multiply these matrices together. The problem is not actually 
to perform the multiplications, but merely to decide in which order to perform the multiplications. There are many options 
to multiply a chain of matrices because matrix multiplication is associative i.e. no matter how one parenthesize the product, 
the result will be the same.

Example:
 if you had four matrices A, B, C, and D, you would have:

    (ABC)D = (AB)(CD) = A(BCD) = ....
However, the order in which one parenthesize the product affects the number 
of simple arithmetic operations needed to compute the product, or the efficiency.

For example:

A: 10 × 30 matrix
B : 30 × 5 matrix
C : 5 × 60 matrix
Then,
     (AB)C = (10×30×5) + (10×5×60)
           = 1500 + 3000 
           = 4500 operations
      A(BC) = (30×5×60) + (10×30×60) 
            = 9000 + 18000 
            = 27000 operations.
Given an array arr[] which represents the chain of matrices such that the ith matrix Ai is of dimension arr[i-1] x arr[i].
Your task is to write a program that should print the optimal way to multiply the matrix chain such that minimum number of 
multiplications operations are needed to multiply the chain. Represent first matrix as starting Alphabet of the english 
dictionary i.e. 'A', and the rest so on.

  Input: p[] = {40, 20, 30, 10, 30}   
  Output: Optimal parenthesization is  ((A(BC))D)
  There are 4 matrices of dimensions 40x20, 
  20x30, 30x10 and 10x30. Let the input 4 
  matrices be A, B, C and D.  The minimum 
  number of multiplications are obtained 
  by putting parenthesis in following way
  (A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30

  Input: p[] = {10, 20, 30, 40, 30} 
  Output: Optimal parenthesization is (((AB)C)D)
  There are 4 matrices of dimensions 10x20, 
  20x30, 30x40 and 40x30. Let the input 4 
  matrices be A, B, C and D.  The minimum 
  number of multiplications are obtained by
  putting parenthesis in following way
  ((AB)C)D --> 10*20*30 + 10*30*40 + 10*40*30

Input:
The first line of the input contains an integer T, denoting the number of test cases. Then T test case follows. 
The first line of each test case contains an integer N, denoting the number of elements in the array.
Then next line contains N space separated integers denoting the values of the element in the array.

Output:
For each test case the print the minimum number of operations needed to multiply the chain.

Constraints:
1<=T<=100
2<=N<=27
1<=A[]<=500

Example:
Input:
2
5
1 2 3 4 5
3
3 3 3
Output:
(((AB)C)D)
(AB)

*/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static int ind=65;
    static void print(int i,int j,int dp[][]){
        if(i==j){
            System.out.print((char)ind++);
            return;
        }
        System.out.print("(");
        print(i,dp[j][i],dp);
        print(dp[j][i]+1,j,dp);
        System.out.print(")");
    }
	public static void main (String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    int n=Integer.parseInt(br.readLine());
		    String s[]=br.readLine().split("\\s+");
		    int p[]=new int[n];
		    for(int i=0;i<n;i++)
		    p[i]=Integer.parseInt(s[i]);
		    int dp[][]=new int[n][n];
		    for(int i=1;i<n;i++)
		    dp[i][i]=0;
		    for(int l=2;l<n;l++){
		        for(int i=1;i<n-l+1;i++){
		            int j=i+l-1;
		            dp[i][j]=Integer.MAX_VALUE;
		            for(int k=i;k<j;k++)
		            {
		                int te=dp[i][k]+dp[k+1][j]+(p[i-1]*p[j]*p[k]);
		                if(te<dp[i][j]){
		                    dp[i][j]=te;
		                    dp[j][i]=k;
		                }
		            }
		        }
		    }
		    ind=65;
		    print(1,n-1,dp);
		    System.out.println();
		}
	}
}