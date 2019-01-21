package datastructure.graph;

import java.util.Scanner;

/**
 * Created by pengsel on 2019/1/21.
 */
public class MGraph {
    public static final int MAXSIZE=100;
    public static final int INFINITY=2147483647;
    public int numVertexes;
    public int numEdges;
    public char[] vexs=new char[MAXSIZE];
    public int[][] arc=new int[MAXSIZE][MAXSIZE];

    /**
     * 建立无向网图的邻接矩阵表示
     */
    public void createMGraph(){
        int i,j,k,w;
        System.out.println("输入顶点数和边数:");
        Scanner scanner=new Scanner(System.in);
        numVertexes=scanner.nextInt();
        numEdges=scanner.nextInt();
        System.out.println("输入顶点信息:");
        for (i=0;i<numVertexes;i++){
            vexs[i]=scanner.next("[A-Za-z]").charAt(0);

        }

        for (i=0;i<numVertexes;i++){
            for (j=0;j<numVertexes;j++){
                arc[i][j]=INFINITY;
            }
        }

        System.out.println("共需输入"+numEdges+"条边\n输入格式为：\ni(vi下标) j(vj下标) w((vi,vj)的权):");
        for (k=0;k<numEdges;k++){
            System.out.println("正在输入第"+k+"条边：");
            i=scanner.nextInt();
            j=scanner.nextInt();
            w=scanner.nextInt();
            arc[i][j]=w;
            arc[j][i]=arc[i][j];
        }
    }

    public static void main(String[] args) {
        MGraph graph=new MGraph();
        graph.createMGraph();
    }
}
