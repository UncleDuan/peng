package com.netease.t2;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String lines=in.nextLine();
            int ls=Integer.valueOf(lines);
            String[] strings=new String[ls];
            for (int i=0;i<ls;i++){
                strings[i]=in.nextLine();
            }
            for (int i=0;i<ls;i++){
                System.out.println(p3(p2((p1(strings[i])))));
            }
        }
    }

    public static String[] CONVERTION_MAP={
            "0","1","2","3","4","5","6","7","8","9",
            "A","B","C","D","E","F","G",
            "H","I","J","K","L","M","N",
            "O","P","Q","R","S","T",
            "U","V","W","X","Y","Z"};
    public static String[] p1(String s){
        int la=s.length()%3;
        int len=s.length()%3>0?s.length()/3+1:s.length()/3;
        String[] strs=new String[len];
        strs[0]=s.substring(0,la);
        for (int i=1;i<len;i++){
            strs[i]=s.substring(la+3*(i-1),la+3*i);
        }
        return strs;
    }

    public static String p2(String[] strs){
        StringBuilder sb=new StringBuilder();
        sb.append(Integer.toBinaryString(Integer.valueOf(strs[0])));
        for(int i=1;i<strs.length;i++) {
            String str = Integer.toBinaryString(Integer.valueOf(strs[i]));
            for (int j = 0; j < (10 - str.length()); j++)
                sb.append("0");
            sb.append(str);
        }
        return sb.toString();
    }

    public static String p3(String s){
        int la=s.length()%5;
        int len=s.length()%5>0?s.length()/5+1:s.length()/5;
        String[] strs=new String[len];
        strs[0]=s.substring(0,la);
        for (int i=1;i<len;i++){
            strs[i]=s.substring(la+5*(i-1),la+5*i);
        }
        StringBuilder sb=new StringBuilder();
        for (String str:strs){
            sb.append(CONVERTION_MAP[Integer.parseInt(str,2)]);
        }
        return sb.toString();
    }

}
