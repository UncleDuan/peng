package com.meituan.t2;

import java.util.Scanner;

/**
 * 给你一棵含有n个结点的树,编号为0…n-1，这n个结点都被染成了黑色或白色，显然，对于一棵树而言，我们每去掉一条边，就能把树分成两部分。现在要求你把这棵树切开，使得每一个连通块内只有一个白色结点，问共有多少种切开的方式满足以上条件，如果被删除的边集不同，我们则认为两种方式不同，反之认为相同。
 *
 * 请输出方案数对1000000007取模的结果。
 *
 * 参考输入：
 *
 * 10
 *
 * 0 0 1 2 0 5 1 2 3
 *
 * 1 0 0 1 0 0 1 1 0 1
 *
 * 输入第一行仅包含一个正整数n，表示树包含的结点数量。（1<=n<=100000）
 *
 * 输入第二行包含n-1个数字，第i个数字表示第i个结点的根，我们认为0号结点是整棵树的根，第i个数字不超过i，即第i个结点的根一定是编号小于i的结点。
 *
 * 输入第三行包含n个数字，第i个数字表是第i-1个结点的颜色，仅由0和1组成，0表示第 i-1号节点的颜色是白色，1表示颜色为黑色。
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n=in.nextInt();
            int[] tree=new int[n];
            int[] color=new int[n];
            for (int i=1;i<n;i++)
                tree[i]=in.nextInt();
            for (int i=0;i<n;i++)
                color[i]=in.nextInt();

        }
    }
}
