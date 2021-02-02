/*
 * @lc app=leetcode id=156 lang=java
 *
 * [156] Binary Tree Upside Down
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
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode next = null;
        TreeNode prev = null;
        TreeNode r = null;
        while (root != null) {
            next = root.left;
            root.left = r;
            r = root.right;
            root.right = prev;
            
            prev = root;
            root = next;
        }
        
        return prev;
    }
}
// @lc code=end

