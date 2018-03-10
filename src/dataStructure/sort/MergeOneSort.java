package dataStructure.sort;

import java.util.Arrays;

public class MergeOneSort extends BaseSort implements Sort {
    @Override
    public void execute() {
        long b=System.currentTimeMillis();
        int [] shuzu=super.getShuzu(100000);
        long a=System.currentTimeMillis();
        System.out.println("数组生产时间："+(a-b));
        mergeSort(shuzu,shuzu.length);
    }
    public void mergeOne(int a[],int b[],int n,int len){
        int i,j,k,s,e;
        s=0;
        while (s+len<n){
            e=s+2*len-1;
            if(e>=n){
                e=n-1;
            }
            k=s;
            i=s;
            j=s+len;
            while (i<s+len && j<=e){
                if(a[i]<=a[j]){
                    b[k++]=a[i++];
                }else {
                    b[k++]=a[i++];
                }
            }
            while (i<s+len){
                b[k++]=a[i++];
            }
            while (j<=e){
                b[k++]=a[j++];
            }
            s=e+1;
        }
        if(s<n){
            for(;s<n;s++)
                b[s]=a[s];
        }
    }

    public void mergeSort(int a[],int n){
        int h,count,len,f;
        count=0;
        len=1;
        f=0;
        int[]p=new int[n];
        while (len<n){
            if(f==1){
                mergeOne(p,a,n,len);
            }else {
                mergeOne(a,p,n,len);
            }
            len=len*2;
            f=1-f;

//            count++;
//            System.out.println(Arrays.toString(a));
        }
        if(f==1){
            for(h=0;h<n;h++){
                a[h]=p[h];
            }
        }
    }
}
