package dataStructure.shujujiegouwenti;

import java.util.Arrays;
import java.util.Random;

/**
 * 约瑟夫环
 */
public class Josephus {
    private static final int NUM=17;
    private static final int KILL_MAN=3;

    public static void main(String[] args) {
        //execute(2);
        execute2();
    }
    public static void execute2(){
        Josephus j=new Josephus();
        j.addHead(1,4);
        System.out.println(head);
        Random random=new Random();
        for (int i = 2; i < NUM; i++) {
            int e= random.nextInt(7);
            j.addTail(i,e);
            System.out.println(tail);
        }
        circleFun(head,4);
    }

    /**
     * 复杂环
     */
    private static LinkList head=null,tail=null;
    int size=0;
    public void addHead(int i,int psw){
        head=new LinkList(i,psw,head);
        if(tail == null){
            tail=head;
        }
        size++;
    }
    public void addTail(int i,int psw){
        tail.next=new LinkList(i,psw);
        tail=tail.next;
        tail.next=head;
        size++;
    }

    public static void circleFun(LinkList list,int m){
        LinkList p,q;
        int i;
        q=p=list;
        while (q.next != p){
            q=q.next;
        }
        System.out.println("游戏者按照如下的顺序出列。");
        while (p.next!=p){
            for (i = 0; i < m-1; i++) {
                q=p;
                p=p.next;
            }
            q.next=p.next;
            System.out.printf("第%d个人出列，其手中的出列数字为%d \n",p.no,p.psw);
        }
        System.out.printf("最后一个人是%d，其手中的出列数字为%d \n",p.no,p.psw);
    }

    /**
     * 简单环
     * @param alive
     */
    public static void execute(int alive){
        int [] man=new int[NUM];
        int count=1;
        int i=0,pos=-1;
        while (count<=NUM){
            do{
                pos=(pos+1)%NUM;
                //System.out.printf("pos=%2d\n",pos);
                if(man[pos]==0)
                    i++;
                if(i==KILL_MAN){
                    i=0;
                    break;
                }
            }while (true);
//            System.out.println("--");
            man[pos]=count;
           /* System.out.printf("第%2d个人自杀！约瑟夫编号为%2d",pos+1,man[pos]);
            if(count%2==1){
                System.out.printf(" -> ");
            }else {
                System.out.println(" ->");
            }*/
            count++;
            System.out.println(Arrays.toString(man));
        }
        System.out.println("终"+Arrays.toString(man));
        System.out.printf("这%d个想活的人在以下序号：\n",alive);
        alive=NUM-alive;//41-2 39
        for (i = 0; i < NUM; i++) {
            if(man[i]>alive)
                System.out.printf("初始编号：%d，约瑟夫编号：%d\n",i+1,man[i]);
        }
        System.out.println();
    }
}

class LinkList{
    int no;//游戏者编号
    int psw;//游戏者的 出列数字
    LinkList next;//下个节点

    public LinkList(int no, int psw) {
        this.no = no;
        this.psw = psw;
    }

    public LinkList(int no, int psw, LinkList next) {
        this.no = no;
        this.psw = psw;
        this.next = next;
    }

    @Override
    public String toString() {
        return "LinkList{" +
                "no=" + no +
                ", psw=" + psw +
                ", next.no=" + (next==null?"尾":next.no )+
                ", next.psw=" + (next==null?"尾":next.psw )+
                '}';
    }
}
