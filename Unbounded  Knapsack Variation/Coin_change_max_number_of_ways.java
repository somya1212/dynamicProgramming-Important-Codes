//
//package coin_change_max_number_of_ways;
public class Coin_change_max_number_of_ways {

    static int ways(int arr[],int p,int n)
    {
        int t[][]=new int[n+1][p+1];
        for(int i=0;i<n+1;i++)
        {
            for (int j=0;j<p+1;j++)
            {
                if(i==0)
                    t[i][j]=0;
                if(j==0)
                    t[i][j]=1;
            }
        }
        for(int i=1;i<n+1;i++)
        {
            for (int j=1;j<p+1;j++)
            {
                if(arr[i-1]<=j)
                {
                    t[i][j]=t[i][j-arr[i-1]]+t[i-1][j];
                }
                else
                    t[i][j]=t[i-1][j];
            }
                
        }
        return t[n][p];
    }
    public static void main(String[] args) {
        int change[]= {1,2,3};
        int p=4;
        System.out.println(ways(change,p,change.length));
    }
    
}
