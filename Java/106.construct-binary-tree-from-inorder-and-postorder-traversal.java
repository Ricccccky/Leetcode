import java.util.Arrays;

/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        int len = inorder.length;
        int rootIndex = indexOf(inorder, postorder[len - 1]);
        TreeNode root = new TreeNode(postorder[len - 1]);
        if (len > 1) {
            root.left = buildTree(Arrays.copyOfRange(inorder, 0, rootIndex), Arrays.copyOfRange(postorder, 0, rootIndex));
            root.right = buildTree(Arrays.copyOfRange(inorder, rootIndex + 1, len), Arrays.copyOfRange(postorder, rootIndex, len - 1));
        } else {
            root.left = null;
            root.right = null;
        }
        return root;
    }

    public int indexOf(int[] list, int n) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == n) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

