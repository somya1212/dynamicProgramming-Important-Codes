/*

Given a string s, find the longest palindromic substring in s. 
You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"

*/

class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<1 || s==null)
            return "";
        int first=0;
        int last=0;
        for(int i=0;i<s.length();i++)
        {
            int len1=expand(s,i,i);
            int len2=expand(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len>last-first)
            {
                first=i-((len-1)/2);
                last=i+(len/2);
            }
        }
        return s.substring(first,last+1);
    }
    public int expand(String s,int l,int r)
    {
        if(s==null || l>r)
            return 0;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
        {
            l--;
            r++;
        }
        return r-l-1;
    }
}