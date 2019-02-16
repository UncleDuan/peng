package offer;

import datastructure.stack.Stack;

public class Q22IsPopOrder {
    public static boolean isPopOrder(int[] array1,int[] array2){
        if (array1==null||array1.length==0||array2==null||array2.length==0||array1.length!=array2.length)
            return false;
        Stack stack=new Stack();
        stack.push(array1[0]);
        int pushIndex=1;
        int popIndex=0;

        while (pushIndex<array1.length||popIndex<array2.length){
            while (stack.getTop()!=array2[popIndex]&&pushIndex<array1.length){
                stack.push(array1[pushIndex++]);
            }
            if (pushIndex==array1.length&&stack.getTop()!=array2[popIndex]) {
                return false;
            }
            stack.pop();
            popIndex++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array1={1,2,3,4,5};
        int[] array2={4,5,3,2,1};
        int[] array3={4,3,5,1,2};
        System.out.println(isPopOrder(array1,array2));
        System.out.println(isPopOrder(array1,array3));
    }
}
