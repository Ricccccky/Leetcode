/*
 * @lc app=leetcode id=450 lang=java
 *
 * [450] Delete Node in a BST
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
    public TreeNode deleteNode(TreeNode root, int key) {
        // Search for the node to remove
        if (!isNode(root, key)) {
            return root;
        }

        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // flooring the root
            TreeNode precursor = findMax(root.left);
            precursor.left = deletePrecursor(root.left);
            precursor.right = root.right;
            return precursor;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else {
            root.right = deleteNode(root.right, key);
            return root;
        }
    }

    public TreeNode findMax(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public TreeNode deletePrecursor(TreeNode root) {
        // find the left child of precursor and connect it to the right of precursor's parent
        if (root.right == null) {
            return root.left;
        }
        root.right = deletePrecursor(root.right);
        return root;
    }

    public boolean isNode(TreeNode root, int key) {
        if (root == null) {
            return false;
        }
        if (root.val == key) {
            return true;
        } else if (root.val > key) {
            return isNode(root.left, key);
        } else {
            return isNode(root.right, key);
        }
    }
}
// @lc code=end

