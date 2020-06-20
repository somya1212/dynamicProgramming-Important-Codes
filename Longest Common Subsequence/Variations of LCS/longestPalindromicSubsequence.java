/*
Problem Statement : Given a string s, find the longest palindromic subsequence's length in s. 
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
 
Approach :
Here, in the above example the input is "bbbab" and the reverse will be "babbb".
Then, we see that "bbbb" is the lcs of the given string and reverse of it, which is basically
the longest palindromic subsequence of the given string.
So, we will find the reverse and the lcs of both the strings. 

*/

class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb=new StringBuilder();
        sb.append(s);
        sb=sb.reverse();//Find reverse
        char x[]=s.toCharArray();
        char[] y = new char[sb.length()]; 
        sb.getChars(0, sb.length(), y, 0); 
        int n=x.length;
        int m=y.length;
        int t[][]=new int[n+1][m+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                if(i==0 || j==0)
                    t[i][j]=0;
                else if(x[i-1]==y[j-1])
                    t[i][j]=1+t[i-1][j-1];
                else
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
            }
        }
        return (t[n][m]);// lcs of string and its reverse
    }
}