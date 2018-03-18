package core.collection;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        String key="a";
        Map<String,Integer> counts=new HashMap<>();
        counts.merge(key,1,Integer::sum);
        counts.merge(key,2,Integer::sum);
        /*
        如果key与一个非null值v关联，将函数应用到v和Value，将key与结果关联，如果结果为null，删除此键。
        返回值为get(key)
         */
        counts.merge(key,3,Integer::sum);
        System.out.println(counts);

        /*
        将函数应用到key get(key)。将key与结果关联，如果结果为null，删除此键。
        返回值为get(key)
         */
        counts.compute("c", (k,v)->{
            System.out.println(k+"|compute|"+v);
            return 100;
        });
        System.out.println(counts);
        /*
        如果key与一个非 null值 v关联，将函数应用到key和v,j将key与结果关联，如果结果为null，删除此键。
        返回值为get(key)
         */
        counts.computeIfPresent("a", (k,v)->{
            System.out.println(k+"|computeIfPresent|"+v);
            return 200;
        });
        System.out.println(counts);
        /*
        将函数应用到key，除非key与一个非null值关联。将key与结果关联，如果结果为null，删除此键。
        返回值为get(key)
         */
        counts.computeIfAbsent("ss", (k)->{
            System.out.println(k+"|computeIfAbsent|");
            return 300;
        });
        System.out.println(counts);

        /*
        替换所有
         */
        counts.replaceAll((k,v)->{
            return 9;
        });
        System.out.println(counts);

        counts.forEach((k,v)->{
            System.out.println(k+"||"+v);
        });
    }
}
