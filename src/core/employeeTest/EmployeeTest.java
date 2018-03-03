package core.employeeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by QYT on 2018/2/3.
 */
public class EmployeeTest {

    public static void main(String[] args) {
        Employee e=new Employee("qyt",15000,2017,4,20);
        Employee e2=e;
        System.out.println(e.equals(e2));

//        Manager []managers={new Manager("qyt2",15000,2017,4,20)};
//        Employee[] employees=managers;
//
//        employees[0]=new Employee("qyt",15000,2017,4,20);

//        managers[0].p();
//        "".equals()
        int[] i=new int[100];
        System.out.println(i.length);
        String[] planets={"Mercury","Venus","Earth","Mars","Jupiter"};
        List<String> list=new ArrayList<>(100);
//        list.trimToSize();
//        List<String> list=Arrays.asList(planets);
        for(String v:planets)
            list.add(v);
        System.out.println("Before: "+list);
        list.removeIf((String name)->name.length()==5);
        System.out.println("After: "+list);
    }
}
