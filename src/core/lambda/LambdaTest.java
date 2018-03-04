package core.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.IntConsumer;

/**
 * Created by QYT on 2018/3/3.
 */
public class LambdaTest {
    public static void main(String[] args) {
        String d="";
        String[] planets={"Mercury","Venus","Earth","Mars","Jupiter"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length:");
        Arrays.sort(planets, Comparator.comparingInt(String::length));
//        Arrays.sort(planets,new MethodReferenceTest()::length);

        System.out.println(Arrays.toString(planets));

        repeat(10,System.out::println);
    }

   /* public static void repeat(int n,Runnable action){
        for (int i = 0; i < n; i++) {
            action.run();
        }
    }*/
    /*public static void repeat(int n,Function<String,Integer> action){
        for (int i = 0; i < n; i++) {
            Integer d=action.apply("");
        }
    }*/
    public static void repeat(int n,IntConsumer action){
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }
    }
}

class MethodReferenceTest{
    public int length(String first,String second){

        return first.length()-second.length();
    }
}
