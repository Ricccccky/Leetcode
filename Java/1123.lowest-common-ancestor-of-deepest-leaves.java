/*
 * @lc app=leetcode id=1123 lang=java
 *
 * [1123] Lowest Common Ancestor of Deepest Leaves
 */

// @lc code=start

import java.util.*;

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
    private Map<TreeNode, Integer> heights = new HashMap<>();
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        
        if (root == null || getHeight(root.left) == getHeight(root.right)) {
            return root;
        }
        if (getHeight(root.left) > getHeight(root.right)) {
            return lcaDeepestLeaves(root.left);
        } else {
            return lcaDeepestLeaves(root.right);
        }
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (heights.containsKey(root)) {
            return heights.get(root);
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        heights.put(root, Math.max(leftHeight, rightHeight) + 1);

        return heights.get(root);
    }
}
// @lc code=end

