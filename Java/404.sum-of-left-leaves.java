import java.util.*;

/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
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
    public int sumOfLeftLeaves(TreeNode root) {
        // Iterative
        // if (root == null) {
        //     return 0;
        // }
        // int result = 0;
        // Queue<TreeNode> temp = new LinkedList<>();
        // temp.offer(root);
        // while (!temp.isEmpty()) {
        //     root = temp.poll();
        //     if (root.left != null) {
        //         if (root.left.left == null && root.left.right == null) {
        //             result += root.left.val;
        //         }
        //         temp.offer(root.left);
        //     }
        //     if (root.right != null) {
        //         temp.offer(root.right);
        //     }
        // }

        // return result;

        // Recursive
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }

        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
// @lc code=end

