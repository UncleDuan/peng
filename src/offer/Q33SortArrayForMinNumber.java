package offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by pengsel on 2019/2/19.
 */
public class Q33SortArrayForMinNumber {
    /**
     * 自定义一个Comparator比较器，使用Arrays.sort的排序功能，
     * 由于可能出现拼接后溢出，必须转化String来比较。
     * @param array 输入数组
     * @return
     */
    public static String sortArrayForMinNumber(int[] array){
        if (array==null||array.length==0)
            return null;
        String[] strs=new String[array.length];
        for (int i=0;i<array.length;i++){
            strs[i]=""+array[i];
        }
        //这里使用了匿名内部类。
        //Comparable和Comparator都可以比较自己定义的类的大小，但稍有区别:
        //1.Comparable定义在类的内部；Comparator是另外定义一个比较器，不需要待比较的类的结构发生变化；
        //2.Comparable要实现compareTo(Object o)方法；Comparator要实现compare(Object o1,Object o2)方法。
        Arrays.sort(strs,new Comparator<String>(){
            public int compare(String s1,String s2) {
                String str1=s1+s2;
                String str2=s2+s1;
                return str1.compareTo(str2);
            }
        });
        StringBuffer sb=new StringBuffer();
        for (String s:strs)
            sb.append(s);
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] array={3,32,321};
        System.out.println(sortArrayForMinNumber(array));
    }
}
