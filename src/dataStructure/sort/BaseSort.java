package dataStructure.sort;

import java.util.Random;

/**
 * Created by QYT on 2018/3/3.
 */
public class BaseSort {
    protected int[] shuzu={123,354,133,45,321,664,335,63,76,26,678,25,674,36,8,43,564,32,74,127,118,105,101
            ,112,100};
//    protected static int[] shuzu={127,118,105,101,112,100};
    public int[] getShuzu(int n){
        shuzu=new int[n];
        for (int i = 0; i < n; i++) {
            shuzu[i]= new Random().nextInt();
        }
        return shuzu;
    }
}
