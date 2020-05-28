import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> temp = new Stack<>();
        TreeNode pre = null;
        while (root != null || !temp.isEmpty()) {
            if (root != null) {
                temp.push(root);
                root = root.left;
            } else {
                root = temp.pop();
                if (pre != null && pre.val >= root.val) {
                    return false;
                }
                pre = root;
                root = root.right;
            }
        }
        return true;
    }
}
// @lc code=end

