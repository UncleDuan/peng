package datastructure.sort;

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
            for (j=array.length-1;j>i;j--){
                if (array[j-1]>array[j])
                swap(array,j,j-1);
            }
        }
    }

    //改进的冒泡排序：
    //当没有任何数据交换时，表明数据已经有序，无须后续的判断
    public static void bubbleSort2(int[] array){
        int i,j;
        boolean hasSwaped=true;
        for (i=0;i<array.length&&hasSwaped;i++){
            hasSwaped=false;
            for (j=array.length-1;j>i;j--){
                if (array[j-1]>array[j]) {
                    swap(array, j, j - 1);
                    hasSwaped=true;
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


    //直接插入排序
    //分成了两部分，前一部分有序，后一部分无序，从无序插入到无序表。
    public static void insertSort(int[] array){
        int i,j,insertElement;
        //前i个元素为有序的
        for (i=1;i<array.length;i++){
            if (array[i]<array[i-1]){
                insertElement=array[i];

                //从有序数组的最后一个元素开始，把大于insertElement的元素往后挪一个位置，将insertElement插入
                for (j=i-1;j>=0&&array[j]>insertElement;j--){
                    array[j+1]=array[j];
                }
                array[j+1]=insertElement;
            }
        }

    }

    //
    //

    /**
     * 希尔排序：
     * 1.将整个序列分割成若干个子序列，然后在这些子序列内分别进行直接插入排序；
     * 2.当整个序列基本有序时，对全体记录进行一次直接插入排序。
     * @param array 待排序的数组
     */
    public static void  shellSort(int[] array){
        int increment=array.length;
        int insertElement;
        while (increment>1){
            increment=increment/3+1;
            for (int i=increment;i<array.length;i++){
                if (array[i]<array[i-increment]){
                    insertElement=array[i];
                    int j;
                    for (j=i-increment;j>=0&&insertElement<array[j];j-=increment){
                        array[j+increment]=array[j];
                    }
                    array[j+increment]=insertElement;
                }
            }
        }

    }


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

    /**
     * 堆排序：
     * 1.构建一个大顶堆；
     * 2.逐步将每个最大值的根结点与末尾元素交换，并再调整其成为大顶堆。
     * @param array
     */
    public static void heapSort(int[] array){
        int i;
        for (i=array.length/2-1;i>=0;i--){
            heapAdjust(array,i,array.length);
        }
        for (i=array.length-1;i>0;i--){
            swap(array,0,i);
            heapAdjust(array,0,i-1);
        }
    }
    private static void heapAdjust(int[] array, int nodeToAdjust,int maxIndex){
        int temp=array[nodeToAdjust];
//        对于初始化一个大顶堆，
//        注意到在heapSort中从length/2-1这个结点开始往根结点实现大顶堆，
//        length/2-1是一个叶子结点的父节点，对于这样的结点，次函数很明显会满足实现；
//        在逐步往根结点推进，直到整个数组满足一个大顶堆。
//        对于交换结点后重新调整为大顶堆：
//        注意，不同于重新构建一个大顶堆，因为除了nodeToAdjust，其他结点都是满足大顶堆要求的。
//        看孩子结点有没有比它大的，如果没有，退出循环；如果有，把孩子结点的值赋给该结点，并且孩子结点称为新的需要调整的结点。
        for (int i=2*nodeToAdjust+1;i<maxIndex;i=2*i+1){
            if (i<maxIndex&&array[i]<array[i+1]){
                i++;
            }
            if (temp>=array[i]){
                break;
            }
            array[nodeToAdjust]=array[i];
            nodeToAdjust=i;
        }
        array[nodeToAdjust]=temp;

    }




    public static void main(String[] args) {
//        int[] array={2,1,3,4,5,6,7,8,9};
//        bubbleSort0(array);
//        shellSort(array);
//        heapSort(array);
//        System.out.println(Arrays.toString(array));
//        bubbleSort2(array);
//        selectSort(array);
//        insertSort(array);
//        quickSort(array);
//        System.out.println(Arrays.toString(array));
        System.out.println(System.getProperty("java.class.path"));
    }
}

