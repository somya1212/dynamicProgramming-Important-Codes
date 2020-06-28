import java.util.*;
import java.lang.*;
import java.io.*;
class main
 {
	public static void main (String[] args)
	 {
	 //code
	 Scanner sc=new Scanner(System.in);
	 int test=sc.nextInt();
	 while(test-- > 0)
	 {
	     int e=sc.nextInt();
	     int f=sc.nextInt();
	     System.out.println(solve(e,f));
	 }
	 }
	 public static int solve(int e,int f)
	 {
	     if(f==0 || f==1)
	     return f;
	     if(e==1)
	     return f;
	     int min=Integer.MAX_VALUE;
	     for(int k=1;k<=f;k++)
	     {
	         int temp=1+Math.max(solve(e-1,k-1),solve(e,f-k));
	         min=Math.min(min,temp);
	     }
	     return min;
	 }
}