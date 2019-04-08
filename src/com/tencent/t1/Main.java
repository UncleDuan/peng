package com.tencent.t1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int m = in.nextInt();
            int n = in.nextInt();
            int[] arr=new int[n];
            for (int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            int[] coinUsed=new int[m+1];
            coinUsed[0]=0;
            int sum=0;
            for (int i=1;i<=m;i++){
                coinUsed[i]=i;
                for (int j=1;j<=n;j++){
                    if (arr[j-1]<=i){
                        int temp=coinUsed[i-arr[j-1]]+1;
                        if (temp<coinUsed[i])
                            coinUsed[i]=temp;
                    }
                }
                sum+=coinUsed[i];
            }
            System.out.println();


        }
    }
}