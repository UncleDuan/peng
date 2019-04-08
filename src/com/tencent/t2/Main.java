package com.tencent.t2;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            int len=in.nextInt();
            String str = in.next();
            int count0=0;
            for (int i=0;i<str.length();i++){
                if (str.charAt(i)=='0')
                    count0++;
            }
            System.out.println(Math.abs(len-2*count0));
        }
    }
}