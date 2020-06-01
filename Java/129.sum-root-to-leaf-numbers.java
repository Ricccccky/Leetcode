import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        Queue<TreeNode> temp = new LinkedList<>();
        temp.offer(root);
        while (!temp.isEmpty()) {
            root = temp.poll();
            if (root.left == null && root.right == null) {
                result += root.val;
            }
            if (root.left != null) {
                root.left.val += 10 * root.val;
                temp.offer(root.left);
            }
            if (root.right != null) {
                root.right.val += 10 * root.val;
                temp.offer(root.right);
            }
        }
        return result;
    }
}
// @lc code=end

