package dataStructure.stackType;

import java.util.Stack;

/**
 * Created by QYT on 2018/2/4.
 */
public class P2_3 {
    public static void main(String[] args) {
        StackType stackType=new StackType();
        Data3 d1=new Data3("你你你",23);
        Data3 d2=new Data3("你你你",24);
        Data3 d3=new Data3("你你你",25);
        stackType.pushST(d1);
        stackType.pushST(d2);
        stackType.pushST(d3);

        int size=stackType.size();
        for (int i = 0; i < 4; i++) {
            System.out.println( stackType.popST());
        }

    }
}

class Data3{
    Data3(String n,int a){
        name=n;
        age=a;
    }
    String name;
    int age;

    @Override
    public String toString() {
        return "Data3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class StackType{
    static final int MAXLEN=50;
    Data3[] data=new Data3[MAXLEN+1];
    int top;

    StackType STInit(){
       // StackType p=new StackType();
        if(this !=null){
            this.top=0;
            return this;
        }
        return null;
    }
    boolean STIsEmpty(){
        return this.top == 0;
    }
    boolean STIsFull(){
        return this.top == MAXLEN;
    }
    void STClear(){
        this.top=0;
    }
    void STFree(){
        if(this !=null){
            this.data=null;
        }
    }

    int pushST( Data3 data){
        if((this.top+1)>MAXLEN){
            System.out.println("yi chu");
            return 0;
        }
        this.data[top++]=data;
        System.out.println("top="+top);
        return 1;
    }
    Data3 popST(){
        if(top==0){
            System.out.println("zhai kong");
            return null;
        }
        top--;
        return this.data[top];
    }
    Data3 peekST(){
        if(top==0){
            System.out.println("zhai kong");
            return null;
        }
        return this.data[top];
    }
    int size(){
        return top;
    }
}