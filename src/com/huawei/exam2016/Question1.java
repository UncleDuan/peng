package com.huawei.exam2016;

import java.util.Scanner;

/**
 * Created by ionolab-DP on 2018/12/28.
 */
public class Question1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int num=sc.nextInt();
            if (num>999){
                num=999;
            }
            int count=0;
            int index=0;
            int tempcount=0;
            int[] array=new int[num];
            for (int item:array){
                item=0;
            }
            while (count<num-1)
            {
                if (array[index]!=1){
                    tempcount++;
                    if (tempcount==3){
                        array[index]=1;
                        count++;
                        tempcount=0;
                    }
                }
                index++;
                if (index==num){
                    index=0;
                }
            }

            for (int i=0;i<num;i++){
                if (array[i]!=1){
                    System.out.println(i);
                }
            }


        }
    }
}
