package com.nowcoder;

import java.util.ArrayList;

public class TranserveTreeNode {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> stack = new ArrayList<Integer>();
        ArrayList<TreeNode> arr = new ArrayList<TreeNode>();
        int top = 0;
        if(root==null) return stack;
        stack.add(root.val);
        arr.add(root);
        while(top<stack.size()){
            TreeNode t = arr.get(top);
            if(t.left!=null){
                arr.add(t.left);
                stack.add(t.left.val);
            }
            if(t.right!=null){
                arr.add(t.right);
                stack.add(t.right.val);
            }
            top++;
        }
        return stack;
    }
}

class TreeNode{
     TreeNode left;
     TreeNode right;
     int val;
}