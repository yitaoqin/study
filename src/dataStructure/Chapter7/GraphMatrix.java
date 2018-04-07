package dataStructure.Chapter7;

public class GraphMatrix {
        static final int MaxNum=20;
        char[] vertex=new char[MaxNum];//顶点信息
        int gType;//1-无向图，2-有向图
        int vertexNum;//顶点数量
        int edgeNum;//边数
        int[][] edgeWeight=new int[MaxNum][MaxNum];//
        int [] isTrav=new int[MaxNum];
}
