package offer;

import java.util.Arrays;

public class Q29MoreThanHalfNum {
    /**
     * 方法一：
     * 快速排序，返回中位数；
     * @param array
     * @return
     */
    public static int moreThanHalfNum1(int[] array){
        if (checkInvalidArray(array))
            return Integer.MAX_VALUE;
        quickSort(array,0,array.length-1);
        int result=array[(array.length-1)/2];
        if (checkMoreThanHalf(array,result))
            return result;
        return Integer.MAX_VALUE;
    }

    public static void quickSort(int[] array,int start,int end){
        int pivot;
        if (start<end){
            pivot=partition(array,start,end);
            if (pivot>start)
            quickSort(array,start,pivot-1);
            if (pivot<end)
            quickSort(array,pivot+1,end);
        }
    }
    private static int partition(int[] array,int start,int end){
        int pre=array[start];
        while (start<end) {
            while (start<end&&array[end]>=pre)
                end--;
            array[start]=array[end];
            while (start<end&&array[start]<=pre)
                start++;
            array[end]=array[start];
        }
        array[start]=pre;
        return start;
    }

    /**
     * 方法二：
     * 遍历数组时保存两个值，一个是数组中的数字，一个是次数；
     * 遍历到下一个数字时，如果下一个数字和之前保存的数字相同，times+1，不同则减一；
     * 当times为0时，改变result为下一数字，最终保存在result中的数字必然为需要的数字。
     * @param array
     * @return
     */
    public static int moreThanHalfNum2(int[] array){
        if (checkInvalidArray(array))
            return Integer.MAX_VALUE;
        int result=array[0];
        int times=1;
        for (int i=1;i<array.length;i++){
            if (times==0) {
                result = array[i];
                times=1;
            }else if (array[i]==result)
                times++;
            else
                times--;
        }
        if (checkMoreThanHalf(array,result))
            return result;
        return Integer.MAX_VALUE;
    }

    public static boolean checkInvalidArray(int[] array){
        if (array==null||array.length==0)
            return true;
        return false;
    }
    public static boolean checkMoreThanHalf(int[] array,int result){
        int times=0;
        for (int i=0;i<array.length;i++){
            if (array[i]==result)
                times++;
        }
        if (array.length>(times<<1))
            return false;
        return true;
    }

    public static void main(String[] args) {
//        int[] array={3,2,4,6,7,8,9,10,1,5};
//        quickSort(array,0,array.length-1);
//        System.out.println(Arrays.toString(array));
        int[] array={1,2,3,2,2,2,5,4,2};
        System.out.println(moreThanHalfNum1(array));
    }
}
