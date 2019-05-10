package com.jd.t1;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int k=in.nextInt();
            int size=k-1;
            int[][] arr=new int[size][2];
            for (int i=0;i<size;i++){
                arr[i][0]=in.nextInt();
                arr[i][1]=in.nextInt();
            }
            int left=0;
            int right=0;
            for (int i=0;i<size;i++){
                if (left==0&&arr[i][0]==1)
                    left=arr[i][1];
                if (left==0&&arr[i][1]==1)
                    left=arr[i][0];

                if(left!=0&&arr[i][0]==1)
                    right=arr[i][1];
                if(left!=0&&arr[i][1]==1)
                    right=arr[i][0];
            }
            int numleft=getNum(arr,left,size,1);
            int numright=getNum(arr,right,size,1);
            System.out.println(Math.max(numleft,numright));

        }
    }

    public static int getNum(int[][] arr,int root,int size,int father){
        if (root==0)
            return 0;
        int count=1;
        for (int i=0;i<size;i++){
            if (arr[i][0]==root&&arr[i][1]!=father){
                count=count+getNum(arr,arr[i][1],size,root);
            }
            if (arr[i][1]==root&&arr[i][0]!=father){
                count=count+getNum(arr,arr[i][0],size,root);
            }

        }
        return count;
    }
}