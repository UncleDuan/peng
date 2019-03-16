package offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by pengsel on 2019/2/28.
 */
public class Q35FirstNotRepeatingChar {
    public static Character firstNotRepeatingChar(String string){
        if (string==null||string.equals(""))
            return null;
        HashMap<Character,Integer> hashMap=new HashMap<Character, Integer>();
        char temp;
        for (int i=0;i<string.length();i++){
            temp=string.charAt(i);
            if (hashMap.containsKey(temp))
                hashMap.put(temp,hashMap.get(temp)+1);
            else
                hashMap.put(temp,1);
        }
        System.out.println(hashMap.toString());
        char result='?';
        Iterator iter=hashMap.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry entry=(Map.Entry) iter.next();
            if (((Integer)entry.getValue()).equals(new Integer("1")))
                result=(Character) entry.getKey();
        }
        return result;
    }

    public static Character firstNotRepeatingChar2(String string){
        if (string==null||string.equals(""))
            return null;
        char[] hashTable=new char[256];
        for (int i=0;i<string.length();i++){
            hashTable[string.charAt(i)]++;
        }
        for (int i=0;i<string.length();i++){
            if (hashTable[string.charAt(i)]==1)
                return string.charAt(i);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(firstNotRepeatingChar2("abcdeefabcfd564454"));
    }
}
