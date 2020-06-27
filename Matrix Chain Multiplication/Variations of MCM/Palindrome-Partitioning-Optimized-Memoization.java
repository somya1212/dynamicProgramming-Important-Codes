import java.util.*;
import java.lang.*;
import java.io.*;
class main
 {
	public static void main (String[] args)
	 {
	 Scanner sc=new Scanner(System.in);
	 int test=sc.nextInt();
	 while(test-->0)
	 {
	     String s=sc.next();
	     int n=s.length();
	     int t[][]=new int[n+1][n+1];
	     for(int row[]:t)
            Arrays.fill(row,-1);//Intialize elements by -1
	     System.out.println(solve(s,0,n-1,t));
	 }
	 }
	 public static boolean palindrome(String s,int i,int j)
	 {
	     while (i <= j) {
			if (s.charAt(i++) != s.charAt(j--)) {
				return false;
			}
		}
		return true;
	  }
	  public static int solve(String s,int i,int j,int t[][])
	  {
	      if(i==j||palindrome(s,i,j))
	      return 0;
	      int ans=Integer.MAX_VALUE;
	      int left=0,right=0;
	      if(t[i][j]!=-1)
	     return t[i][j];
	    else
	    {
	      for(int k=i;k<=j-1;k++)
	      {
	          
	          if(t[i][k]!=-1)
	          left=t[i][k];
	          else
	          {
	              left=solve(s,i,k,t);
	              t[i][k]=left;
	          }
	          if(t[k+1][j]!=-1)
	          right=t[k+1][j];
	          else
	          {
	              right=solve(s,k+1,j,t);
	              t[k+1][j]=right;
	          }
	          int temp=1+left+right;
	          if(temp<ans)
	          ans=temp;
	          t[i][j]=ans;
	      }
	    }
	      return t[i][j];
	  }
}