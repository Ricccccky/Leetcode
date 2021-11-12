import java.util.*;

/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
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
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> dp = new HashMap<>();
        
        return rob(root, dp);
    }

    private int rob(TreeNode root, Map<TreeNode, Integer> dp) {
        if (root == null) {
            return 0;
        } else if (dp.containsKey(root)) {
            return dp.get(root);
        }
        int robRoot = root.val;
        if (root.left != null) {
            robRoot += rob(root.left.left, dp) + rob(root.left.right, dp);
        }
        if (root.right != null) {
            robRoot += rob(root.right.left, dp) + rob(root.right.right, dp);
        }
        int notRobRoot = rob(root.left, dp) + rob(root.right,dp);
        dp.put(root, Math.max(notRobRoot, robRoot));

        return Math.max(notRobRoot, robRoot);
    }
}
// @lc code=end

