package com.pdd;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;
public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {
//            int length = in.nextInt();
//            int[] arr=new int[length];
//            for (int i=0;i<length;i++){
//                arr[i]=in.nextInt();
//            }
//            Arrays.sort(arr);
//            int[] sum=new int[length/2];
//            for (int i=0;i<length/2;i++){
//                sum[i]=arr[i]+arr[length-i-1];
//            }
//            Arrays.sort(sum);
//            System.out.println(sum[length/2-1]-sum[0]);
//
//        }
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int[] counts=new int[10];
            for (int i=0;i<10;i++){
                counts[i]=in.nextInt();
            }
            int lenA=in.nextInt();
            int lenB=in.nextInt();
            int A=0,B=0;
            if (counts[0]>=Math.min(lenA,lenB)){
                System.out.println(0);
                continue;
            }
            for (int i=0;i<10;i++){
                while (counts[i]>0){
                    counts[i]--;
                    if (lenA>0){
                        A=A*10+i;
                        lenA--;
                    }else {
                        B=B*10+i;
                        lenB--;
                    }
                }
            }
            System.out.println(A*B);


        }
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            String str=in.nextLine();
//            str=str.substring(1,str.length()-1);
//            int d=in.nextInt();
//            String[] colors=str.split(",");
//            int[] co=new int[colors.length];
//            for(int i=0;i<co.length;i++)
//                co[i]=Integer.valueOf(colors[i].trim());
//            int accept=0;
//            for (int i=0;i<co.length;i++){
//                for (int j=i+1;j<co.length;j++){
//                    if(Math.abs(co[i]-co[j])<=d)
//                        accept++;
//                }
//            }
//            double l=(double)co.length;
//            double re=(double) accept/(l*(l-1)/2);
//            System.out.println(String.format("%.6f",re));
//        }
//    }

//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            String str1 = in.next();
//            String str2 = in.next();
//            int l1=str1.length();
//            int l2=str2.length();
//            if(l1==0&&l2==0){
//                System.out.println(0);
//                continue;
//            }
//            int[][] dist=new int[l1+1][l2+1];
//            for (int i=0;i<=l1;i++){
//                dist[i][0]=i;
//            }
//            for (int i=0;i<=l2;i++){
//                dist[0][i]=i;
//            }
//            for (int i=1;i<=l1;i++){
//                for (int j=1;j<=l2;j++){
//                    int left=dist[i-1][j]+1;
//                    int down=dist[i][j-1]+1;
//                    int left_down=dist[i-1][j-1];
//                    if (str1.charAt(i-1)!=str2.charAt(j-1))
//                        left_down+=1;
//                    dist[i][j]=Math.min(left,Math.min(down,left_down));
//                }
//            }
//            System.out.println(dist[l1][l2]);
//        }
//    }


}