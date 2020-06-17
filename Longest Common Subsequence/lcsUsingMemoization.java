/*
 Approach : Recursion using Memoization. The time complexity of this problem is O(n*m), where
n and m are the lengths of the given strings.
- If we draw the complete recursion tree of the recursive approach, 
then we can see that there are many subproblems which are solved again and again. 
So this problem has Overlapping Substructure property and recomputation of same subproblems  that can be avoided
by using Memoization.
- A common point of observation to use memoization in the recursive code will be 
the two non-constant arguments n and m in every function call. 
The function has 4 arguments, but 2 arguments are constant which do not affect the Memoization.
The repetitive calls occur for n and m which have been called previously.
*/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
     
   
        char x[]=text1.toCharArray();
        char y[]=text2.toCharArray();
        int n=x.length;
    int m=y.length;
        int t[][]=new int[n+1][m+1];
        for(int row[]:t)
            Arrays.fill(row,-1);//Intialize elements by -1
        return lcs(x,y,n,m,t);
        
    }
    public int lcs(char x[],char y[],int n,int m,int t[][]){
        if(n==0 || m==0)
            return 0;
        if(t[n][m] != -1)// if the same state has already been computed 
            return t[n][m];
    if(x[n-1]==y[m-1])// if equal, then we store the value of the function call  
        return t[n][m]=1+lcs(x,y,n-1,m-1,t);
    else
        return t[n][m]=Math.max(lcs(x,y,n-1,m,t),lcs(x,y,n,m-1,t));
    }
}