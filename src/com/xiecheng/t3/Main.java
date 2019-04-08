package com.xiecheng.t3;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String str = in.nextLine();
            String[] strs=str.split(" ");
            int n=Integer.valueOf(strs[0]);
            Map<String,Integer> map=new ConcurrentHashMap<String,Integer>();
            StringBuilder sb=new StringBuilder();
            for (int i=1;i<strs.length;i++){
                String pathStr=getPathStr(strs[i]);
                int pathLen=getPathLen(strs[i]);
                if (map.containsKey(pathStr)){
                    int time=map.get(pathStr)+1;
                    map.put(pathStr,time);
                    for (int j=0;j<pathLen;j++){
                        if (j==0||j==pathLen-1){
                            sb.append(1);
                        }else {
                            sb.append(time);
                        }
                    }
                }else {
                    map.put(pathStr, 1);
                    for (int j=0;j<pathLen;j++){
                        sb.append(1);
                    }
                }
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());

        }
    }

    private static String getPathStr(String str){
        String[] strs=str.split("/");
        StringBuilder sb=new StringBuilder();
        for (String s:strs)
            sb.append(s);
        return sb.toString();
    }
    private static int getPathLen(String str){
        String[] strs=str.split("/");
        if (strs[strs.length-1].equals(""))
            return strs.length-2;
        return strs.length-1;
    }
}