import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
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
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode r = stack.pop();
            TreeNode l = stack.pop();
            if (l == null && r == null) {
                continue;
            } else if (l == null || r == null || l.val != r.val) {
                return false;
            }
            stack.push(l.left);
            stack.push(r.right);
            stack.push(l.right);
            stack.push(r.left);
        }

        return true;
    }
}
// @lc code=end

