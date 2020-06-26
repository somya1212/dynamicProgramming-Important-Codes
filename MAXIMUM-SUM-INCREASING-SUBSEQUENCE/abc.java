import java.util.*;
class abc
{
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        int msis[]=new int[n];
        for(int i=0;i<n;i++)
        {
            msis[i]=a[i];
            for(int j=0;j<i;j++)
            {
                if(a[j]<a[i])
                msis[i]=Math.max(msis[i],msis[j]+a[i]);
            }
        }
        int res=msis[0];
        for(int i=1;i<n;i++)
        {
            res=Math.max(res,msis[i]);
        }
        System.out.println(res);
    }
}