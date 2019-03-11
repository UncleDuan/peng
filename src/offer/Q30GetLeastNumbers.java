package offer;

import datastructure.search.BiTreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class Q30GetLeastNumbers {
    /**
     * 采用类似于快速排序的思路，最终使得比array[k-1]小的数字在它的左边，而比array[k-1]大的数字在它的右边，最终返回k-1以前的元素。
     * @param array
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] array,int k){

        if (array==null||array.length==0||k<=0||k>array.length)
            return null;
        int[] result=new int[k];
        int pivot=0;
        int start=0;
        int end=array.length-1;
        //当pivot=k-1时，0~k-1即为要找的k个数
        while (pivot!=k-1){
            //pivot>k-1，要找的数在0~pivot-1范围内
            if (pivot>k-1) {
                end = pivot - 1;
                pivot=partition(array,start,end);
            }
            //pivot<k-1，增大查找范围；
            else {

                start=pivot+1;
                pivot=partition(array,start,end);
            }
        }
        for (int i=0;i<k;i++){
            result[i]=array[i];
        }
        return result;
    }


    private static int partition(int[] array,int start,int end){
        int pre=array[start];
        while (start<end){
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
     * 通过插入排序维持一个长度为k的arraList。
     * @param input 输入数组
     * @param k 最小的k个数
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        if (input==null||input.length==0||k<1||k>input.length)
            return arrayList;

        for(int i=0;i<input.length;i++){
            if(i<k){
                insertOrderedly(arrayList,input[i]);
            }
            else{
                if (input[i]<arrayList.get(arrayList.size()-1)){
                    insertOrderedly(arrayList,input[i]);
                    arrayList.remove(arrayList.size()-1);
                }
            }

        }
        return arrayList;
    }

    /**
     * 插入排序
     * @param arrayList
     * @param element
     */
    private void insertOrderedly(ArrayList<Integer> arrayList,int element){
        if(arrayList.isEmpty())
            arrayList.add(element);
        else{
            boolean added=false;
            for(int i=0;i<arrayList.size();i++){
                if(element<arrayList.get(i)){
                    arrayList.add(i,element);
                    added=true;
                    break;
                }
            }
            if(!added)
                arrayList.add(element);
        }
    }

    /**
     * 通过构建一个大顶堆存储最小的k个数。
     */
    public static ArrayList<Integer> GetLeastNumbers2(int[] input,int k){
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        if (input==null||input.length==0||k<1||k>input.length)
            return arrayList;
        int[] heap=new int[k];
        //heap初始化，存储前k个数；
        for (int i=0;i<k;i++){
            heap[i]=input[i];
        }
        //调整heap为一个大顶堆
        for (int i=k/2-1;i>=0;i--)
            heapAdjust(heap,i);
        for (int i=k;i<input.length;i++){
            //如果元素较小，则赋值给heap[0]，重新调整为大顶堆
            if (input[i]<heap[0]){
                heap[0]=input[i];
                heapAdjust(heap,0);
            }
        }
        //将heap元素搬移到arrayList中
        for (int i=0;i<k;i++){
            arrayList.add(heap[i]);
        }
        return arrayList;

    }

    /**
     * 调整某个结点使得符合大顶堆的要求：
     * 1. 保存该结点的值为temp；
     * 2. 对于一个父结点i，它的左子结点为2*i+1，右子结点为2*i+2，找到它的子结点中较大的值，
     * 3. 如果该值小于temp，则满足要求，退出；
     * 4. 如果该值大于temp，将该子结点值与父结点交换(在此处为赋值，用temp存储原始结点以避免不必要的交换)，
     * 并且由于改变了子结点，该子结点成为新的需要调整的结点；
     * 5. 循环直到结点索引超过范围；
     * 6. 将temp赋值给最后一个改变的结点(如果是直接交换，就不用这个步骤)；
     * @param array 数组
     * @param nodeToAdjust 该结点的索引
     */
    private static void heapAdjust(int[] array,int nodeToAdjust){
        int temp=array[nodeToAdjust];
//        for (int i=2*nodeToAdjust+1;i<array.length;i=2*i+1){
//            if (i<(array.length-1)&&array[i]<array[i+1])
//                i++;
//            if (temp>array[i])
//                break;
//            array[nodeToAdjust]=array[i];
//            nodeToAdjust=i;
//        }
//        array[nodeToAdjust]=temp;
        int i=2*nodeToAdjust+1;
        while(i<array.length){
            if (i<(array.length-1)&&array[i]<array[i+1])
                i++;
            if (temp>array[i])
                break;
            array[(i-1)/2]=array[i];
            i=2*i+1;
        }
        array[(i-1)/2]=temp;
    }



    public static void main(String[] args) {
        int[] array={1,4,5,3,2,7,6};
//        System.out.println(Arrays.toString(getLeastNumbers(array,4)));
        ArrayList<Integer> kNumbers=GetLeastNumbers2(array,3);
        System.out.println(kNumbers.toString());

    }
}
