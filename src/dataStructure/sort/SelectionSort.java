package dataStructure.sort;

import java.util.Arrays;

/**
 * 选择排序
 * Created by QYT on 2018/3/3.
 */
public class SelectionSort extends BaseSort implements Sort {
    @Override
    public void execute() {
        int index,temp;
        for (int i = 0; i <shuzu.length -1; i++) {
            index=i;
            for (int j = i+1; j <shuzu.length ; j++) {
                if(shuzu[j]<shuzu[index])
                    index=j;
            }
            if(index!=i){
                temp=shuzu[i];
                shuzu[i]=shuzu[index];
                shuzu[index]=temp;
            }
            System.out.println(String.format("%s第%d步排序结果：%s",this.getClass().getName(),i, Arrays.toString(shuzu)));
        }
    }
}
