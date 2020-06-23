package knapsack;
import java.util.*;
public class Knapsack {
static int max(int a,int b)
{
    if(a>b)
        return a;
    else
        return b;
}
static int max_profit(int value[],int wt[],int W ,int n)
{
    int t[][]=new int[n+1][W+1];
    for(int i=0;i<n+1;i++)
        for(int j=0;j<W+1;j++)
            if(i==0 || j==0)
            {
                t[i][j]=0;
            }
    for(int i=1;i<n+1;i++)
    {
        for(int j=1;j<W+1;j++)
        {
            if(wt[i-1]<j)
            {
                t[i][j]=max(value[i-1]+t[i-1][j-wt[i-1]],t[i-1][j]);
            }
            else
                t[i][j]=t[i-1][j];
        }
    }
    return t[n][W];
}
    public static void main(String[] args) {
        int value[]={7,3,2,11};
        int weight[]={11,2,3,4};
        int weight_bag=15;
        System.out.println(max_profit(value,weight,weight_bag,value.length));
    }
    
}
