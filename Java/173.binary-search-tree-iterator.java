import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> temp;
    public BSTIterator(TreeNode root) {
        temp = new Stack<>();
        while (root != null) {
            temp.push(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode top = temp.pop();
        int result = top.val;
        top = top.right;
        while (top != null) {
            temp.push(top);
            top = top.left;
        }
        return result;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (!temp.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

