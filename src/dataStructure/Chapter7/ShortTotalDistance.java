package dataStructure.Chapter7;

import java.util.Map;
import java.util.Scanner;


/**
 * 最短总距离\最短距离
 */
public class ShortTotalDistance {
    static final int MaxValue=65535;
    static final int used=0;
    static final int noL=-1;
    static Scanner input=new Scanner(System.in);

    static int[] path=new int[GraphMatrix.MaxNum];
    static int[] tmpVertex=new int[GraphMatrix.MaxNum];

    /**
     * 最短距离
     * @param gm
     * @param vend
     */
    static void distanceMin(GraphMatrix gm,int vend){
        int[] weight=new int[GraphMatrix.MaxNum];
        int i,j,k,min;
        vend--;
        for (i = 0; i < gm.vertexNum; i++) {
            weight[i]=gm.edgeWeight[vend][i];
        }
        for (i = 0; i < gm.vertexNum; i++) {
            if(weight[i]<MaxValue && weight[i]>0){
                path[i]=vend;
            }
        }
        for (i = 0; i < gm.vertexNum; i++) {
            tmpVertex[i]=0;
        }

        tmpVertex[vend]=1;
        weight[vend]=0;
        for (i = 0; i < gm.vertexNum; i++) {
            min= MaxValue;
            k=vend;
            for ( j = 0; j <gm.vertexNum ; j++) {
                if(tmpVertex[j]==0 && weight[j]<min){
                    min=weight[j];
                    k=j;
                }
            }
            tmpVertex[k]=1;
            for ( j = 0; j < gm.vertexNum; j++) {
                if(tmpVertex[j]==0 && weight[k]+gm.edgeWeight[k][j]<weight[j]){
                    weight[j]=weight[k]+gm.edgeWeight[k][j];
                    path[j]=k;
                }
            }
        }
    }

    /**
     * 最短总距离
     * @param gm
     */
    static void primGraph(GraphMatrix gm){
        int j,i,k,min,sum;
        int [] weight=new int[GraphMatrix.MaxNum];
        char[] vtempx=new char[GraphMatrix.MaxNum];
        sum=0;
        for (i = 0; i < gm.vertexNum; i++) {
            weight[i]=gm.edgeWeight[0][i];
            if(weight[i]==MaxValue){
                vtempx[i]=(char) noL;
            }else {
                vtempx[i]=gm.vertex[0];
            }
        }
        vtempx[0]=used;
        weight[0]=MaxValue;
        for ( i = 0; i < gm.vertexNum; i++) {
            min=weight[0];
            k=i;
            for (j = 0; j < gm.vertexNum; j++) {
                if(weight[j]<min && vtempx[j]>0){
                    min=weight[j];
                    k=j;
                }
            }
            sum+=min;
            System.out.printf("(%c,%c)",vtempx[k],gm.vertex[k]);
            vtempx[k]=used;
            weight[k]=MaxValue;
            for (j = 0; j < gm.vertexNum; j++) {
                if(gm.edgeWeight[k][j]<weight[j] && vtempx[j]!=0){
                    weight[j]=gm.edgeWeight[k][j];
                    vtempx[j]=gm.vertex[k];
                }
            }

        }
        System.out.printf("最短距离%d",sum);
    }
    static void createGraph(GraphMatrix gm){
        int i,j,k;
        int weight;
        char eStartV,eEndV;
        System.out.print("输入途中各定点信息：\n");
        for (i = 0; i < gm.vertexNum; i++) {
            System.out.printf("第%d个定点;",i+1);
            gm.vertex[i]=input.next().toCharArray()[0];
        }
        System.out.print("输入构成各边的定点和全职：\n");
        for (k=0;k<gm.edgeNum;k++){
            System.out.printf("%d边",k+1);
            eStartV=input.next().charAt(0);
            eEndV=input.next().charAt(0);
            weight=input.nextInt();
            for(i=0;eStartV!=gm.vertex[i];i++);
            for(j=0;eEndV!=gm.vertex[j];j++);
            gm.edgeWeight[i][j]=weight;
            if(gm.gType==0)
                gm.edgeWeight[j][i]=weight;
        }
    }

    static void clearGraph(GraphMatrix gm){
        int i,j;
        for (i = 0;  i< gm.vertexNum;i++) {
            for (j = 0; j < gm.vertexNum; j++) {
                gm.edgeWeight[i][j]=MaxValue;
            }
        }
    }
    static void outGraph(GraphMatrix gm){
        int i,j;
        for(j=0;j<gm.vertexNum;j++){
            System.out.printf("%c",gm.vertex[j]);
        }
        System.out.print("\n");
        for (i = 0;  i< gm.vertexNum; i++) {
            System.out.printf("%c",gm.vertex[j]);
            for(j=0;j<gm.vertexNum;j++){
                if(gm.edgeWeight[i][j]==MaxValue){
                    System.out.printf("\tZ");
                }else {
                    System.out.printf("\t%d",gm.edgeWeight[i][j]);
                }
            }
            System.out.print("\n");
        }
    }



    public static void main(String[] args) {
        GraphMatrix gm=new GraphMatrix();
        gm.gType=4;
        gm.vertexNum=6;
        gm.edgeNum=7;
        clearGraph(gm);
        createGraph(gm);
        //primGraph(gm);
        int vend=3,k;
        distanceMin(gm,vend);
        vend--;
        System.out.printf("个顶点到%c的最短距离分别为（起始-结束）：\n",gm.vertex[vend]);
        for (int i = 0; i < gm.vertexNum; i++) {
            if(tmpVertex[i]==1){
                k=i;
                while (k!=vend){
                    System.out.printf("定点%c - ",gm.vertex[k]);
                    k=path[k];
                }
                System.out.printf("定点%c\n",gm.vertex[k]);
            }else {
                System.out.println("无路径\n");
            }
        }
    }
}
