/*
 * @lc app=leetcode id=2385 lang=java
 *
 * [2385] Amount of Time for Binary Tree to Be Infected
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
    private int res;
    public int amountOfTime(TreeNode root, int start) {
        res = 0;
        dfs(root, start);

        return res;
    }

    private int dfs(TreeNode root, int start) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, start);
        int right = dfs(root.right, start);
        if (root.val == start) {
            res = Math.max(left, right);
            return -1;
        } else if (left >= 0 && right >= 0) {
            return Math.max(left, right) + 1;
        } else {
            res = Math.max(res, Math.abs(left - right));
            return Math.min(left, right) - 1;
        }
    }
}
// @lc code=end

