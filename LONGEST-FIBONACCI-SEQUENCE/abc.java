import java.util.*;
class abc
{
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int a[]=new int[n];
        HashMap<Integer,Integer> index=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
            index.put(a[i],i);
        }
        HashMap<Integer,Integer> len=new HashMap<>();
        int res=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                int k=index.getOrDefault(a[i]-a[j], -1);
                if(k>=0 && k<j)
                {
                    int l=len.getOrDefault(k*n+j,2)+1;
                    res=Math.max(res,l);
                    len.put(j*n+i,l);
                }
            }
        }
        System.out.println(res>=3?res:0);

    }
}