/*
 * @lc app=leetcode id=671 lang=java
 *
 * [671] Second Minimum Node In a Binary Tree
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
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return -1;
        }

        int leftMin = root.left.val;
        int rightMin = root.right.val;
        if (root.val == root.left.val) {
            leftMin = findSecondMinimumValue(root.left);
        }
        if (root.val == root.right.val) {
            rightMin = findSecondMinimumValue(root.right);
        }
        if (leftMin != -1 && rightMin != -1) {
            return Math.min(leftMin, rightMin);
        } else if (leftMin != -1) {
            return leftMin;
        } else if (rightMin != -1) {
            return rightMin;
        } else {
            return -1;
        }
    }
}
// @lc code=end

