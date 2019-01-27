package datastructure.search;

/**
 * Created by pengsel on 2019/1/26.
 */
public class Binary {

    public static int binary(int[] array, int key){
        int low=0;
        int high=array.length-1;
        int middle;
        while (low<high){
            middle=low+(high-low)/2;
            if (array[middle]==key)
                return middle;
            else if (key<array[middle]){
                high=middle-1;
            }else {
                low=middle+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array={1,3,5,7,9};
        System.out.println(binary(array,7));;
    }
}
