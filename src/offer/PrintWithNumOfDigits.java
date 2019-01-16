package offer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ionolab-DP on 2019/1/14.
 */
public class PrintWithNumOfDigits {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            print2(n);
        }
    }

    /**
     * 方法一：在字符串上模拟数字加法的解法
     * @param n 几位数
     * @return
     */
    public static void print1(int n){
        if (n<0)
            return;

        char[] digits=new char[n];
        for (int i=0;i<digits.length;i++){
            digits[i]='0';
        }
        while (!increment(digits)){
            printDigits(digits);
        }
        return;
    }

    /**
     * 更新字符数组，并判断是否终止
     * @param digits 字符数组
     * @return
     */
    public static boolean increment(char[] digits){
        boolean isOverFlow=false;
        int nTakeOver=0;
        for (int i=digits.length-1;i>=0;i--){
            int nSum=digits[i]-'0'+nTakeOver;
            if (i==digits.length-1)
                nSum++;
//          进位发生了
            if (nSum>=10){
//              第一位进位了
                if (i==0){
                    isOverFlow=true;
                }
                nTakeOver=1;
                digits[i]='0';
            }
//            不进位时直接退出循环了，所以不需要将nTakeOver置0
            else {
                digits[i]=(char)(digits[i]+1);
                break;
            }
        }
        return isOverFlow;
    }

    /**
     * 打印字符数组，并去除前面的无意义的0
     * @param digits 字符数组
     */
    public static void printDigits(char[] digits){
        boolean start=false;
        for (int i=0;i<=digits.length-1;i++){
            if(!(digits[i]=='0'&&!start)){
                start=true;
            }
            if (start){
                System.out.print(digits[i]);
            }

        }
            System.out.print("\n");
    }

    /**
     * 方法二：全排列方法
     * @param n 几位数
     */
    public static void print2(int n){
        if (n<=0)
            return;
        char[] digits=new char[n];
        for (int i=0;i<10;i++){
            digits[0]=(char)(i+'0');
            recursiveprint(digits,0);
        }

    }

    /**
     * 递归的打印字符数组
     * @param digits 字符数组
     * @param index 发生变化位置的索引
     */
    public static void recursiveprint(char[] digits,int index){
        if (index==digits.length-1){
            printDigits(digits);
            return;
        }
        for (int i=0;i<10;i++){
            digits[index+1]=(char)(i+'0');
            recursiveprint(digits,index+1);
        }
    }
}
