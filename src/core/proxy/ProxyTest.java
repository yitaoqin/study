package core.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {
    public static void main(String[] args) {
        Object[] eles=new Object[1000];
        for (int i = 0; i < eles.length; i++) {
            Integer value=i+1;
            InvocationHandler handler=new TraceHandler(value);
            Object proxy=Proxy.newProxyInstance(null,new Class[]{Comparable.class},handler);
            eles[i]=proxy;
        }
        Integer key=new Random().nextInt(eles.length)+1;
        int result=Arrays.binarySearch(eles,key);
        if(result>=0) System.out.println(eles[result]);
    }
}
class TraceHandler implements InvocationHandler{

    private Object target;
    public TraceHandler(Object t){
        target=t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Throwable t=new Throwable();
        StackTraceElement[] dd=t.getStackTrace();
        for (StackTraceElement stackTraceElement : dd) {
            System.out.println(stackTraceElement);
        }

        System.out.print(target);
        System.out.print("."+ method.getName()+"(");
        if(args !=null){
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if(i<args.length-1) System.out.print(",");
            }
        }
        System.out.println(")");
        return method.invoke(target,args);
    }
}
