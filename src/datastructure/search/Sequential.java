package datastructure.search;

/**
 * Created by pengsel on 2019/1/26.
 */
public class Sequential {
    public static int sequential(int[] array,int key){
        for (int i=0;i<array.length;i++){
            if (array[i]==key)
                return i;
        }
        return -1;
    }
}
