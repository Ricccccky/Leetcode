/*
 * @lc app=leetcode id=687 lang=java
 *
 * [687] Longest Univalue Path
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
    public int longestUnivaluePath(TreeNode root) {
        int[] result = new int[1];
        if (root == null) {
            return result[0];
        }
        dfs(root, result);
        return result[0];
    }

    private int dfs(TreeNode root, int[] result) {
        int leftLength = 0;
        int rightLength = 0;
        if (root.left != null) {
            leftLength = dfs(root.left, result);
        }
        if (root.right != null) {
            rightLength = dfs(root.right, result);
        }
        if (root.left != null && root.val == root.left.val) {
            leftLength++;
        } else {
            leftLength = 0;
        }
        if (root.right != null && root.val == root.right.val) {
            rightLength++;
        } else {
            rightLength = 0;
        }
        result[0] = Math.max(result[0], leftLength + rightLength);
        return Math.max(leftLength, rightLength);
    }
}
// @lc code=end

