package datastructure;

import java.util.Arrays;

/**
 * Created by ionolab-DP on 2019/1/4.
 * 排序：从小到大
 */
public class Sort {

    public static final int MAX_LENGTH_INSER_SORT=7;

    private static void swap(int[] array,int i,int j){
        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }
//冒泡排序的时间复杂度为n的平方。

    //不是标准的冒泡排序算法
    //交换排序，最小的直接交换到最前面一个
    public static void bubbleSort0(int[] array){
        int i,j;
        for (i=0;i<array.length;i++){
            for (j=i+1;j<array.length;j++){
                if (array[i]>array[j]){
                    swap(array,i,j);
                }
            }
        }
    }

    //标准的冒泡排序算法
    public static void bubbleSort1(int[] array){
        int i,j;
        for (i=0;i<array.length;i++){
            for (j=array.length-1;j>0;j--){
                if (array[j-1]>array[j])
                swap(array,j,j-1);
            }
        }
    }

    //改进的冒泡排序：
    //当没有任何数据交换时，表明数据已经有序，无须后续的判断
    public static void bubbleSort2(int[] array){
        int i,j;
        boolean disordered=true;
        for (i=0;i<array.length&&disordered;i++){
            disordered=false;
            for (j=array.length-1;j>0;j--){
                if (array[j-1]>array[j]) {
                    swap(array, j, j - 1);
                    disordered=true;
                }
            }
        }
    }

    //简单选择排序
    //通过n-i次关键字间的比较，从n-1+1个记录中选出关键字最小的记录
    public static  void selectSort(int[] array){

        int i,j,min;
        for (i=0;i<array.length;i++){
            //找到最小的下标，如果不是i，则和i交换
            min=i;
            for (j=i+1;j<array.length;j++){
                if (array[min]>array[j]){
                    min=j;
                }
            }
            if (i!=min){
                swap(array,i,min);
            }
        }
    }


    //直接插入排序,时间复杂度为O(n平方)
    //分成了两部分，前一部分有序，后一部分无序，从无序插入到无序表。
    public static void insertSort(int[] array){
        int i,j,tmp;
        //前i个元素为有序的
        for (i=1;i<array.length;i++){
            if (array[i]<array[i-1]){
                tmp=array[i];
                for (j=i-1;j>=0&&array[j]>tmp;j--){
                    array[j+1]=array[j];
                }
                array[j+1]=tmp;
            }
        }

    }

    //
    //

    /**
     * 快速排序，时间复杂度O(nlogn),空间复杂度O(logn)
     * 快速排序是一种不稳定的排序方法。
     * 优化：
     * 1.三数取中，优化选取枢轴
     * @param array
     */
    public static void quickSort(int[] array){
        qSort(array,0,array.length-1);
    }
    private static void qSort(int[] array,int low,int high){
        //枢轴值
        int pivot;
        //3.小数组时采用插入排序
//        if (low<high){
//            pivot=partition(array,low,high);
//            qSort(array,low,pivot-1);
//            qSort(array,pivot+1,high);
//        }
        if (high-low>MAX_LENGTH_INSER_SORT){
            pivot=partition(array,low,high);
            qSort(array,low,pivot-1);
            qSort(array,pivot+1,high);
        }else
            insertSort(array);
    }
    private static void qSort1(int[] array,int low,int high){
        //枢轴值
        int pivot;
        if (high-low>MAX_LENGTH_INSER_SORT){
            //4.递归转换成迭代，缩减堆栈深度
            while (low<high) {
                pivot = partition(array, low, high);
                qSort1(array, low, pivot - 1);
                low=pivot+1;
            }
        }else
            insertSort(array);
    }
    private static int partition(int[] array,int low,int high) {
        //选取的枢轴，是性能瓶颈

        //1.三数取中：将三个关键字排序，将中间数作为枢轴
        int middle=low+(high-low)/2;
        if (array[low]>array[high])
            swap(array,low,high);
        if (array[middle]>array[high])
            swap(array,high,middle);
        if (array[middle]>array[low])
            swap(array,middle,low);
        int pre=array[low];

        //2.优化不必要的交换
        while (low < high){
            //比枢轴记录小的交换到低端
            while (low < high && array[high] >= pre)
                high--;
//            swap(array, low, high);
            array[low]=array[high];
            //比枢轴记录大的交换到高端
             while (low < high && array[low] <= pre)
                low++;
//            swap(array, low, high);
            array[high]=array[low];
        }
        array[low]=pre;
        return low;
    }

    public static void heapSort(int[] array){
        int i;
        for (i=array.length/2;i>0;i--){
            heapAdjust(array,i,array.length);
        }
    }
    private static void heapAdjust(int[] array, int s,int m){}

    public static void main(String[] args) {
        int[] array={9,8,1,3,5,6,4,2,7};
//        bubbleSort0(array);
//        bubbleSort1(array);
        System.out.println(Arrays.toString(array));
//        bubbleSort2(array);
//        selectSort(array);
//        insertSort(array);
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}

