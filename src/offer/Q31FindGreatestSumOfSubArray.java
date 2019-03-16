package offer;

/**
 * Created by pengsel on 2019/2/18.
 */
public class Q31FindGreatestSumOfSubArray {
    /**
     * 当累加和出现负数时，抛弃该数组
     * @param array
     * @return
     */
    public static int findGreatestSumOfSubArray(int[] array){
        if (array==null||array.length==0)
            return 0;
        int currentSum=0;
        int greatestSum= 0;
        for (int anArray : array) {
            if (currentSum < 0)
                currentSum = anArray;
            else
                currentSum += anArray;
            if (currentSum > greatestSum)
                greatestSum = currentSum;
        }
        if (greatestSum<0)
            return 0;
        return greatestSum;
    }

    public static void main(String[] args) {
        int[] array={-1,-2,-4,-5,-6};
        System.out.println(findGreatestSumOfSubArray(array));
    }
}
