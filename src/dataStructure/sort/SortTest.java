package dataStructure.sort;

/**
 * Created by QYT on 2018/3/3.
 */
public class SortTest {
    public static void main(String[] args) {
        Sort sort=new BubbleSort();
        sort=new SelectionSort();
        sort=new ShellSort();
//        sort=new InsertionSort();
        sort.execute();
    }

}
