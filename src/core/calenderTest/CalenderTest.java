package core.calenderTest;

import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by QYT on 2018/2/3.
 */
public class CalenderTest {
    public static void main(String[] args) {
        LocalDate date=LocalDate.now();
        LocalDate date2=date;
//        System.out.println(date == date2);
        int month=date.getMonthValue();
        int today=date.getDayOfMonth();
//        System.out.printf("month=%d,today=%d",month,today);
        date=date.minusDays(today-1);
//        System.out.printf("date.minusDays(today-1)==%s",date.toString());
        DayOfWeek weekday=date.getDayOfWeek();
        int value=weekday.getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 0; i < value; i++) {
            System.out.print("   ");
        }
        while (date.getMonthValue() == month){
            System.out.printf("%3d",date.getDayOfMonth());
            if(date.getDayOfMonth() == today)
                System.out.print("*");
            else
                System.out.print(" ");
            date=date.plusDays(1);
            if(date.getDayOfWeek().getValue() == 1) System.out.println();
        }
        if(date.getDayOfWeek().getValue() != 1) System.out.println();

        System.out.println(NumberFormat.getCurrencyInstance().format(888.445));
        System.out.println(NumberFormat.getIntegerInstance().format(888.445));
        System.out.println(NumberFormat.getNumberInstance().format(888.445));
        System.out.println(NumberFormat.getInstance().format(888.445));
       // System.out.println(NumberFormat.getCurrencyInstance().format(888.445));
    }
}
