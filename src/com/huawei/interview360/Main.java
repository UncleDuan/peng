package com.huawei.interview360;

import java.util.*;
import java.util.List;

public class Main {
    static class Point{
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static List<Point> findAllStars(String[] lines){
        if (lines==null||lines.length==0)
            return null;
        List<Point> result=new ArrayList<Point>();
        for (int i=1;i<lines[0].length()-2;i++){
            for (int j=1;j<lines.length-2;j++){
                if (lines[j].charAt(i)=='1'&&lines[j+1].charAt(i)=='1'&&lines[j-1].charAt(i)=='1'&&lines[j].charAt(i+1)=='1'&&lines[j].charAt(i-1)=='1'){
                    Point p=new Point(i,j);
                    result.add(p);
                }
            }
        }
        return result;
    }
    private static int getNum(List<Point> stars,int m,int n){
        if (stars==null||stars.size()==0)
            return 0;
        int result=0;
        int x=0,y=0,dx=3,dy=3;
        //todo 找到多少个数
//        for (int ix=0;x<n-dx;ix++){
//            for (int iy=0;y<m-dy;iy++){
//                for (int idx=3;dx<);
//            }
//        }

        return result;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while (in.hasNext()){
            int m=in.nextInt();
            int n=in.nextInt();
            int k=in.nextInt();
            String[] lines=new String[m];
            for (int i=0;i<m;i++){
                lines[i]=in.nextLine();
            }
            List<Point> points=findAllStars(lines);
            System.out.println(getNum(points,m,n));

        }
    }
}

















//            int N=in.nextInt();
//            int M=in.nextInt();
//            int[] naugty=new int[N];
//            for (int i=0;i<N;i++){
//                naugty[i]=in.nextInt();
//            }
//            Arrays.sort(naugty);
//            int[] a=new int[N-M];
//            int max=0;
//            for (int i=0;i<N-M;i++){
//                int t=naugty[i]+naugty[2*(N-M)-1-i];
//                if(t>max)
//                    max=t;
//            }
//            System.out.println(max);