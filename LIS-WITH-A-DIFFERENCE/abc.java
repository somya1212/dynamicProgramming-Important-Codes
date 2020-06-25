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
        int diff=sc.nextInt();
        HashMap<Integer,Integer> hm=new HashMap<>();
        int res=Integer.MIN_VALUE;
        for(int i:a)
        {
            int temp=hm.getOrDefault(i-diff, 0)+1;
            res=Math.max(res,temp);
            hm.put(i,temp);
        }
        System.out.println(res);
    }
}