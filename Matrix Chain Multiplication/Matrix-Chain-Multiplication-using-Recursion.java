/*

Given a sequence of matrices, find the most efficient way to
 multiply these matrices together. The problem is not actually
 to perform the multiplications, but merely to decide in which 
order to perform the multiplications. There are many options to
 multiply a chain of matrices because matrix multiplication is 
associative i.e. no matter how one parenthesize the product, the
 result will be the same.

Example:
 if you had four matrices A, B, C, and D, you would have:

    (ABC)D = (AB)(CD) = A(BCD) = ....

Example:
Input:
2
5
1 2 3 4 5
3
3 3 3
Output:
38
27
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class main
 {
	public static void main (String[] args)
	 {
	 Scanner sc=new Scanner(System.in);
	 int t=sc.nextInt();
	 while(t-- > 0)
	 {
	     int n=sc.nextInt();
	     int a[]=new int[n];
	     for(int i=0;i<n;i++)
	     a[i]=sc.nextInt();
	     System.out.println(solve(a,1,n-1));
	 }
	 }
	 public static int solve(int a[],int i,int j)
	 {
	     if(i==j)
	     return 0;
	     int min=Integer.MAX_VALUE;
	     for(int k=i;k<=j-1;k++)
	     {
	         int temp=solve(a,i,k)+solve(a,k+1,j)+(a[i-1]*a[k]*a[j]);
	         if(temp<min)
	         min=temp;
	     }
	     return min;
	 }
}