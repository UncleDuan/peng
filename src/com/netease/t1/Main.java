package com.netease.t1;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int testPoints = in.nextInt();
            int[] numOfMethods=new int[testPoints];
            for (int i=0;i<testPoints;i++){
                int numOfCards=in.nextInt();
                String nothing=in.nextLine();
                String str=in.nextLine();
                String[] cards=str.split(" ");
                numOfMethods[i]=getNumOfMethods(cards);
            }
            for (int i=0;i<testPoints;i++){
                System.out.println(numOfMethods[i]);
            }

        }
    }

    private static final int ELEMENT_LENGTH=13;
    private static final int MIN_LENGTH=5;
    public static int getNumOfMethods(String[] array){
        int result=0;
        int[] map=new int[ELEMENT_LENGTH];
        for(String c:array){
            switch (c){
                case "A":
                    map[0]++;
                    break;
                case "2":
                    map[1]++;
                    break;
                case "3":
                    map[2]++;
                    break;
                case "4":
                    map[3]++;
                    break;
                case "5":
                    map[4]++;
                    break;
                case "6":
                    map[5]++;
                    break;
                case "7":
                    map[6]++;
                    break;
                case "8":
                    map[7]++;
                    break;
                case "9":
                    map[8]++;
                    break;
                case "10":
                    map[9]++;
                    break;
                case "J":
                    map[10]++;
                    break;
                case "Q":
                    map[11]++;
                    break;
                case "K":
                    map[12]++;
                    break;

            }
        }
        for (int i=0;i<ELEMENT_LENGTH;i++){
            int len=maxLength(map,i);
            for (int j=len;j>=MIN_LENGTH;j--){
                int t=1;
                for (int k=i;k<i+j;k++){
                    t=map[k]*t;
                }
                result+=t;
            }
        }
        return result;
    }

    private static int maxLength(int[] map,int from){
        int len=0;
        for (int i=from;i<ELEMENT_LENGTH;i++){
            if (map[i]>0)
                len++;
            else
                break;
        }
        return len;
    }
}
