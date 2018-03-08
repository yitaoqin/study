package dataStructure.sort;

import java.util.Arrays;
import java.util.Random;

public class ShellSort extends BaseSort implements Sort {
    @Override
    public void execute() {
        int[] shuzu=getShuzu(10);
        int len=shuzu.length;
        int i,j,h;
        int r,temp;
        int x=0;
        for(r=len/2;r>=1;r=r/2){
            for(i=r;i<len;i++){
                temp=shuzu[i];
                j=i-r;
                while (j>=0 && temp<shuzu[j]){
                    shuzu[j+r]=shuzu[j];
                    j-=r;
                }
                shuzu[j+r]=temp;
            }
            x++;
//            System.out.println(String.format("%s第%d步排序结果：%s",
//                    this.getClass().getName(),x, Arrays.toString(shuzu)));
        }
    }
    /*public int[] getShuzu(int n){
        int[] shuzu=new int[n];
        for (int i = 0; i < n; i++) {
            shuzu[i]= new Random().nextInt(1000);
        }
        return shuzu;
    }*/
    /*public void execute2() {
        int len=shuzu.length;
        int i,j,h;
        int r,temp;
        int x=0;
        for(r=len/2;r>=1;r=r/2){
            for(i=r;i<len;i++){
                temp=shuzu[i];
                j=i-r;
                if(r==1){

                }else {
                    if(shuzu[j]>shuzu[i]){
                        shuzu[i]=shuzu[j];
                        shuzu[j]=temp;
                    }
                }
                System.out.println(String.format("第%d对排序结果：%s",
                        i, Arrays.toString(shuzu)));
            }
            x++;
            System.out.println(String.format("%s第%d步排序结果：%s",
                    this.getClass().getName(),x, Arrays.toString(shuzu)));
        }
    }*/

}
