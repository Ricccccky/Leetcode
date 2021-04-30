/*
 * @lc app=leetcode id=1644 lang=java
 *
 * [1644] Lowest Common Ancestor of a Binary Tree II
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
    private int find = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = dfs(root, p, q);
        
        return find == 2 ? res : null;
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode l = dfs(root.left, p, q);
        TreeNode r = dfs(root.right, p, q);
        if (root == p || root == q) {
            find++;
            return root;
        }
        if (l != null && r != null) {
            return root;
        } else if (l != null) {
            return l;
        } else if (r != null) {
            return r;
        }

        return null;
    }
}
// @lc code=end

