package offer;

public class Q26Clone {
    static class ComplexListNode{
        public int val;
        public ComplexListNode next;
        public ComplexListNode sibling;
    }

    /**
     * 根据原始链表的每个结点N创建对应的N'，并把N'连接在N后面
     * @param head
     */
    public static void cloneNodes(ComplexListNode head){
        while (head!=null){
            ComplexListNode node=new ComplexListNode();
            node.val=head.val;
            node.next=head.next;
            node.sibling=null;
            
            head.next=node;
            head=node.next;
            
        }
    }

    /**
     * 设置复制出来的结点的sibling
     * @param head
     */
    public static void connectSiblingNodes(ComplexListNode head){
        while (head!=null){
            if (head.sibling!=null)
                head.next.sibling=head.sibling.next;
            head=head.next.next;
        }
    }

    /**
     * 把长链表分成两个链表
     * @param head
     * @return
     */
    public static ComplexListNode ReconnectNodes(ComplexListNode head){
        ComplexListNode cloneHead=head.next;
        ComplexListNode cloneNode=head.next;
        while (cloneNode.next!=null){
            head.next=cloneNode.next;
            head=head.next;

            cloneNode.next=head.next;
            cloneNode=cloneNode.next;
        }
        head.next=null;

        return cloneHead;
    }

    public static ComplexListNode clone(ComplexListNode head){
        if (head==null)
            return null;
        cloneNodes(head);
        connectSiblingNodes(head);
        return ReconnectNodes(head);
    }

}
