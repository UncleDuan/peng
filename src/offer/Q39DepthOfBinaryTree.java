package offer;

import datastructure.search.BiTreeNode;

import static java.lang.StrictMath.max;

/**
 * Created by pengsel on 2019/2/28.
 */
public class Q39DepthOfBinaryTree {
    public static int getDepth2(BiTreeNode root){
        if (root==null)
            return 0;
        return max(getDepth(root.leftChild)+1,getDepth(root.rightChild)+1);
    }

    /**
     * 简洁但是一个结点会被重复多次
     * @param root
     * @return
     */
    public static boolean isBalanced(BiTreeNode root){
        if (root==null)
            return false;
        int leftDepth=getDepth2(root.leftChild);
        int rightDepth=getDepth2(root.rightChild);
        int diff=leftDepth-rightDepth;
        if (diff<=1&&diff>=-1)
            return isBalanced(root.leftChild)&&isBalanced(root.rightChild);
        return false;

    }

    /**
     * 该方法每个结点只需要遍历一次。
     * -1代表不平衡
     * @param root
     * @return
     */
    public static boolean IsBalanced_Solution(BiTreeNode root) {
        return getDepth(root) != NOT_BALANCED;
    }

    public static final int NOT_BALANCED=-1;
    private static int getDepth(BiTreeNode root) {
        if (root == null)
            return 0;
        int left = getDepth(root.leftChild);
        if (left == NOT_BALANCED)
            return NOT_BALANCED;
        int right = getDepth(root.rightChild);
        if (right == NOT_BALANCED)
            return NOT_BALANCED;
        return Math.abs(left - right) > 1 ? NOT_BALANCED : 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        int[] array={2,1,3};
        BiTreeNode root=BiTreeNode.create(array);
        System.out.println(0);
    }

}
