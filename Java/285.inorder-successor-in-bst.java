/*
 * @lc app=leetcode id=285 lang=java
 *
 * [285] Inorder Successor in BST
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = new TreeNode(Integer.MAX_VALUE);
        while (root != null) {
            if (root.val > p.val) {
                if (root.val < res.val) {
                    res = root;
                    root = root.left;
                }
            } else {
                root = root.right;
            }
        }
        if (res.val == Integer.MAX_VALUE) {
            return null;
        }
        
        return res;
    }
}
// @lc code=end

