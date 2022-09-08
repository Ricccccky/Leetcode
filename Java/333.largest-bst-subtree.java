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
    private TreeNode prev;
    public int largestBSTSubtree(TreeNode root) {
        prev = null;
        if (isBST(root)) {
            return countNode(root);
        }

        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isBST(root.left)) {
            return false;
        }
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;

        return isBST(root.right);
    }

    private int countNode(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNode(root.left) + countNode(root.right);
    }
}
// @lc code=end

