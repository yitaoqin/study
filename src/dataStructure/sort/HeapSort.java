package dataStructure.sort;

import java.util.Arrays;

public class HeapSort extends BaseSort implements Sort{
    @Override
    public void execute() {
        long b=System.currentTimeMillis();
        int [] shuzu=super.getShuzu(100000);
        long a=System.currentTimeMillis();
        System.out.println("数组生产时间："+(a-b));
        heap(shuzu);
//        System.out.println("最终："+ Arrays.toString(shuzu));
    }
    public void heap(int a[]){
        int n=a.length;
        int i,j,h,k;
        int t;
        for(i=n/2-1;i>=0;i--) {
            while ((j = 2 * i + 1) < n) {
                if ((j + 1) < n) {
                    if (a[j] < a[j + 1])
                        j++;
                }
                if (a[i] < a[j]) {
                    t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                    i = j;
                } else {
                    break;
                }
            }

        }
        /*System.out.println("原数据构成的堆：");
        for (h = 0; h < n; h++) {
            System.out.print(" " + a[h]);
        }
        System.out.println();*/
        for(i=n-1;i>0;i--){
            t=a[0];
            a[0]=a[i];
            a[i]=t;
            k=0;
            while ((j=2*k+1)<i){
                if((j+1)<i){
                    if(a[j]<a[j+1]){
                        j++;
                    }
                }
                if(a[k]<a[j]){
                    t=a[k];
                    a[k]=a[j];
                    a[j]=t;
                    k=j;
                }else {
                    break;
                }
                /*System.out.println("第"+(n-i)+"步排序结果：");
                for(h=0;h<n;h++){
                    System.out.print(" "+a[h]);
                }
                System.out.println();*/
            }

        }
    }
}
