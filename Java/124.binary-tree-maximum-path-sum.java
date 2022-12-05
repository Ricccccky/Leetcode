import java.util.*;

/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
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
    public int maxPathSum(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        dfs(root, map);
        int result = Integer.MIN_VALUE;
        for (Map.Entry<TreeNode, Integer> entry : map.entrySet()) {
            result = Math.max(result, entry.getValue());
        }
        return result;
    }

    private int dfs(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left, map));
        int right = Math.max(0, dfs(root.right, map));
        map.put(root, left + right + root.val);
        return root.val + Math.max(left, right);
    }
}
// @lc code=end

