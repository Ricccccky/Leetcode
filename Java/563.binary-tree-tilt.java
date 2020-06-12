import java.util.HashMap;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=563 lang=java
 *
 * [563] Binary Tree Tilt
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
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        HashMap<TreeNode, Integer> temp = new HashMap<>();
        findSum(root, temp);
        for (Map.Entry<TreeNode, Integer> k : temp.entrySet()) {
            result += k.getValue();
        }
        return result;
    }

    private int findSum(TreeNode root, HashMap<TreeNode, Integer> data) {
        if (root == null) {
            return 0;
        }
        int left = findSum(root.left, data);
        int right = findSum(root.right, data);
        data.put(root, Math.abs(left - right));
        return left + right + root.val;
    }
}
// @lc code=end

