


public class Rod_cutting__unbounded_knapsack {
static int max(int a,int b)
{
    if(a>b)
        return a;
    else
        return b;
}
static int max_profit(int length[],int price[],int L ,int n)
{
    int t[][]=new int[n+1][L+1];
    for(int i=0;i<n+1;i++)
        for(int j=0;j<L+1;j++)
            if(i==0 || j==0)
            {
                t[i][j]=0;
            }
    for(int i=1;i<n+1;i++)
    {
        for(int j=1;j<L+1;j++)
        {
            if(length[i-1]<=j)
            {
                t[i][j]=max(price[i-1]+t[i][j-length[i-1]],t[i-1][j]);
            }
            else
                t[i][j]=t[i-1][j];
        }
    }
    return t[n][L];
}
    public static void main(String[] args) {
        int price[]={1, 5, 8, 9, 10, 17, 17, 20};
        int length[]={1,2,3,4,5,6,7,8};
        int length_rod=8;
        System.out.println(max_profit(length,price,length_rod,price.length));
    }
    
}
