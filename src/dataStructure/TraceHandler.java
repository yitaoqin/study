package dataStructure;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TraceHandler  implements InvocationHandler {

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