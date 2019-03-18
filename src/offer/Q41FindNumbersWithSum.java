package offer;

/**
 * Created by pengsel on 2019/3/14.
 */
public class Q41FindNumbersWithSum {
    public static void findNumbersWithSum(int[] array,int sum){
        int p1=0;
        int p2=array.length-1;
        while (array[p1]+array[p2]!=sum){
            if (array[p1]+array[p2]<sum){
                p1++;
            }
            else
                p2--;
            if (p1==p2)
                break;
        }
        if (p1==p2)
            System.out.println("ERROR:没有找到");
        else
            System.out.println(array[p1]+"+"+array[p2]);
    }

    public static void findSequencesWithSum(int[] array ,int sum){
        int p1=0;
        int p2=1;
        int sumOfSeq=0;
        while (p1<=p2&&p2<array.length){
            sumOfSeq=sumSequence(array,p1,p2);
            if (sumOfSeq==sum) {
                printSeq(array, p1, p2);
                p1++;
            }
            else if (sumOfSeq<sum){
                p2++;
            }
            else
                p1++;
        }
    }

    private static int sumSequence(int[] array,int p1,int p2){
        int sum=0;
        for (int i=p1;i<=p2;i++){
            sum+=array[i];
        }
        return sum;
    }

    private static void printSeq(int[] array,int p1,int p2){
        for (int i=p1;i<p2;i++){
            System.out.print(array[i]+"+");
        }
        System.out.println(array[p2]);
    }

    public static void main(String[] args) {
        int[] array={1,2,4,5,6,8,9};
//        findNumbersWithSum(array,14);
        findSequencesWithSum(array,11);
    }


}
