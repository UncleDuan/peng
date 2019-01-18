package offer;

/**
 * Created by ionolab-DP on 2019/1/18.
 */
public class MergeList {

    public static ListNode merge1(ListNode head1,ListNode head2){
        if (head1==null){
            return head2;
        }
        if (head2==null){
            return head1;
        }

        ListNode head=null;
        if (head1.val<=head2.val){
            head=head1;
            head1=head.next;
        }else {
            head=head2;
            head2=head2.next;
        }
        ListNode preNode=head;
//      当达到了某一个链表的末尾时结束
        /**
         * 正常运行条件：
         * 必须两个都不是null。
         */
        while (head1!=null&&head2!=null){
//          head1与head2存储的是当前结点，preNode存储的是合并列表的最后一结点
            if (head1.val<=head2.val){
                /**
                 * head1中存储值较小：
                 * 1.将head1置为合并链表的下一结点;
                 * 2.更新前一结点preNode为当前结点head1;
                 * 3.更新当前结点head1为后一节点head1.next;
                 */
                preNode.next=head1;
                preNode=preNode.next;
                head1=head1.next;
            }else {
                preNode.next=head2;
                preNode=preNode.next;
                head2=head2.next;
            }
        }
        /**
         * 考虑终点时：
         * 1.preNode赋值给了某一个链表的终止结点；
         * 2.需要把preNode指向另一个链表的当前结点。
         */
        if (head1!=null){
            preNode.next=head1;
        }
        if (head2!=null){
            preNode.next=head2;
        }
        return head;
    }

    /**
     * 递归实现
     * @param head1 链表1
     * @param head2 链表2
     * @return 合并后的链表
     */
    public static ListNode merge2(ListNode head1,ListNode head2){
        if (head1==null){
            return head2;
        }
        if (head2==null){
            return head1;
        }
        ListNode mergeHead=null;
        if (head1.val<head2.val){
            mergeHead=head1;
            mergeHead.next=merge2(head1.next,head2);
        }else {
            mergeHead=head2;
            mergeHead.next=merge2(head1,head2.next);
        }
        return mergeHead;
    }

    public static void main(String[] args) {
        int[] array1={1,3,5,7,9};
        int[] array2={2,4,6,8,10};
        ListNode head1=ListNode.initListNode(array1);
        ListNode head2=ListNode.initListNode(array2);
        ListNode.printListNode(merge1(head1,head2));

    }
}
