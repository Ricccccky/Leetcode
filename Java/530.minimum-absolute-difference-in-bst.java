import java.util.*;

/*
 * @lc app=leetcode id=530 lang=java
 *
 * [530] Minimum Absolute Difference in BST
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
    public int getMinimumDifference(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        int res = Integer.MAX_VALUE;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.addLast(root);
                root = root.left;
            } else {
                root = stack.removeLast();
                if (pre != null) {
                    res = Math.min(res, Math.abs(pre.val - root.val));
                }
                pre = root;
                root = root.right;
            }
        }

        return res;
    }
}
// @lc code=end

