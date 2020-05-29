import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> temp = new LinkedList<>();
        TreeNode top = null;
        int len;
        temp.offer(root);
        while(!temp.isEmpty()) {
            len = temp.size();
            List<Integer> level = new ArrayList<>();
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
            result.add(0, level);
        }
        return result;
    }
}
// @lc code=end

