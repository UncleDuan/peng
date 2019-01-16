package company.huawei.exam2016;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by ionolab-DP on 2018/12/29.
 */
public class Question2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            StringBuffer stringBuffer=new StringBuffer();
            Set<Character> set=new HashSet<Character>();
            for (int i=0;i<str.length();i++) {
                char ch = str.charAt(i);
                if (!set.contains(ch)) {
                    set.add(ch);
                    stringBuffer.append(ch);
                }
            }
            System.out.println(stringBuffer.toString());
        }
    }
}
