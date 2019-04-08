package com.zhcredit;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int k = in.nextInt();
            int[] h=new int[n];
            for (int i=0;i<h.length;i++){
                h[i]=in.nextInt();
            }
            Arrays.sort(h);
        }
    }
}