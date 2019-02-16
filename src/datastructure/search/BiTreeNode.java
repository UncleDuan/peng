package datastructure.search;

import java.util.Objects;

/**
 * Created by pengsel on 2019/1/26.
 */
public class BiTreeNode {
    public int data;
    public BiTreeNode leftChild,rightChild;

    /**
     * 查找一个结点
     * @param biTree 二叉树
     * @param key 结点值
     * @return
     */
    public static BiTreeNode search(BiTreeNode biTree,int key){
        if (biTree==null)
            return null;
        if (key==biTree.data)
            return biTree;
        else if (key<biTree.data){
            return search(biTree.leftChild,key);
        }
        else {
            return search(biTree.rightChild,key);
        }
    }

    /**
     * 插入结点
     * @param biTree 二叉树
     * @param key 插入结点值
     * @return
     */
    public static boolean insert(BiTreeNode biTree,int key){
        if (search(biTree,key)==null){
            BiTreeNode btn=new BiTreeNode();
            btn.data=key;
            BiTreeNode mostCloseNode=findMostCloseNode(biTree,key,null);
            if (key<mostCloseNode.data)
                mostCloseNode.leftChild=btn;
            else
                mostCloseNode.rightChild=btn;
            return true;
        }
        return false;
    }

    /**
     * 找到插入结点的父节点
     * @param biTree 二叉树
     * @param key 结点值
     * @param father 父节点
     * @return
     */
    private static BiTreeNode findMostCloseNode(BiTreeNode biTree,int key,BiTreeNode father){
        if (biTree==null)
            return father;
        father=biTree;
        if (key<biTree.data){
            return findMostCloseNode(biTree.leftChild,key,father);
        }else {
            return findMostCloseNode(biTree.rightChild,key,father);
        }
    }

    /**
     * 用数组初始化一个二叉树
     * @param array 数组
     * @return
     */
    public static BiTreeNode create(int[] array){
        if (array==null)
            return null;

        BiTreeNode root=new BiTreeNode();
        root.data=array[0];
        for (int i=0;i<array.length;i++){
            insert(root,array[i]);
        }
        return root;
    }

    /**
     * 删除一个结点
     * @param biTree 二叉树
     * @param key 对应的key
     * @return 是否删除成功
     */
    public static boolean delete(BiTreeNode biTree,int key){
        BiTreeNode father=biTree;
        if (biTree==null)
            return false;
        else {
            //Todo father不是正确的
            if (key==biTree.leftChild.data||key==)
                return deleteNode(biTree,father);
            else if (key<biTree.data){
                return delete(biTree.leftChild,key);
            }else {
                return delete(biTree.rightChild,key);
            }
        }
    }

    /**
     * 删除一个结点：
     * 1.叶子结点，直接删除；
     * 2.只有左子树或右子树的结点，子承父业；
     * 3.含有左右两个子树，找到p结点的直接前驱或者后继s来替换它，然后再删除结点s。
     * @param node 要删除的结点
     * @param father 删除结点的父结点
     * @return 是否删除成功
     */
    private static boolean deleteNode(BiTreeNode node,BiTreeNode father){
        if (node.rightChild==null&&node.leftChild==null){
            if (node.data>father.data){
                father.rightChild=null;
            }else {
                father.leftChild=null;
            }
        }
        if (node.rightChild==null) {
            if (node.data > father.data) {
                father.rightChild = node.leftChild;
            } else {
                father.leftChild = node.leftChild;
            }
        }
        else if (node.leftChild==null){
                if (node.data>father.data){
                    father.rightChild=node.rightChild;
                }else {
                    father.leftChild=node.rightChild;
                }
        }else {
            BiTreeNode preNode=node.leftChild;
            BiTreeNode fatherOfPreNode=node;
            while (preNode.rightChild!=null){
                fatherOfPreNode=preNode;
                preNode=preNode.rightChild;
            }
            node.data=preNode.data;
            //删除preNode结点，preNode只有左子树，或者没有。删除它需要fatherOfPreNode结点
            deleteNode(preNode,fatherOfPreNode);

        }
        return true;
    }

    /**
     * 前序遍历二叉树
     * @param biTree 二叉树
     */
    public static void traverse(BiTreeNode biTree){
        if (biTree==null)
            return;
        System.out.println(biTree.data);
        traverse(biTree.leftChild);
        traverse(biTree.rightChild);

    }
    public int max(){
        BiTreeNode temp=this;
        while (temp.rightChild!=null){
            temp=temp.rightChild;
        }
        return temp.data;
    }

    public static void main(String[] args) {
//        int[] array={62,88,58,47,35,73,51,99,37,93};
//        BiTreeNode head=BiTreeNode.create(array);
//        traverse(head);
//        System.out.println(search(head,100));
//        insert(head,100);
//        traverse(head);
//        delete(head,99);
//        traverse(head);
//
        int[] array1={80};
        BiTreeNode head1=BiTreeNode.create(array1);
        BiTreeNode head2=BiTreeNode.create(array1);
        System.out.println(head1.equals(head2));


    }

    @Override
    public boolean equals(Object o) {
        if (o==null)
            return true;
        BiTreeNode that=(BiTreeNode) o;
        if ( that.data!=data)
            return false;
        boolean result=true;
        if (leftChild!=null)
            result=result&&leftChild.equals(that.leftChild);
        if (rightChild!=null)
            result=result&&rightChild.equals(that.rightChild);
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, leftChild, rightChild);
    }
}
