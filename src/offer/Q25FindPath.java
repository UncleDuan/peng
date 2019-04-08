package offer;

import datastructure.search.BiTreeNode;
import java.util.Stack;

public class Q25FindPath {
    public static void findPath(BiTreeNode root,int expectedSum){
        if (root==null)
            return;
        int sumPath=0;
        Stack<Integer> stack=new Stack<Integer>();
        findPath(root,expectedSum,stack,sumPath);
    }

    public static void findPath(BiTreeNode current,int expectedSum,Stack<Integer> stack,int sumPath){
        sumPath+=current.data;
        stack.push(current.data);
        boolean isLeaf=current.leftChild==null&&current.rightChild==null;
        if (isLeaf&&sumPath==expectedSum){
            System.out.println("----------A new path found:----------");
            for (int i:stack)
                System.out.print(i+"   ");
            System.out.println("\n");
        }else {
            if (current.leftChild != null) {
                findPath(current.leftChild, expectedSum, stack, sumPath);
            }
            if (current.rightChild!=null){
                findPath(current.rightChild,expectedSum,stack,sumPath);
            }
        }
        stack.pop();
//        sumPath-=current.data;
    }

    public static void main(String[] args) {
        int[] array={10,5,12,4,7,0};
        BiTreeNode root=BiTreeNode.create(array);
        findPath(root,22);
    }
}
