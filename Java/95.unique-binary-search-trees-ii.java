import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] dp = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = new ArrayList<>();
        }
        if (n == 0) {
            return dp[n];
        }
        dp[0].add(null);
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < len; i++) {
                for (TreeNode leftNode : dp[i]) {
                    for (TreeNode rightNode : dp[len - i - 1]) {
                        TreeNode root = new TreeNode(i + 1);
                        root.left = leftNode;
                        root.right = increase(rightNode, i + 1);
                        dp[len].add(root);
                    }
                }
            }
        }
        return dp[n];
    }

    private TreeNode increase(TreeNode node, int increment) {
        if (node == null) {
            return null;
        }
        TreeNode root = new TreeNode(node.val + increment);
        root.left = increase(node.left, increment);
        root.right = increase(node.right, increment);
        return root;
    }
}
// @lc code=end

