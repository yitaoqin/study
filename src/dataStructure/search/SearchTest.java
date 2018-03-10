package dataStructure.search;

import dataStructure.TraceHandler;
import dataStructure.sort.BaseSort;
import dataStructure.sort.QuickSort;
import dataStructure.sort.SortTestProxy;

import java.lang.reflect.Proxy;
import java.util.Arrays;

public class SearchTest {

    public static void main(String[] args) {
        int size=100000;
//        int[] a=new BaseSort().getShuzu(size);
        int[] a={123,354,133,45,321,664,335,63,76,26,678,25,674,36,8,43,564,32,74,127,118,105,101
                ,112,100};
        new QuickSort().quickSort(a,0,a.length-1);
        System.out.println("排序后的数组："+ Arrays.toString(a));
        Searcher searcher=new BinarySearch();
        Searcher s=(Searcher)Proxy.newProxyInstance(searcher.getClass().getClassLoader(),new Class[]{Searcher.class},new TraceHandler(searcher));
        s.search(a,354);
    }
}
