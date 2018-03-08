package dataStructure.sort;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SortTestProxy {
    public static void main(String[] args) {
       Sort sort=new BubbleSort();//耗时：71535
        sort=new SelectionSort();//60649
        sort=new InsertionSort();//61893
        sort=new ShellSort();//332169
        sort=new QuickSort();//59716
        sort=new HeapSort();//59716
        InvocationHandler handler=new TraceHandler(sort);
        Sort o=(Sort)Proxy.newProxyInstance(sort.getClass().getClassLoader(),
                new Class[]{Sort.class},handler);
        o.execute();
    }
}
class TraceHandler implements InvocationHandler{

    private Object target;
    public TraceHandler(Object t){
        target=t;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy="+proxy.getClass().getName());
        long b=System.nanoTime();
        System.out.println("before :"+method.getName());
        Object o=method.invoke(target,args);
        long a=System.nanoTime();
        System.out.println("After :"+method.getName()+";totalNanoTime="+(a-b));
        return o;
    }
}
