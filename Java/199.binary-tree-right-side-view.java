import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> temp = new LinkedList<>();
        int len;
        temp.offer(root);
        while (!temp.isEmpty()) {
            len = temp.size();
            for (int i = 0; i < len; i++) {
                root = temp.poll();
                if (root.left != null) {
                    temp.offer(root.left);
                }
                if (root.right != null) {
                    temp.offer(root.right);
                }
            }
            result.add(root.val);
        }
        return result;
    }
}
// @lc code=end

