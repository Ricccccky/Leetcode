import java.util.Stack;

/*
 * @lc app=leetcode id=783 lang=java
 *
 * [783] Minimum Distance Between BST Nodes
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
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        TreeNode prev = null;
        Stack<TreeNode> temp = new Stack<>();
        while (root != null || !temp.isEmpty()) {
            if (root != null) {
                temp.push(root);
                root = root.left;
            } else {
                root = temp.pop();
                if (prev != null) {
                    result = Math.min(result, root.val - prev.val);
                }
                prev = root;
                root = root.right;
            }
        }
        return result;
    }
}
// @lc code=end

