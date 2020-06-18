
package equal_sum_partition_knapsack;
import java.util.*;
public class Equal_sum_partition_knapsack {
static boolean partition(int arr[],int n)
{
    
    int sum_arr=0;
    for(int i=0;i<arr.length;i++)
    {
       sum_arr=sum_arr+arr[i];
    }
    //so we need to find a subset whose sum is sum_arr/2
    boolean t[][]=new boolean[n+1][(sum_arr/2)+1];
    if(sum_arr%2!=0)
        return false;
    else
    {   
        for(int i=0;i<n+1;i++)
        {
            t[i][0]=true;
        }
        for(int j=1;j<sum_arr/2+1;j++)
        {
            t[0][j]=false;
        }
        //
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<sum_arr/2+1;j++)
            {
                if(arr[i-1]<=j)
                {
                    t[i][j]=(t[i-1][j-arr[i-1]] || t[i-1][j]);
                }
                else
                    t[i][j]=t[i-1][j]; 
            }
        }
    }
    return t[n][sum_arr/2];
}
    public static void main(String[] args) 
    {
        int arr[]={3,7,6,3,1};
        int arr2[]={7,4,5,2,1,7};
        int arr3[]={9,2,2,2,7,6};
        System.out.println(partition(arr,arr.length));
        System.out.println(partition(arr2,arr2.length));
        System.out.println(partition(arr3,arr3.length));
       
    }
    
}
