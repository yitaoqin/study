package dataStructure.sort;

import java.util.Arrays;

/**
 * 冒泡排序；需要进行n-1步中间排序
 * Created by QYT on 2018/3/3.
 */
public class BubbleSort extends BaseSort implements Sort{

    @Override
    public void execute() {
        int temp;
        boolean flag;
        for (int i = 1; i < shuzu.length; i++) {
            flag=true;
            for (int j = 0; j < shuzu.length - i; j++) {
                if(shuzu[j]>shuzu[j+1]){
                    temp=shuzu[j];
                    shuzu[j]=shuzu[j+1];
                    shuzu[j+1]=temp;
                    flag=false;
                }
            }
//            System.out.println(String.format("第%d步排序结果：%s",i, Arrays.toString(shuzu)));
            if(flag)break;
        }
    }
}
