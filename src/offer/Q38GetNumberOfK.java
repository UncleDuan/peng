package offer;

/**
 * Created by pengsel on 2019/3/5.
 */
public class Q38GetNumberOfK {

    /**
     * 用二分查找找到第一个数字K和最后一个数字K
     * @param array
     * @param k
     * @return
     */
    public static int getNumberOfK(int[] array,int k){

        int result=0;
        if (!(array==null||array.length==0||k<array[0]||k>array[array.length-1])){
            int first=getFirstK(array,k,0,array.length-1);
            int last=getLastK(array,k,0,array.length-1);
            if (first>-1&&last>-1)
                result=last-first+1;
        }
        return result;

    }
    private static int getFirstK(int[] array,int k,int start,int end){
        if (start>end)
            return -1;
        int mid=(start+end)/2;
        if ( array[mid]==k){
            if (mid==0||array[mid-1]!=k)
                return mid;
            else
                end=mid-1;
        }
        else if (array[mid]>k)
            end=mid-1;
        else
            start=mid+1;

        return getFirstK(array,k,start,end);
    }

    private static int getLastK(int[] array,int k,int start,int end){
        if (start>end)
            return -1;
        int mid=(start+end)/2;
        if ( array[mid]==k){
            if ((mid==array.length-1)||array[mid+1]!=k)
                return mid;
            else
                start=mid+1;
        }
        else if (array[mid]>k)
            end=mid-1;
        else
            start=mid+1;
        return getLastK(array,k,start,end);
    }

    public static void main(String[] args) {
        int[] array={1,2,3,3,3,4,4,5,5,5,5,6};
        System.out.println(getNumberOfK(array,5));
        for (int i=1;i<=6;i++){
            System.out.println(getNumberOfK(array,i));
        }
    }


}
