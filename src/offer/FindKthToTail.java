package offer;

/**
 * Created by ionolab-DP on 2019/1/15.
 */
public class FindKthToTail {
    /**
     * 实现链表，注意应为静态内部类
     */
     static class ListNode {
         int val;
         ListNode next = null;

         ListNode(int val) {
             this.val = val;
         }
     }

    /**
     * 实现找到倒数第K个结点：
     * 1.记录头指针，找到第k个结点的引用
     * 2.两个开始同时移动，当后面的引用为尾节点时，前面的引用正好指向倒数第k个结点
     * 注意；也可以找到第k+1个结点，然后终止条件为后面的引用为null。
     * @param head 链表头结点的引用
     * @param k 第k个
     * @return 第k个结点
     */
    public static ListNode findKth(ListNode head,int k){
//        k需要大于0
        if (k<=0){
            return null;
        }
//        head不能为空指针
        if (head==null)
            return null;
        ListNode pre=head;
        for (int i=0;i<k-1;i++) {
            head = head.next;
            if (head==null)
                return null;
        }

        while (head.next!=null){
            pre=pre.next;
            head=head.next;
        }
        return pre;
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
    public static void main(String[] args) {
        int[] array={1,2,3,4,5};
        ListNode head=initListNode(array);
        printListNode(head);
        System.out.println(findKth(head,1).val);
    }
}
