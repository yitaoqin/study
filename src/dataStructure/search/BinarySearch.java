package dataStructure.search;

public class BinarySearch implements Searcher {

    @Override
    public void search(int a[],int x) {
        int i=searchFun(a,a.length,x);
        System.out.println("下标位置："+i);
    }
    int searchFun(int a[],int len,int x){
        int mid,low,high;
        low=0;
        high=len-1;
        while (low<=high){
            mid=(low+high)/2;
            if(a[mid]==x){
                return mid;
            }else if(a[mid]>x){
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        return -1;
    }
}
