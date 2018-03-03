package dataStructure.CLType;

/**
 * Created by QYT on 2018/2/3.
 */
public class P2_2 {
}
class DATA2{
    String key;
    String name;
    int age;
}
class CLType{
    DATA2 nodedata=new DATA2();
    CLType nextNode;
    //追加节点
    CLType CLAddEnd(CLType head,DATA2 nodedata){
        CLType node,htemp;
        if((node=new CLType())==null){
            System.out.println("申请内存失败");
            return null;
        }else {
            node.nodedata=nodedata;//保存节点
            node.nextNode=null;//设置表尾
            if(head==null){//头引用
                head=node;
                return head;
            }
            //查找链表末尾
            htemp=head;
            while (htemp.nextNode!=null){
                htemp=htemp.nextNode;
            }
            //找到链表末尾，将引用指向新增的节点
            htemp.nextNode=node;
            return head;
        }
    }
    //从头部添加
    CLType CLAddFirst(CLType head,DATA2 nodedata){
        CLType node;
        if((node=new CLType())==null){
            System.out.println("申请内存失败");
            return null;
        }else {
            node.nodedata=nodedata;
            node.nextNode=head;
            head=node;
            return node;
        }
    }

    CLType CLFindeNode(CLType head,String key){
        CLType htemp;
        htemp=head;
        while (htemp!=null){
            if(htemp.nodedata.key.compareTo(key)==0){
                return htemp;
            }
            htemp=htemp.nextNode;
        }
        return null;
    }

    CLType CLInsertNode(CLType head,String findkey,DATA2 nodedata){
        CLType node,nodetemp;
        if((node=new CLType()) == null){
            System.out.println("申请内存失败");
            return null;
        }
        node.nodedata=nodedata;
        nodetemp=CLFindeNode(head,findkey);
        if(nodetemp !=null){
            node.nextNode=nodetemp.nextNode;
            nodetemp.nextNode=node;
        }else {
            System.out.println("未找到正确插入位置");
            node=null;
        }
        return head;
    }

    int CLDeleteNode(CLType head,String key){
        CLType node,htemp;
        htemp=head;
        node=head;
        while (htemp!=null){
            if(htemp.nodedata.key.compareTo(key)==0){
                node.nextNode=htemp.nextNode;
                htemp=null;
                return 1;
            }else {
                node=htemp;
                htemp=htemp.nextNode;
            }
        }
        return 0;
    }

    int CLLength(CLType head){
        CLType htemp;
        int len=0;
        htemp=head;
        while (htemp!=null){
            len++;
            htemp=htemp.nextNode;
        }
        return len;
    }

    void CLAllNode(CLType head){
        CLType htemp;
        DATA2 nodeData;
        htemp=head;
        System.out.println("链表数据");
        while (htemp!=null){
            nodeData=htemp.nodedata;
            System.out.println("节点："+nodeData);
            htemp=htemp.nextNode;
        }
    }
}//