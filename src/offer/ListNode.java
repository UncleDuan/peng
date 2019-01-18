package offer;

/**
 * Created by ionolab-DP on 2019/1/18.
 */
public class ListNode {
    public int val;
    public ListNode next;
    ListNode(int val) {
        this.val = val;
    }
    /**
     * 一种不优雅的用数组初始化一个链表的方法：
     * 没有定义一个链表类，单纯通过结点实现的。
     * @param array 数组
     * @return 头结点
     */
    public static ListNode initListNode(int[] array){
        if (array==null){
            return null;
        }
        ListNode head=new ListNode(array[0]);
        ListNode result=head;
        for (int i=1;i<array.length;i++){
            ListNode node=new ListNode(array[i]);
            head.next=node;
            head=node;
        }
        return result;
    }

    /**
     * 打印一个单向链表
     * @param head 头结点
     */
    public static void printListNode(ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
