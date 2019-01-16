package offer;

/**
 * Created by ionolab-DP on 2019/1/14.
 */
public class DeleteNode {
    class Node{
        public int data;
        public Node next;
    }

    /**
     * O(1)复杂度删除某结点
     * @param head 头结点
     * @param toBeDeleted 删除结点
     */
    public static void Node(Node head,Node toBeDeleted){

        if (head==null||toBeDeleted==null){
            return;
        }
        if (toBeDeleted.next!=null){
            toBeDeleted.data=toBeDeleted.next.data;
            toBeDeleted.next=toBeDeleted.next.next;
        }else if (head.next==null){
            head=null;
            toBeDeleted=null;
        }else {
            Node tempNode=head;
            while (tempNode.next!=toBeDeleted){
                tempNode=tempNode.next;
            }
            tempNode.next=null;
        }
    }
}
