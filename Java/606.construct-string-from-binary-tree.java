/*
 * @lc app=leetcode id=606 lang=java
 *
 * [606] Construct String from Binary Tree
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
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        String left = tree2str(t.left);
        String right = tree2str(t.right);

        if (left == "" && right != "") {
            return t.val + "()(" + right + ")";
        } else if (left != "" && right == "") {
            return t.val + "(" + left + ")";
        } else if (left != "" && right != "") {
            return t.val + "(" + left + ")(" + right + ")";
        } else {
            return t.val + "";
        }
    }
}
// @lc code=end

