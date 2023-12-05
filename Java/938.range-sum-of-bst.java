/*
 * @lc app=leetcode id=938 lang=java
 *
 * [938] Range Sum of BST
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int res = 0;
        if (root == null) {
            return res;
        }
        if (root.val >= low && root.val <= high) {
            res += root.val;
            res += rangeSumBST(root.left, low, high);
            res += rangeSumBST(root.right, low, high);
        } else if (root.val < low) {
            res += rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            res += rangeSumBST(root.left, low, high);
        }

        return res;
    }
}
// @lc code=end

