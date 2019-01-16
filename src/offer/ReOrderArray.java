package offer;

import java.util.Arrays;

/**
 * Created by ionolab-DP on 2019/1/15.
 */
public class ReOrderArray {
    /**
     * 两次遍历数组以确定输出数组，然后在赋值回原数组。
     * @param array 输入数组
     */
    public static void reOrder1(int[] array){
        if (array==null)
            return;
        int[] result=new int[array.length];
        int count=0;
        for (int i=0;i<array.length;i++){
            if ((array[i]&1)!=0) {
                result[count] = array[i];
                count++;
            }
        }
        for (int i=0;i<array.length;i++){
            if ((array[i]&1)==0) {
                result[count] = array[i];
                count++;
            }
        }
//        java传递的是副本
//        Java参数，不管是原始类型还是引用类型，传递的都是副本
//        array=result;
        /**
         * 当一个对象实例作为一个参数被传递到方法中时，
         * 参数的值就是该对象的引用一个副本。
         * 指向同一个对象,对象的内容可以在被调用的方法中改变，
         * 但对象的引用(不是引用的副本)是永远不会改变的。
         */
        for (int i=0;i<array.length;i++){
            array[i]=result[i];
        }
    }

    /**
     * 考虑可扩展性的解法，将判断封装成一个函数，
     * 当需要更换判断条件时，增加相应的函数。
     * @param array
     */
    public static void reOrder2(int[] array){
        if (array==null)
            return;
        int[] result=new int[array.length];
        int count=0;
        for (int i=0;i<array.length;i++){
            if (isOdd(array[i])) {
                result[count] = array[i];
                count++;
            }
        }
        for (int i=0;i<array.length;i++){
            if (!isOdd(array[i])) {
                result[count] = array[i];
                count++;
            }
        }
        for (int i=0;i<array.length;i++){
            array[i]=result[i];
        }
    }

    public static boolean isOdd(int n){
        if ((n&1)!=1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] array ={1, 2 , 3,4,5};
        reOrder1(array);
        System.out.println(Arrays.toString(array));
    }
}
