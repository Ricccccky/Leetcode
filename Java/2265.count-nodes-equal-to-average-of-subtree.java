/*
 * @lc app=leetcode id=2265 lang=java
 *
 * [2265] Count Nodes Equal to Average of Subtree
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
    public int averageOfSubtree(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] left = dfs(root.left), right = dfs(root.right);
        int sum = left[0] + right[0] + root.val, cnt = left[1] + right[1] + 1;
        if (root.val == sum / cnt) {
            res++;
        }

        return new int[] {sum, cnt};
    }
}
// @lc code=end

