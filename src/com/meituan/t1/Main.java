package com.meituan.t1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n=in.nextInt();
            int m=in.nextInt();
            int[][] arr=new int[n][m];
            for (int i=0;i<n;i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = in.nextInt();
                }
            }
            Map<Integer,Integer> map1=new HashMap<>();
            Map<Integer,Integer> map2=new HashMap<>();
            for (int i=0;i<n;i++) {
                for (int j = 0; j < m; j++) {
                    if ((i+j)%2==0){
                        if (map1.containsKey(arr[i][j]))
                            map1.put(arr[i][j],map1.get(arr[i][j])+1);
                        else
                            map1.put(arr[i][j],1);
                    }
                    else {
                        if (map2.containsKey(arr[i][j]))
                            map2.put(arr[i][j],map2.get(arr[i][j])+1);
                        else
                            map2.put(arr[i][j],1);
                    }
                }
            }
            int[][] t1=maxAndSecTimesNum(map1);
            int[][] t2=maxAndSecTimesNum(map2);
            int times=0;
            if (t1[0][0]!=t2[0][0]){
                times=n*m-t1[0][1]-t2[0][1];
            }
            else {
                int method1=t1[0][1]+t2[1][1];
                int method2=t1[1][1]+t2[0][1];
                times=n*m-Math.max(method1,method2);
            }
            System.out.println(times);
        }
    }

    /**
     *
     * @param map hashmap记录各个数字出现的次数
     * @return arr[0][0]最大次数的数，arr[0][1]最大次数；arr[1][0]第二大次数的数，arr[1][1]第二大次数
     */
    public static int[][] maxAndSecTimesNum(Map<Integer,Integer> map){
        int[][] a=new int[2][2];
        for (Integer key:map.keySet()){
            if (map.get(key)>a[0][1]){
                a[1][0]=a[0][0];
                a[1][1]=a[0][1];
                a[0][1]=map.get(key);
                a[0][0]=key;
            }
            else if (map.get(key)>a[1][1]){
                a[1][1]=map.get(key);
                a[1][0]=key;
            }
        }
        return a;

    }
}
