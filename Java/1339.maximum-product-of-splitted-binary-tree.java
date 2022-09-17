import java.util.*;

/*
 * @lc app=leetcode id=1339 lang=java
 *
 * [1339] Maximum Product of Splitted Binary Tree
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
    public int maxProduct(TreeNode root) {
        List<Integer> sums = new ArrayList<>();
        long totalSum = treeSum(root, sums);
        long result = 0;
        int mod = 1000000007;
        for (int sum : sums) {
            result = Math.max(result, sum * (totalSum - sum));
        }

        return (int)(result % mod);
    }

    private int treeSum(TreeNode root, List<Integer> sums) {
        if (root == null) {
            return 0;
        }
        int leftSum = treeSum(root.left, sums);
        int rightSum = treeSum(root.right, sums);
        int rootSum = leftSum + rightSum + root.val;
        sums.add(rootSum);

        return rootSum;
    }
}
// @lc code=end

