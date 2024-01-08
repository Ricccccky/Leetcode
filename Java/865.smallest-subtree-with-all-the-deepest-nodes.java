/*
 * @lc app=leetcode id=865 lang=java
 *
 * [865] Smallest Subtree with all the Deepest Nodes
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
    private int deepestDepth = 0;
    private TreeNode res;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int leftDepth = dfs(root.left, depth + 1), rightDepth = dfs(root.right, depth + 1);
        int nodeDepth = Math.max(leftDepth, rightDepth);
        deepestDepth = Math.max(nodeDepth, deepestDepth);
        if (leftDepth == deepestDepth && rightDepth == deepestDepth) {
            res = root;
        }

        return nodeDepth;
    }
}
// @lc code=end

