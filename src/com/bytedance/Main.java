package com.bytedance;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main1(String args[]){
        Scanner in=new Scanner(System.in);
        while (in.hasNext()) {
            int n=in.nextInt();
            int left = 1024 - n;
            int count = 0;
            count += left / 64;
            left = left % 64;
            count += left / 16;
            left = left % 16;
            count += left / 4;
            left = left % 4;
            count += left;
            System.out.println(count);
        }
    }

    public static void main2(String[] args) {

        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            String nothing=scanner.nextLine();
            String[] strings=new String[n];
            for (int i=0;i<n;i++){
                strings[i]=scanner.next();
            }
            for (int i=0;i<n;i++){
                System.out.println(fix(strings[i]));
            }
        }
    }

    private static String fix(String s){
        //需要遍历字符串，判断对应情况
        StringBuilder sb=new StringBuilder(s);
        boolean[] flag=new boolean[sb.length()];
        for (int i=0;i<sb.length();i++){
            if (i<sb.length()-1&&sb.charAt(i)==sb.charAt(i+1)){
                if (i<sb.length()-2&&sb.charAt(i+1)==sb.charAt((i+2))){
                    sb.deleteCharAt(i+1);
                    i--;
                }
                else {
                    if (i<sb.length()-3&&sb.charAt(i+2)==sb.charAt(i+3)) {
                        sb.deleteCharAt(i + 3);
                        i--;
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {


    }
    private static int many(int[] array){
        int minIndex=0;
        for (int i=1;i<array.length;i++){
            if (array[i]<array[minIndex])
                minIndex=i;
        }
        int[] prize=new int[array.length];
        prize[minIndex]=1;
        for (int i=0;i<array.length;i++){
            int lastIndex=(minIndex+i)%array.length;
            int index=(minIndex+1+i)%array.length;
            int nextIndex=(minIndex+2+i)%array.length;
            if(array[index]<array[lastIndex]&&array[index]<array[nextIndex])
                prize[index]=1;
            else if (array[index]>array[lastIndex]&&array[index]<=array[nextIndex])
                prize[index]=prize[lastIndex]+1;
            else if (array[index]<=array[lastIndex]&&array[index]>array[nextIndex])
                prize[index]=prize[nextIndex]+1;
            else
                prize[index]=Math.max(prize[lastIndex],prize[nextIndex]);
        }
        int sum=0;
        for (int i=0;i<array.length;i++){sum+=array[i];}
        return sum;
    }

}
