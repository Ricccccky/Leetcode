import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
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
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        TreeNode pre = null;
        int count = 1;
        int max = 0;
        Stack<TreeNode> temp = new Stack<>();
        List<Integer> modes = new ArrayList<>();
        while (root != null || !temp.isEmpty()) {
            if (root != null) {
                temp.push(root);
                root = root.left;
            } else {
                root = temp.pop();
                if (pre != null) {
                    if (root.val == pre.val) {
                        count++;
                    } else {
                        count = 1;
                    }
                }
                if (count > max) {
                    max = count;
                    modes.clear();
                    modes.add(root.val);
                } else if (count == max) {
                    modes.add(root.val);
                }
                pre = root;
                root = root.right;
            }
        }
        return modes.stream().mapToInt(Integer::valueOf).toArray();
    }
}
// @lc code=end

