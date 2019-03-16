package offer;

import java.util.Arrays;

/**
 * Created by pengsel on 2019/3/4.
 */
public class Q36InversePairs {
    /**
     * 逆序对：
     * 1.采用归并排序，计算调换的次数；
     * @param array
     * @return
     */
    public static int count=0;
    public static int inversePairs(int[] array){

        if (array==null||array.length==0)
            return -1;
        sort(array,0,array.length-1);
        return count;
    }

    private static void sort(int[] array,int left,int right){
        if (left<right){
            int mid=(left+right)/2;
            sort(array,left,mid);
            sort(array,mid+1,right);
            merge(array,left,mid,right);
        }
    }
    private static void merge(int[] array,int left,int mid,int right){
        int[] tempArray=new int[right-left+1];
        int i=left,j=mid+1,k=0;
        while (i<=mid&&j<=right){
            if (array[i]<=array[j]) {
                tempArray[k]=array[i];
                k++;
                i++;
            }
            else {
                tempArray[k]=array[j];
                j++;
                k++;
                count+=mid-i+1;
            }
        }
        while (i<=mid){
            tempArray[k]=array[i];
            i++;
            k++;
        }
        while (j<=right){
            tempArray[k]=array[j];
            j++;
            k++;
        }
        for (i=0;i<tempArray.length;i++){
            array[left+i]=tempArray[i];
        }
    }

    public static void main(String[] args) {
        int[] array={2,1,3,4,5,9,8};

        System.out.println(inversePairs(array));
        System.out.println(Arrays.toString(array));
    }
}
