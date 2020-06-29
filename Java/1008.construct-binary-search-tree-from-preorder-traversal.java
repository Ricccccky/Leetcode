import java.util.Arrays;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=1008 lang=java
 *
 * [1008] Construct Binary Search Tree from Preorder Traversal
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
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int i;
        for (i = 1; i < preorder.length; i++) {
            if (preorder[i] > preorder[0]) {
                break;
            }
        }
        root.left = bstFromPreorder(Arrays.copyOfRange(preorder, 1, i));
        root.right = bstFromPreorder(Arrays.copyOfRange(preorder, i, preorder.length));
        return root;
    }
}
// @lc code=end

