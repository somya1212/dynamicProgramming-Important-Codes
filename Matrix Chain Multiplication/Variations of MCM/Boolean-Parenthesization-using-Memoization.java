/*

Boolean Parenthesization 

Given a boolean expression with following symbols.

Symbols
    'T' ---> true
    'F' ---> false

And following operators filled between symbols

Operators
    &   ---> boolean AND
    |   ---> boolean OR
    ^   ---> boolean XOR

Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.

For Example:
The expression is "T | T & F ^ T", it evaluates true
in 4 ways ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T)
and (T|((T&F)^T)).

Return No_of_ways Mod 1003.

Input:
First line contains the test cases T.  1<=T<=500
Each test case have two lines
First is length of string N.  1<=N<=100
Second line is string S (boolean expression).
Output:
No of ways Mod 1003.
 

Example:
Input:
2
7
T|T&F^T
5
T^F|F

Output:
4
2         */



import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static char[] s;
    public static Map<String, Integer> hm = new HashMap<String, Integer>();
    
	public static void main (String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t!=0){
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine().trim();
            s = str.toCharArray(); 
            System.out.println(solve(0,n-1,true));
            hm.clear();
            t--;
        }
	}
	public static int solve(int i, int j, boolean isTrue){
	    int ans = 0;
	    if(i>j)
	        return 0;
	    if(i==j){
	        if(isTrue==true)
	            return (s[i]=='T')?1:0;
	        else
	            return (s[i]=='F')?1:0;
	    }
	    String temp = Integer.toString(i) + " " + Integer.toString(j) + " " + Boolean.toString(isTrue);
	    for (Map.Entry<String, Integer> set : hm.entrySet()) {
            if(set.getKey().equals(temp))
                return set.getValue();
		}
	    for(int k=i+1; k<=j-1; k+=2){
            int lt = solve(i,k-1,true);
            int lf = solve(i,k-1,false);
            int rt = solve(k+1,j,true);
            int rf = solve(k+1,j,false);
            if(s[k]=='&'){
                if(isTrue==true)
                    ans+=(lt*rt);
                else
                    ans+=(lf*rt)+(lt*rf)+(lf*rf);
            }else if(s[k]=='|'){
                if(isTrue==true)
                    ans+=(lt*rt)+(lt*rf)+(lf*rt);
                else
                    ans+=(lf*rf); 
            }else{
                if(isTrue==true)
                    ans+=(lf*rt)+(lt*rf);
                else
                    ans+=(lt*rt)+(lf*rf);
            }
	    }
	    hm.put(temp,ans%1003);
	    return ans%1003;
	}
}