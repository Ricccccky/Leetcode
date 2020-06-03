import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode cur = root;
        int leftHeight = 0;
        while (cur != null) {
            leftHeight++;
            cur = cur.left;
        }
        int rightHeight = 0;
        cur = root;
        while (cur != null) {
            rightHeight++;
            cur = cur.right;
        }

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}
// @lc code=end

