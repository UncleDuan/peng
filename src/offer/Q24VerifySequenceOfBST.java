package offer;

public class Q24VerifySequenceOfBST {
    public static boolean verifySequenceOfBST(int[] array,int start,int end){
        if (array==null||array.length==0)
            return false;
        if (start==end)
            return true;
        int i=start;
        while (array[i]<array[end]){
            i++;
        }
        for (int j=i;j<end;j++){
            if (array[j]<array[end])
                return false;
        }
        boolean left=true;
        boolean right=true;
        if (i>start)
            left=verifySequenceOfBST(array,start,(i-1));
        if (i<=end)
            right=verifySequenceOfBST(array,i,end-1);
        return left&&right;
    }

    public static void main(String[] args) {
        int[] array={5,7,6,9,11,10,8};
        System.out.println(verifySequenceOfBST(array,0,array.length-1));
    }
}
