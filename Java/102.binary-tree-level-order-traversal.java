import java.util.*;

/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> temp = new LinkedList<>();
        TreeNode top = null;
        int len;
        temp.offer(root);
        while (!temp.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            len = temp.size();
            for (int i = 0; i < len; i++) {
                top = temp.remove();
                level.add(top.val);
                if (top.left != null) {
                    temp.offer(top.left);
                }
                if (top.right != null) {
                    temp.offer(top.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
// @lc code=end

