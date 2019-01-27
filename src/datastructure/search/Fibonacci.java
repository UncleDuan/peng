package datastructure.search;

/**
 * Created by pengsel on 2019/1/26.
 */
public class Fibonacci {
    public static int fibonacci(int[] array,int key){
        int low=0;
        int high=array.length-1;
        int mid;
        int k=0;

        while (fibo(k)<high)
            k++;
        int[] arrayNew=new int[k];
        for (int i=0;i<k;i++){
            if (i<=high)
                arrayNew[i]=array[i];
            else
                arrayNew[i]=array[high];
        }
        while (low<=high) {
            mid=low+fibo(k-1)-1;
            if (key<arrayNew[mid]){
                k=k-1;
                high=mid-1;
            }else if (key>arrayNew[mid]){
                k=k-2;
                low=mid+1;
            }else {
                if (mid<=array.length)
                    return mid;
                else
                    return array.length-1;
            }
        }

        return -1;
    }

    public static int fibo(int n){
        if (n==0)
            return 0;
        if (n==1)
            return 1;
        return fibo(n-1)+fibo(n-2);
    }

    public static void main(String[] args) {
        int[] array={1,3,5,7,9};
        System.out.println(fibonacci(array,7));;
    }
}
