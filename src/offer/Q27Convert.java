package offer;

import datastructure.search.BiTreeNode;

public class Q27Convert {
    public static BiTreeNode lastNodeInList=null;

    public static BiTreeNode convert(BiTreeNode root){
        convertNode(root);
        BiTreeNode head=lastNodeInList;
        while (head!=null&&head.leftChild!=null){
            head=head.leftChild;
        }
        return head;
    }

    public static void convertNode(BiTreeNode node){
        if (node==null)
            return;
        BiTreeNode current=node;
        //对于双向链表的头结点，current.leftChild为null
        if (current.leftChild!=null)
            convertNode(current.leftChild);
        current.leftChild=lastNodeInList;
        //初始情况下lastNodeInList为null，要和一般情况分开
        if (lastNodeInList!=null)
            lastNodeInList.rightChild=current;
        lastNodeInList=current;
        //对于双向链表的尾结点的情况，此时倒数第一和倒数第二结点都已经连接了，整个双向链表已经形成
        if (current.rightChild!=null)
            convertNode(current.rightChild);
    }

    public static void traverse(BiTreeNode head){
        System.out.println("From head to tail:");
        while (head.rightChild!=null){
            System.out.println(head.data);
            head=head.rightChild;
        }
        System.out.println(head.data);
        System.out.println("From tail to head:");
        while (head.leftChild!=null){
            System.out.println(head.data);
            head=head.leftChild;
        }
        System.out.println(head.data);

    }
    public static void main(String[] args) {
        int[] array={3,2,1,4,5};
        BiTreeNode root=BiTreeNode.create(array);
        BiTreeNode head=convert(root);
        traverse(head);
    }
}
