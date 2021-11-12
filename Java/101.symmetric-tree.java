import java.util.*;

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
        // Iterative
        // Deque<TreeNode> stack = new LinkedList<>();
        // stack.push(root.left);
        // stack.push(root.right);
        // while (!stack.isEmpty()) {
        //     TreeNode r = stack.pop();
        //     TreeNode l = stack.pop();
        //     if (l == null && r == null) {
        //         continue;
        //     } else if (l == null || r == null || l.val != r.val) {
        //         return false;
        //     }
        //     stack.push(l.left);
        //     stack.push(r.right);
        //     stack.push(l.right);
        //     stack.push(r.left);
        // }

        // return true;

        // Recursive
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 != null && t2 != null && t1.val == t2.val) {
            return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
        } else {
            return false;
        }
    }
}
// @lc code=end

