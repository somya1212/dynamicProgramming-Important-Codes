?// Length of Longest Common Subsequence

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
     
   
        char x[]=text1.toCharArray();
        char y[]=text2.toCharArray();
        int n=x.length;
        int m=y.length;
        int t[][]=new int[n+1][m+1];
      return lcs(x,y,n,m,t);
        
    }
    public int lcs(char x[],char y[],int n,int m,int t[][]){
        
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                if(i==0 || j==0)
                    t[i][j]=0;
           
                else if(x[i-1]==y[j-1])
                    t[i][j]=t[i-1][j-1]+1;
                else
                    t[i][j]=Math.max(t[i][j-1],t[i-1][j]);
            }
        }
        return t[n][m];
    }
}
