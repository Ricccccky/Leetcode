import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> temp = new LinkedList<>();
        TreeNode top = null;
        temp.offer(root);
        int len;
        int result = 1;
        while (!temp.isEmpty()) {
            len = temp.size();
            for (int i = 0; i < len; i++) {
                top = temp.remove();
                if (top.left == null && top.right == null) {
                    return result;
                }
                if (top.left != null) {
                    temp.offer(top.left);
                }
                if (top.right != null) {
                    temp.offer(top.right);
                }
            }
            result++;
        }
        return result;
    }
}
// @lc code=end

