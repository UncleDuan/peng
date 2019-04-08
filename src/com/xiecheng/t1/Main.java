package com.xiecheng.t1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String listNode = in.nextLine();
            String[] strs=listNode.split(",");
            int[] arr=new int[26];
            for (String s:strs){
                arr[s.charAt(0)-'a']++;
            }
            boolean hasCircle=false;
            for (int i :arr){
                if (i>1){
                    hasCircle=true;
                    break;
                }
            }
            System.out.println(hasCircle);
        }
    }
}