package datastructure.graph;

import java.util.Scanner;

/**
 * Created by pengsel on 2019/1/26.
 * 邻接表(Adjcency List):数组和链表相结合的存储方法。
 * 1.顶点用一个一维数组存储（也可以用单链表存储，不过数组可
 * 以较容易的读取顶点信息，更加方便），每个数据元素还要存储
 * 指向第一个邻接点的指针。
 * 2.每个顶点vi的所有邻接点构成一个线性表，由于邻接点的个数
 * 不定，所以用单链表存储，无向图称为顶点vi的边表，有向图则
 * 称为顶点vi作为弧尾的出边表。
 *
 * 获取顶点的度，查顶点的边表中结点的个数，这对于有向图来说，
 * 只能求到出度，又是为了便于求入度，可以建立一个有向图的逆
 * 邻接表，会对每个顶点vi都建立一个链接为vi为弧头的表。
 */
public class GraphAdjList {

    public static final int MAXSIZE=100;
    public VertexNode[] adjList=new VertexNode[MAXSIZE];
    public int numVertexes,numEdges;

    public void createALGraph(GraphAdjList graph){

        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入顶点数和边数：");
        numVertexes=scanner.nextInt();
        numEdges=scanner.nextInt();
        for(int i=0;i<numVertexes;i++){
            System.out.println("输入第"+(i+1)+"个顶点");
            adjList[i].data=scanner.next("[A-Za-z]").charAt(0);
        }
        System.out.println("共需输入"+numEdges+"条边\n输入格式为：\ni(vi下标) j(vj下标) w((vi,vj)的权):");

        int i,j,w;
        EdgeNode temp=new EdgeNode();
        /**
         * 建立边表：
         * 对应i，j两个顶点的链表进行头插法。
         */
        for (int k=0;k<numEdges;k++){
            System.out.println("正在输入第"+k+"条边：");
            i=scanner.nextInt();
            j=scanner.nextInt();
            w=scanner.nextInt();
            temp.adjvex=j;
            temp.weight=w;
            temp.next=adjList[i].firstEdge;
            adjList[i].firstEdge=temp;

            temp.adjvex=i;
            temp.next=adjList[j].firstEdge;
            adjList[j].firstEdge=temp;
        }
    }
}
