package com.safe360.t1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int string2int(String str) {
        int result=0;
        boolean isPositive=true;
        if(str==null||str.length()==0)
            result=0;
        else {
            for (int i=0;i<str.length();i++){
                if (i==0){
                    if (str.charAt(i)-'0'>=0&&str.charAt(i)-'0'<=9){
                        isPositive=true;
                        result=str.charAt(i)-'0';
                    }
                    else if (str.charAt(i)=='-'){
                        isPositive=false;
                    }
                    else if (str.charAt(i)=='+'){
                        isPositive=true;
                    }
                    else {
                        break;
                    }

                }
                else {
                    if (str.charAt(i) - '0' >= 0 && str.charAt(i) - '0' <= 9) {
                        result = result * 10 + str.charAt(i) - '0';
                    } else {
                        if (str.charAt(i) != '.'){
                            result=0;
                        }
                        else {
                            for (int j=i+1;j<str.length();j++){
                                if (str.charAt(i) - '0' < 0 && str.charAt(i) - '0' > 9){
                                    result=0;
                                    break;
                                }
                            }

                        }
                        break;

                    }
                }
            }
        }
        if (!isPositive){
            result=0-result;
        }
        return result;


    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String _str;
        try {
            _str = in.nextLine();
        } catch (Exception e) {
            _str = null;
        }

        res = string2int(_str);
        System.out.println(String.valueOf(res));

    }
}