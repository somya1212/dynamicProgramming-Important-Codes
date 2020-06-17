/*
Problem Statement : A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

Here, we need to return the length of longest common subsequence of the given two strings.

Approach : Here, I used recursive approach but usually the time limit gets exceeded in recursion because of redundant calls.
 
*/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
     
   
        char x[]=text1.toCharArray();
        char y[]=text2.toCharArray();
        int n=x.length;
    int m=y.length;
        return lcs(x,y,n,m);
        
    }
    public int lcs(char x[],char y[],int n,int m)//declaration of function
{
        if(n==0 || m==0) // base condition
            return 0;
    if(x[n-1]==y[m-1])
        return 1+lcs(x,y,n-1,m-1);//add 1 and call for the second last character
    else
        return Math.max(lcs(x,y,n-1,m),lcs(x,y,n,m-1));// call for comparison between last character
// of 1st string and second last character of 2nd string and vice versa and then take the maximum.
    }
}