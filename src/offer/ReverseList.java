package offer;

import datastructure.linkList.ListNode;

/**
 * Created by ionolab-DP on 2019/1/18.
 */
public class ReverseList {
    /**
     * 输入链表头结点，返回链表
     * @param head 原始链表的头结点
     * @return  反转后链表的头结点
     */
    public static ListNode reverseList(ListNode head){
        ListNode reversedHead=null;
        ListNode currentNode=head;
        ListNode preNode=null;
        while (currentNode!=null){
//          保存下一结点，当当前结点指向前一结点时，链表断裂，保存了后一结点才可以续上。
            ListNode next=currentNode.next;
//          将当前结点指向前一结点
            currentNode.next=preNode;
//          更新前一节点为原链表的当前结点
            preNode=currentNode;
//          更新当前结点为原链表的下一结点
            currentNode=next;
        }
        return preNode;
    }
}
