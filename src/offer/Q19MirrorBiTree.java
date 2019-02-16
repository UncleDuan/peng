package offer;

import datastructure.search.BiTreeNode;

public class Q19MirrorBiTree {
    public static void mirrorRecursively(BiTreeNode root){
        if (!(root==null)){
            mirror(root);
            mirrorRecursively(root.leftChild);
            mirrorRecursively(root.rightChild);
        }
    }

    public static void mirror(BiTreeNode root){
        if (root==null)
            return;
        BiTreeNode temp=null;
        temp=root.leftChild;
        root.leftChild=root.rightChild;
        root.rightChild=temp;
    }

    public static void main(String[] args) {
        int[] array={2,1,3,0,5};
        BiTreeNode root=BiTreeNode.create(array);
        BiTreeNode.traverse(root);
        mirror(root);
        BiTreeNode.traverse(root);


    }
}
