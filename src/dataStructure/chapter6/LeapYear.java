package dataStructure.chapter6;

public class LeapYear {
    public static void main(String[] args) {
        System.out.println(leapYear(2018));
    }
    public static int leapYear(int year){
        if((year%400==0 || year%100!=0) && year%4==0){
            return 1;
        }else {
            return 0;
        }

    }
}
