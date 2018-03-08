package dataStructure.sort;

import java.util.Arrays;

public class InsertionSort extends BaseSort implements Sort {
    @Override
    public void execute() {
        int i,j,t,len=shuzu.length;
        for (i = 1; i < len; i++) {
            t=shuzu[i];
            j=i-1;
            while (j>=0 && t<shuzu[j]){
                shuzu[j+1]=shuzu[j];
                j--;
            }
            shuzu[j+1]=t;
//            System.out.println(String.format("%s第%d步排序结果：%s",
//                    this.getClass().getName(),i, Arrays.toString(shuzu)));
        }

    }
}
