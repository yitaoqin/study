package dataStructure.suanfa;

import java.util.*;

/**
 * Created by QYT on 2018/2/11.
 */
public class P3_1 {
    private static void qiongJu(int head,int foot){
        int i,j;
        for(i=0;i<=head;i++){
            j=head-i;
            if(i*2+j*4==foot){
                System.out.println(String.format("鸡：%d；兔：%d。",i,j));
            }
        }
    }

    static Map<Integer,Integer> d=new HashMap<>();
    private static int fibonaci(int n){
        int t1,t2,sum;
        if(n==1||n==2){
            sum=1;

        }else {
            t1=fibonaci(n-1);
            t2=fibonaci(n-2);
            sum= t1+t2;

        }
        if(!d.containsKey(n))
            d.put(n,sum);
        return sum;
    }
    static long fact(long n){
        if(n<=1L){
            return 1L;
        }else{
            return n*fact(n-1);
        }
    }

    static int falseCoin(int[] coin,int low,int high){
        int i,sum1,sum2,sum3;
        int re=0;
        sum1=sum2=sum3=0;
        if(low+1==high){
            if(coin[low]<coin[high]){
                re=low+1;
                return re;
            }else {
                re=high+1;
                return re;
            }
        }
        int mid=low+(high-low)/2;
        if((high-low+1)%2==0){

            for (i = low; i <=mid  ; i++) {
                sum1=sum1+coin[i];
            }
            for(i=mid+1;i<=high; i++ ){
                sum2=sum2+coin[i];
            }
            if(sum1>sum2){
                re=falseCoin(coin,mid+1,high);
                return re;
            }else if(sum1<sum2){
                re=falseCoin(coin,low,mid);
                return re;
            }

        }else {
            for ( i = low; i <= mid-1; i++) {
                sum1=sum1+coin[i];
            }
            for ( i = mid+1; i <= high; i++) {
                sum2=sum2+coin[i];
            }
            sum3=coin[mid];
            if(sum1>sum2){
                re=falseCoin(coin,mid+1,high);
                return re;
            }else if(sum1<sum2){
                re=falseCoin(coin,low,mid-1);
                return re;
            }
            if(sum1+sum3==sum2+sum3){
                re=mid+1;
                return re;
            }
        }
        return re;
    }

    public static void main(String[] args) {
        qiongJu(35,94);
        int n=10;
        int sum=fibonaci(n);
        System.out.println(String.format("经过%d月，共繁殖%d对兔子。",n,sum));
        System.out.println(d);
        long dd=fact(11);
        System.out.println(dd);

        int [] coin={5,5,5,5,5,5,5,5,5,5,5,5,5,4,5,5,5,5,5,5,5,5,5,5};
        int jiabi=falseCoin(coin,0,coin.length-1);
        System.out.println(" 假币是："+jiabi+"重量为："+coin[jiabi-1]);

    }
}
