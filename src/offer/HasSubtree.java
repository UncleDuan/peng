package offer;

import datastructure.search.BiTreeNode;

public class HasSubtree {
    public static boolean hasSubtree(BiTreeNode root1, BiTreeNode root2){
        boolean result =false;
        if (root1!=null&&root2!=null){
            if (root1.data==root2.data)
                result=doesTree1HaveTree2(root1,root2);
            if (!result)
                result=hasSubtree(root1.leftChild,root2);
            if (!result)
                result=hasSubtree(root1.rightChild,root2);
        }
        return result;
    }

    public static boolean doesTree1HaveTree2(BiTreeNode root1,BiTreeNode root2){
        if (root2==null)
            return true;
        if (root1==null)
            return false;
        if (root1.data!=root2.data){
            return false;
        }

        return doesTree1HaveTree2(root1.leftChild,root2.leftChild)&&doesTree1HaveTree2(root1.rightChild,root2.rightChild);
    }

    public static void main(String[] args) {
        //斜二叉树
        int[] array1={1,2,3,4,5,6,7};
        int[] array2={2,3,4};
        BiTreeNode root1=BiTreeNode.create(array1);
        BiTreeNode root2=BiTreeNode.create(array2);
        System.out.println(hasSubtree(root1,root2));
    }
}
