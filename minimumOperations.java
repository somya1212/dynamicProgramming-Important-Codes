/*
You are given a number N. You have to find the number of operations 
required to reach N from 0. You have 2 operations available:

Double the number
Add one to the number

Example:
Input:
2
8
7
Input:
4
5

Explanation:
Testcase1:
Input  : N = 8
Output : 4
0 + 1 = 1, 1 + 1 = 2, 2 * 2 = 4, 4 * 2 = 8
Testcase2:
Input  : N = 7
Output : 5
0 + 1 = 1, 1 + 1 = 2, 1 + 2 = 3, 3 * 2 = 6, 6 + 1 = 7

*/

import java.util.*;
import java.lang.*;
import java.io.*;

class main {
    public static void array(int a[],int n)
    {
        a[0]=0;a[1]=1;a[2]=2;
        for(int j=3;j<n;j++)
        {
            if(j%2==1)
            a[j]=a[j-1]+1;
            else
            a[j]=a[j/2]+1;
        }
    }
    
	public static void main (String[] args) throws IOException{
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int a[]=new int[10001];
		array(a,10001);
		int t=Integer.parseInt(bf.readLine());
		for(int i=0;i<t;i++)
		{
		    int n=Integer.parseInt(bf.readLine());
		    System.out.println(a[n]);
		}
	}
}
