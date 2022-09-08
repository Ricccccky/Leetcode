import java.util.*;

/*
 * @lc app=leetcode id=1628 lang=java
 *
 * [1628] Design an Expression Tree With Evaluate Function
 */

// @lc code=start
/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};

class TreeNode extends Node {
    String val;
    TreeNode left;
    TreeNode right;

    public TreeNode(String val) {
        this.val = val;
    }

    @Override
    public int evaluate() {
        return dfs(this);
    }

    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return Integer.parseInt(root.val);
        }
        int leftVal = dfs(root.left);
        int rightVal = dfs(root.right);
        if (root.val.equals("+")) {
            return leftVal + rightVal;
        }
        if (root.val.equals("-")) {
            return leftVal - rightVal;
        }
        if (root.val.equals("*")) {
            return leftVal * rightVal;
        }
        if (root.val.equals("/")) {
            return leftVal / rightVal;
        }

        return -1;
    }
    
    @Override
    public String toString() {
        return val + "," + left + "," + right;
    }
}

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Deque<TreeNode> stack = new LinkedList<>();
        String ops = "+-*/";
        for (String str : postfix) {
            if (ops.contains(str)) {
                TreeNode node = new TreeNode(str);
                node.right = stack.pop();
                node.left = stack.pop();
                stack.push(node);
            } else {
                stack.push(new TreeNode(str));
            }
        }

        return stack.peek();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
// @lc code=end

