package offer;

import java.util.Scanner;

/**
 * Created by pengsel on 2019/3/14.
 */
public class Q42ReverseSentence {
    public static void reverseSentence(String s){
        String[] strs=s.split(" ");
        for (int i=strs.length-1;i>=0;i--){
            System.out.print(strs[i]+" ");
        }
    }

    public static void shiftString(String s,int n){
        ;
    }

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while (in.hasNext()){
            String s=in.nextLine();
            reverseSentence(s);
        }
    }
}
