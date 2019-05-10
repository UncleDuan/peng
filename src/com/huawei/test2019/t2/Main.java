package com.huawei.test2019.t2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str=scanner.nextLine();
            replace(str);
        }
    }

    public static String replace(String string){
        StringBuilder sb=new StringBuilder(string);
        for (int i=0;i<string.length();i++){
            if (string.charAt(i)=='{'){
                int count=0;
                for (int j=i+1;j<string.length();j++){
                    if (string.charAt(j)=='{')
                        count++;
                    if (string.charAt(j)=='}'){
                        if (count==0){
                            sb.append(string.substring(0,i));
                            sb.append(replace(string.substring(i+1,j)));
                            sb.append(string.substring(j,string.length()-1));
                            return sb.toString();
                        }
                    }

                }
            }
        }
        return null;


    }
}
