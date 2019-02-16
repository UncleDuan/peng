package datastructure.stack;

import datastructure.linkList.ListNode;

public class Stack {

    private ListNode top;
    private int count=0;

    public int getTop() {
        return top.val;
    }

    public int getCount() {
        return count;
    }

    public boolean push(int val){
        ListNode node=new ListNode(val);
        node.next=this.top;
        this.top=node;
        this.count++;
        return true;
    }

    public int pop(){
        if (count>0) {
            int result = this.top.val;
            this.top = this.top.next;
            this.count--;
            return result;
        }
        return Integer.MAX_VALUE;
    }
}
