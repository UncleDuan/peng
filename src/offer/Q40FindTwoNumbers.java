package offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by pengsel on 2019/3/14.
 */
public class Q40FindTwoNumbers {
    public static void findTwoNumbers(int[] array){
        if (array==null||array.length<2){
            return;
        }
        int[] result=new int[2];
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        for (int i=0;i<array.length;i++) {
            if (map.containsKey(array[i]))
                map.remove(array[i]);
            else
                map.put(array[i], 1);
        }
        System.out.println(map.toString());
    }

    public static void main(String[] args) {
        int[] array={1,1,2,2,3,4,5,5};
        findTwoNumbers(array);
    }
}
