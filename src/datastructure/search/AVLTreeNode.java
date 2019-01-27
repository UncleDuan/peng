package datastructure.search;

/**
 * Created by pengsel on 2019/1/27.
 */
public class AVLTreeNode {
    public int data;
    //平衡因子
    public int bf;
    public AVLTreeNode leftChild,rightChild;

    public static final int LEFTHIGH=1;
    public static final int EQUALHIGH=0;
    public static final int RIGHTHIGH=-1;

    public static void rightRotate(AVLTreeNode root){
        AVLTreeNode newRoot=root.leftChild;
        root.leftChild=newRoot.rightChild;
        newRoot.rightChild=root;
    }

    public static void  leftRotate(AVLTreeNode root){
        AVLTreeNode newRoot=root.rightChild;
        root.rightChild=newRoot.leftChild;
        newRoot.leftChild=root;
    }

    public static AVLTreeNode leftBalance(AVLTreeNode root){
        AVLTreeNode newRoot=root.leftChild;
        switch (newRoot.bf){
            case LEFTHIGH:
                newRoot.bf=EQUALHIGH;
                root.bf=EQUALHIGH;
                rightRotate(root);
                break;
            case RIGHTHIGH:
                AVLTreeNode rightChildOfNewRoot=newRoot.rightChild;
                switch (rightChildOfNewRoot.bf){
                    case LEFTHIGH:
                        root.bf=RIGHTHIGH;
                        newRoot.bf=EQUALHIGH;
                        break;

                }
        }
        return null;
    }
}

