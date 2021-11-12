import java.util.*;

/*
 * @lc app=leetcode id=538 lang=java
 *
 * [538] Convert BST to Greater Tree
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
    public TreeNode convertBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode ptr = root;
        int sum = 0;
        while (ptr != null || !stack.isEmpty()) {
            if (ptr != null) {
                stack.addLast(ptr);
                ptr = ptr.right;
            } else {
                ptr = stack.removeLast();
                ptr.val += sum;
                sum = ptr.val;
                ptr = ptr.left;
            }
        }

        return root;
    }
}
// @lc code=end

