package core.paramTest;

/**
 * Created by QYT on 2018/2/4.
 */
public class ParamTest {

    public static void main(String[] args) {
        System.out.println("Testing tripleValue:");
        double percent=10;
        System.out.println("Before: percent="+percent);
        tripleValue(percent);
        System.out.println("After: percent="+percent);

        System.out.println("\nTesting tripleSalary:");
        Employee harry=new Employee("Harry",50000);
        System.out.println("before:"+harry.getSalary());
        tripleSalary(harry);
        System.out.println("after:"+harry.getSalary());

        System.out.println("\nTesting swap:");
        Employee a=new Employee("a",100);
        Employee b=new Employee("b",200);
        System.out.println("before :a="+a.getName());
        System.out.println("before :b="+b.getName());
        swap(a,b);
        System.out.println("after :a="+a.getName());
        System.out.println("after :b="+b.getName());
    }
    public static void tripleValue(double x){
        x=3*x;
        System.out.println("End of method:x="+x);
    }
    public static void tripleSalary(Employee x){
        x.raiseSalary(200);
        System.out.println("End of method: salary="+x.getSalary());
    }
    public static void swap(Employee a,Employee b){
        Employee temp=a;
        a=b;
        b=temp;
        System.out.println("End of method :a="+a.getName());
        System.out.println("End of method :b="+b.getName());
    }
}
class Employee{
    private String name;
    private double salary;
    public Employee(String n,double s){
        name=n;
        salary=s;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
    public void raiseSalary(double byPercent){
        double raise=salary*byPercent/100;
        salary+=raise;
    }
}