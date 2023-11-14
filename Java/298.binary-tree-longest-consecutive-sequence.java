/*
 * @lc app=leetcode id=298 lang=java
 *
 * [298] Binary Tree Longest Consecutive Sequence
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
 *         this.right = right;29
 *     }
 * }
 */
class Solution {
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root, root.val + 1, 1, 1);
        
    }

    private int dfs(TreeNode root, int target, int max, int cur) {
        if (root == null) {
            return max;
        }
        if (root.val == target) {
            cur++;
            max = Math.max(max, cur);
        } else {
            cur = 1;
        }
        return Math.max(dfs(root.left, root.val + 1, max, cur), dfs(root.right, root.val + 1, max, cur));
    }
}
// @lc code=end

