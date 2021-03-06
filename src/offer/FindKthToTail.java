package offer;

import datastructure.linkList.ListNode;

/**
 * Created by ionolab-DP on 2019/1/15.
 */
public class FindKthToTail {

    /**
     * 实现找到倒数第K个结点：
     * 1.记录头指针，找到第k个结点的引用
     * 2.两个开始同时移动，当后面的引用为尾节点时，前面的引用正好指向倒数第k个结点
     * 注意；也可以找到第k+1个结点，然后终止条件为后面的引用为null。
     * @param head 链表头结点的引用
     * @param k 第k个
     * @return 第k个结点
     */
    public static ListNode findKth(ListNode head, int k){
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

    public static void main(String[] args) {
        int[] array={1,2,3,4,5};
        ListNode head=ListNode.initListNode(array);
        ListNode.printListNode(head);
        System.out.println(findKth(head,1).val);
    }
}
