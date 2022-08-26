import java.util.*;

/*
 * @lc app=leetcode id=333 lang=java
 *
 * [333] Largest BST Subtree
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
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isBST(root)) {
            return countNode(root);
        }

        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val >= minNode(root.right)) {
            return false;
        }
        if (root.val <= maxNode(root.left)) {
            return false;
        }

        return isBST(root.left) && isBST(root.right);
    }

    private int maxNode(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        return Math.max(root.val, Math.max(maxNode(root.left), maxNode(root.right)));
    }

    private int minNode(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        return Math.min(root.val, Math.min(minNode(root.left), minNode(root.right)));
    }

    private int countNode(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNode(root.left) + countNode(root.right);
    }
}
// @lc code=end

