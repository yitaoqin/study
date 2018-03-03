package core.lambda;

import java.util.Arrays;

/**
 * Created by QYT on 2018/3/3.
 */
public class LambdaTest {
    public static void main(String[] args) {
        String[] planets={"Mercury","Venus","Earth","Mars","Jupiter"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length:");
//        Arrays.sort(planets,(first,second)->first.length()-second.length());
        Arrays.sort(planets,new MethodReferenceTest()::length);
        System.out.println(Arrays.toString(planets));
    }
}

class MethodReferenceTest{
    public int length(String first,String second){
        return first.length()-second.length();
    }
}
