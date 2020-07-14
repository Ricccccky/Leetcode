import java.util.Arrays;

/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return TreeBuilder(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode TreeBuilder(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                rootIndex = i;
                break;
            }
        }
        root.left = TreeBuilder(preorder, inorder, preStart + 1, inStart, rootIndex - 1);
        root.right = TreeBuilder(preorder, inorder, preStart + (rootIndex - inStart) + 1, rootIndex + 1, inEnd);
        return root;
    }
}
// @lc code=end

