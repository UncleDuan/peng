package offer;

import datastructure.search.BiTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q23PrintFromTopToBottom {
    public static void printFromTopToBottom(BiTreeNode root){
        if (root==null)
            return;
        Queue<BiTreeNode> queue=new LinkedList<BiTreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            BiTreeNode temp=queue.poll();
            System.out.println(temp.data);
            if (temp.leftChild!=null) {
                queue.offer(temp.leftChild);
            }
            if (temp.rightChild!=null) {
                queue.offer(temp.rightChild);
            }
        }
    }

    public static void main(String[] args) {
        int[] array={3,2,1,4,5};
        BiTreeNode root=BiTreeNode.create(array);
        printFromTopToBottom(root);

    }
}
