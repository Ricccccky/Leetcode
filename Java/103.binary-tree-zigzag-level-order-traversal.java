import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> temp = new LinkedList<>();
        TreeNode top = null;
        int len;
        boolean flag = true;
        temp.offer(root);
        while (!temp.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            len = temp.size();
            if (flag) {
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
                flag = false;
            } else {
                for (int i = 0; i < len; i++) {
                    top = temp.remove();
                    level.add(0, top.val);
                    if (top.left != null) {
                        temp.offer(top.left);
                    }
                    if (top.right != null) {
                        temp.offer(top.right);
                    }
                }
                flag = true;
            }
            result.add(level);
        }
        return result;
    }
}
// @lc code=end

