package jvm.chapter2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ionolab-DP on 2019/1/2.
 *
 * 统计出现的各个字符的个数
 */
public class CountChar {
    public static void main(String[] args) {
        String str="China中国1949,China我的国1949";
        Map<Character,Integer> chars=new HashMap<Character, Integer>();
        for (int i=0;i<str.length();i++){
            char temp=str.charAt(i);
            if (chars.containsKey(temp)){
                chars.put(temp,chars.get(temp)+1);
            }else {
                chars.put(temp,1);
            }
        }
        System.out.println(chars);
    }
}
