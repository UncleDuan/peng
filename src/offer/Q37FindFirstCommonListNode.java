package offer;

import java.util.Stack;

/**
 * Created by pengsel on 2019/3/4.
 */
public class Q37FindFirstCommonListNode {
    class ListNode{
        int val;
        ListNode next;
    }

    /**
     * 用两个栈装两个链表，依次弹出
     * @param root1
     * @param root2
     * @return
     */
    public static ListNode findFirstCommonListNode1(ListNode root1,ListNode root2){
        if (root1==null||root2==null)
            return null;
        Stack<ListNode> stack1=new Stack<ListNode>();
        Stack<ListNode> stack2=new Stack<ListNode>();
        while (root1!=null){
            stack1.push(root1);
            root1=root1.next;
        }
        while (root2!=null){
            stack2.push(root2);
            root2=root2.next;
        }
//        if (stack1.peek()!=stack2.peek())
//            return null;
//        ListNode result=stack1.peek();
//
//        while (!stack1.isEmpty()&&!stack2.isEmpty()){
//            //todo error
//            result=stack1.peek();
//            stack1.pop();
//            stack2.pop();
//            if (stack1.peek()!=stack2.peek())
//                break;
//        }
//        return result;
        ListNode commonListNode = null;

        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek() ) {
            stack2.pop();
            commonListNode = stack1.pop();;
        }

        return commonListNode;
    }

    public static ListNode findFirstCommonListNode(ListNode root1,ListNode root2){
        if (root1==null||root2==null)
            return null;
        ListNode head1=root1;
        ListNode head2=root2;
        int count=0;
        //找到两个链表相差多少个结点
        while (head1!=null){
            head1=head1.next;
            count++;
        }
        while (head2!=null){
            head2=head2.next;
            count--;
        }
        //长链表先跑，直到后一段长度与短链表相等
        if (count>0){
            while (count>0){
                count--;
                root1=root1.next;
            }
        }
        if (count<0){
            while (count<0) {
                count++;
                root2=root2.next;
            }
        }
        //如果引用了同一对象则返回
        while (root1!=null){
            if (root1==root2)
                return root1;
            else {
                root1=root1.next;
                root2=root2.next;
            }

        }
        return null;
    }
}
