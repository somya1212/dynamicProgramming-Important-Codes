/*

Total Decoding Messages 
A top secret message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
You are an FBI agent. You have to determine the total number of ways that message can be decoded.
Note: An empty digit sequence is considered to have one decoding. It may be assumed that the input contains valid digits 
from 0 to 9 and If there are leading 0’s, extra trailing 0’s and two or more consecutive 0’s then it is an invalid string.

Example :
Given encoded message "123",  it could be decoded as "ABC" (1 2 3) or "LC" (12 3) or "AW"(1 23).
So total ways are 3.

Input:
First line contains the test cases T.  1<=T<=1000
Each test case have two lines
First is length of string N.  1<=N<=40
Second line is string S of digits from '0' to '9' of N length.

Example:
Input:
2
3
123
4
2563
Output:
3
2 

Note : Foe detailed explanation of solution, watch here : https://www.youtube.com/watch?time_continue=525&v=Km4iqih6WjI&feature=emb_logo        */


import java.util.Scanner;
public class Decode_Ways {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    String str = sc.next();
		    System.out.println(numDecodings(str));
		}
	}

	// Time Complexity - O(n) , Space Complexity - O(1)
	public static int numDecodings(String s) {
		int first = 1;
		int second = s.charAt(0) == '0' ? 0 : 1;
		for (int i = 2; i <= s.length(); i++) {
			int ans = 0;
			int onedigit = Integer.parseInt(s.substring(i - 1, i));
			int twodigit = Integer.parseInt(s.substring(i - 2, i));
			if (onedigit >= 1) {
				ans += second;
			}
			if (twodigit >= 10 && twodigit <= 26) {
				ans += first;
			}
			first = second;
			second = ans;
		}
		return second;
	}

	// Time Complexity - O(n) , Space Complexity - O(n)
	public static int numDecoding(String s) {
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;
		for (int i = 2; i <= s.length(); i++) {
			int onedigit = Integer.parseInt(s.substring(i - 1, i));
			int twodigit = Integer.parseInt(s.substring(i - 2, i));
			if (onedigit >= 1) {
				dp[i] += dp[i - 1];
			}
			if (twodigit >= 10 && twodigit <= 26) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[s.length()];
	}

}
