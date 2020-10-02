import java.util.*;
class abc
{
    static boolean check(int[] nums,int n)
    {
        int sum=0;
        for(int i:nums)
        {
            sum+=i;
        }
        if(sum%2!=0) return false;
        boolean dp[][]=new boolean[sum/2+1][n+1];
        for(int i=0;i<=n;i++)
        {
            dp[0][i]=true;
        }
        for(int i=1;i<=sum/2;i++)
        {
            dp[i][0]=false;
        }
        for(int i=1;i<=sum/2;i++)
        {
            for(int j=1;j<=n;j++)
            {
                dp[i][j]=dp[i][j-1];
                if(nums[j-1]<=i)
                    dp[i][j]=dp[i][j] || dp[i-nums[j-1]][j-1];
            }
        }
        return dp[sum/2][n];
    }
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        System.out.println(check(a,n)?"YES":"NO");
    }
}