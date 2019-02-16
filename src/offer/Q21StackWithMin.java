package offer;

import datastructure.stack.Stack;

public class Q21StackWithMin {

    Stack dataStack=new Stack();
    Stack minStack=new Stack();

    public static final int ILLEGALARGUMENT=Integer.MAX_VALUE;
    public boolean push(int val){
        this.dataStack.push(val);
        if (minStack.getCount()==0){
            minStack.push(val);
        }
        else if (minStack.getTop()<=val)
            minStack.push(minStack.getTop());
        else minStack.push(val);
        return true;
    }

    public int pop(){
        minStack.pop();
        return dataStack.pop();
    }

    public int min(){
        if (minStack.getCount()>0)
            return minStack.getTop();
        return ILLEGALARGUMENT;
    }
}
