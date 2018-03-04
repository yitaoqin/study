package dataStructure.sort;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SortTestProxy {
    public static void main(String[] args) {
       /* Sort sort=new BubbleSort();
        sort=new SelectionSort();
//        sort=new InsertionSort();*/
        Sort sort=new ShellSort();
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
        System.out.println("before :"+method.getName());
        Object o=method.invoke(target,args);
        System.out.println("After :"+method.getName());
        return o;
    }
}
