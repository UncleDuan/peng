package offer;

import datastructure.search.BiTreeNode;
import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.Arrays;

public class Q30GetLeastNumbers {
    public static int[] getLeastNumbers(int[] array,int k){
        if (array==null||array.length==0)
            return null;
        int[] result=new int[k];
        int pivot=0;
        int start=0;
        int end=array.length-1;
        while (pivot!=k-1){
            if (pivot>k-1) {
                end = pivot - 1;
                pivot=partition(array,start,end);
            }else {
                start=pivot+1;
                pivot=partition(array,start,end);
            }
        }
        for (int i=0;i<k;i++){
            result[i]=array[i];
        }
        return result;
    }

    public static int partition(int[] array,int start,int end){
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


    public static void getLeastNumbers2(int[] array,int k){
        if (array==null||array.length==0||k<=0||k>array.length)
            return ;
        BiTreeNode root=new BiTreeNode();
        root.data=array[0];
        for (int i=1;i<array.length;i++){
            if (i<k)
                BiTreeNode.insert(root,array[i]);
            else{
                int max=root.max();
                if (array[i]<max){
                    BiTreeNode.delete(root,max);
                    BiTreeNode.insert(root,array[i]);

                }
            }
        }
        BiTreeNode.traverse(root);
    }
    public static void main(String[] args) {
        int[] array={1,4,5,3,2,7,6};
//        System.out.println(Arrays.toString(getLeastNumbers(array,4)));
        getLeastNumbers2(array,3);
    }
}
