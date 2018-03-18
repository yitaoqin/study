package core.collection;

import java.util.Collections;
import java.util.Random;

public class CollectionsTest {
    public static void main(String[] args) {
        Collections.nCopies(100,"");
        Collections.binarySearch(Collections.EMPTY_LIST,"");
        Collections.checkedCollection(Collections.EMPTY_LIST,String.class);//检查集合是否都是string
        Collections.copy(Collections.EMPTY_LIST,Collections.EMPTY_LIST);
        Collections.disjoint(Collections.EMPTY_LIST,Collections.EMPTY_LIST);//是否有交集
        Collections.fill(Collections.EMPTY_LIST,"a");//集合中的元素全部替换为a
        Collections.frequency(Collections.EMPTY_LIST,"a");//集合中的元素为a的个数
        Collections.replaceAll(Collections.EMPTY_LIST,"a","d");//替换a->b
        Collections.reverse(Collections.EMPTY_LIST);//反转
        Collections.swap(Collections.EMPTY_LIST,1,10);//下标1和下标10的交换
        Collections.rotate(Collections.EMPTY_LIST,3);//旋转新的位置：(i-distance)%size
        Collections.shuffle(Collections.EMPTY_LIST,new Random());//随机排列集合

    }
}
