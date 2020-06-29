/*
 * @lc app=leetcode id=998 lang=java
 *
 * [998] Maximum Binary Tree II
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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val < val) {
            TreeNode head = new TreeNode(val);
            head.left = root;
            return head;
        }
        TreeNode prev = root;
        TreeNode head = root.right;
        while (head != null) {
            if (head.val < val) {
                TreeNode temp = new TreeNode(val);
                temp.left = prev.right;
                prev.right = temp;
                return root;
            }
            prev = head;
            head = head.right;
        }
        prev.right = new TreeNode(val);
        return root;
    }
}
// @lc code=end

