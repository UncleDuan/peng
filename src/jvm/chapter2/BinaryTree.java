package jvm.chapter2;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by ionolab-DP on 2019/1/2.
 */
public class BinaryTree{

    public Node init() {//注意必须逆序建立，先建立子节点，再逆序往上建立，因为非叶子结点会使用到下面的节点，而初始化是按顺序初始化的，不逆序建立会报错
        Node J = new Node(8, null, null);
        Node H = new Node(4, null, null);
        Node G = new Node(2, null, null);
        Node F = new Node(7, null, J);
        Node E = new Node(5, H, null);
        Node D = new Node(1, null, G);
        Node C = new Node(9, F, null);
        Node B = new Node(3, D, E);
        Node A = new Node(6, B, C);
        return A;   //返回根节点
    }

    public Node reconstruct(int[] pre,int[] in){
        if (pre == null || in == null) {
            return null;
        }
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        if (pre.length != in.length) {
            return null;
        }
        Node root = new Node(pre[0]);
        for (int i = 0; i < pre.length; i++) {
            if (pre[0] == in[i]) {
                root.setLeftNode(reconstruct(
                        Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i)));
                root.setRightNode(reconstruct(
                        Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length)));
            }
        }
        return root;

    }

    public void preList(Node root){
        System.out.print(root.getData());
        if (root.getLeftNode()!=null)
            preList(root.getLeftNode());
        if (root.getRightNode()!=null)
            preList(root.getRightNode());
    }

    public void middleList(Node root){

        if (root.getLeftNode()!=null)
            middleList(root.getLeftNode());

        System.out.print(root.getData());

        if (root.getRightNode()!=null)
            middleList(root.getRightNode());
    }

    public void afterList(Node root){

        if (root.getLeftNode()!=null)
            afterList(root.getLeftNode());

        if (root.getRightNode()!=null)
            afterList(root.getRightNode());
        System.out.print(root.getData());
    }

    //基于堆栈的实现
    //前序遍历
    public void preListByStack(Node root){
        Stack<Node> stack=new Stack<Node>();
        Node node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                System.out.print(node.getData());
                stack.push(node);   //直接压栈
                node = node.getLeftNode();
            } else {
                node = stack.pop(); //出栈
                node = node.getRightNode();
            }
        }
    }

    //中序遍历
    public void middleListByStack(Node root){
        Stack<Node> stack=new Stack<Node>();
        Node node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);   //直接压栈
                node = node.getLeftNode();
            } else {
                node = stack.pop(); //出栈并访问
                System.out.print(node.getData());
                node = node.getRightNode();
            }
        }
    }

    public void afterListByStack(Node root) {   //后序遍历
        Stack<Node> stack = new Stack<Node>();
        Stack<Node> output = new Stack<Node>();//构造一个中间栈来存储逆后序遍历的结果
        Node node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                output.push(node);
                stack.push(node);
                node = node.getRightNode();
            } else {
                node = stack.pop();
                node = node.getLeftNode();
            }
        }
        while (output.size() > 0) {

            System.out.print(output.pop().getData());
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        System.out.println("前序遍历:");
        binaryTree.preList(binaryTree.init());
        System.out.println("");

        System.out.println("前序遍历,堆栈实现:");
        binaryTree.preListByStack(binaryTree.init());
        System.out.println("");

        System.out.println("中序遍历:");
        binaryTree.middleList(binaryTree.init());
        System.out.println("");

        System.out.println("中序遍历,堆栈实现:");
        binaryTree.middleListByStack(binaryTree.init());
        System.out.println("");

        System.out.println("后序遍历:");
        binaryTree.afterList(binaryTree.init());
        System.out.println("");

        System.out.println("后序遍历,堆栈实现:");
        binaryTree.afterListByStack(binaryTree.init());
        System.out.println("");

        System.out.println("Reconstruction:");
        int[] pre={6,3,1,2,5,4,9,7,8};
        int[] in={1,2,3,4,5,6,7,8,9};
        Node root=binaryTree.reconstruct(pre,in);
        binaryTree.afterList(root);

    }



}

class Node {
    private int data;
    private Node leftNode;
    private Node rightNode;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node leftNode, Node rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}
