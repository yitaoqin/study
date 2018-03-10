package dataStructure.chapter6;

/**
 * 生成[m,n]个随机数
 */
public class CustomRandom {
    public static void main(String[] args) {
        double m=10,n=20;
        double[]r={5.0};
        for (int i = 0; i < 10; i++) {
            System.out.printf("%10.5f\n", m+(n-m)*rand(r));
        }
    }
    public static double rand(double[] r){
        double base,u,v,p,temp1,temp2,temp3;
        base=256.0;
        u=17.0;
        v=139.0;

        temp1=u*(r[0])+v;
        temp2=(int)(temp1/base);
        temp3=temp1-temp2*base;
        r[0]=temp3;
        p=r[0]/base;
        return p;
    }
}
