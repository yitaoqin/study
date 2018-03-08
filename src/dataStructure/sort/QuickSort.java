package dataStructure.sort;

import java.util.Arrays;

public class QuickSort extends BaseSort implements Sort {
    @Override
    public void execute() {
        quickSort(shuzu,0,shuzu.length-1);
//        System.out.println(Arrays.toString(shuzu));
    }

    public void quickSort(int[] arr,int left,int right){
        int f,t;
        int rtemp,ltemp;
        ltemp=left;
        rtemp=right;
        f=arr[(left+right)/2];
        while (ltemp<rtemp){
            while (arr[ltemp]<f){
                ++ltemp;
            }
            while (arr[rtemp]>f){
                --rtemp;
            }
            if(ltemp<=rtemp){
                t=arr[ltemp];
                arr[ltemp]=arr[rtemp];
                arr[rtemp]=t;
                --rtemp;
                ++ltemp;
            }
        }
        if(ltemp==rtemp){
            ltemp++;
        }
        if(left<rtemp){
            quickSort(arr,left,ltemp-1);
        }
        if(ltemp<right){
            quickSort(arr,rtemp+1,right);
        }
    }

}
