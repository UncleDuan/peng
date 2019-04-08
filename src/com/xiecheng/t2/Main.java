package com.xiecheng.t2;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String str=in.nextLine();
            String strk=in.nextLine();
            String[] strs=str.substring(1,str.length()-1).split(",");
            int k=Integer.valueOf(strk);
            for (int i=0;i<strs.length;i++){
                if (i%k<k/2&&i<(strs.length-strs.length%k)){
                    String temp=strs[i];
                    strs[i]=strs[i+k-2*(i%k)-1];
                    strs[i+k-2*(i%k)-1]=temp;
                }
            }
            StringBuilder sb=new StringBuilder();
            sb.append("[");
            for (int i=0;i<strs.length;i++) {
                sb.append(strs[i]);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("]");
            System.out.println(sb.toString());

        }
    }
}