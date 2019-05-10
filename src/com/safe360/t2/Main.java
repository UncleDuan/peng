package com.safe360.t2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while (in.hasNext()){
            int len=in.nextInt();
            int[] arr=new int[len];
            for (int i=0;i<arr.length;i++){
                arr[i]=in.nextInt();
            }
            Map<Integer,Integer> map=new HashMap<>();
            for (int i=0;i<arr.length;i++){
                if (map.containsKey(arr[i])){
                    map.put(arr[i],map.get(arr[i])+1);
                }
                else {
                    map.put(arr[i],1);
                }
            }
            int num=0;
            for (int i=len;i>=2;i--){
                if (len%i==0){
                    for (Integer key:map.keySet()){
                        if (map.get(key)%i==0){
                            num=num+map.get(key)/i;
                        }
                        else {
                            num=0;
                            break;
                        }
                    }
                }
            }
            System.out.println(num);
        }
    }
}
