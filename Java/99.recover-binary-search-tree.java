import java.util.Stack;

/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
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
    TreeNode e1 = null;
    TreeNode e2 = null;
    TreeNode pre = null;
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root);
        int temp = e1.val;
        e1.val = e2.val;
        e2.val = temp;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (pre != null && pre.val >= root.val) {
            if (e1 == null) {
                e1 = pre;
            }
            e2 = root;
        }
        pre = root;
        inorder(root.right);
    }
}
// @lc code=end

